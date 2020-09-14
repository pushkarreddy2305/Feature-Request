import { Component, OnInit } from "@angular/core";
import { FeatureService } from "src/app/services/feature.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-features-list",
  templateUrl: "./features-list.component.html",
  styleUrls: ["./features-list.component.css"],
})
export class FeaturesListComponent implements OnInit {
  features: any;
  currentFeature = null;
  currentIndex = -1;
  title = "";

  constructor(private featureService: FeatureService, private router: Router) {}

  ngOnInit() {
    this.retrieveFeatures();
  }

  retrieveFeatures() {
    this.featureService.getAll().subscribe(
      (data: any) => {
        this.features = data;
        console.log(data);
        if (data.success){
            this.features = data.featureRequest;
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
  btnClick(id) {
    this.router.navigateByUrl("/features/" + id);
   }

  deleteFeature(id) {
    this.featureService.delete(id).subscribe(
      (data) => {
        console.log(data);
        alert("Feature Request deleted successfully");
        this.retrieveFeatures();
      },
      (error) => {
        console.log(error);
        alert(error);
      }
    );
  }

  // setActiveFeature(feature, index) {
  //   this.currentFeature = feature;
  //   this.currentIndex = index;
  // }
}
