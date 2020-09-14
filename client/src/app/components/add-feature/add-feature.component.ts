import { Component, OnInit, Injectable, Inject } from "@angular/core";
import { Router } from '@angular/router';
import { FeatureService } from "src/app/services/feature.service";

@Component({
  selector: "app-add-feature",
  templateUrl: "./add-feature.component.html",
  styleUrls: ["./add-feature.component.css"],
  providers: [FeatureService],
})
export class AddFeatureComponent implements OnInit {
  feature = {
    title: "",
    description: "",
    client: "",
    clientPriority: "",
    targetDate: "",
    productArea: "",
  };
  submitted = false;

  constructor(@Inject(FeatureService) private featureService: FeatureService, private router: Router) {}

  ngOnInit() {}

  saveFeature() {
    const data = {
      title: this.feature.title,
      description: this.feature.description,
      client: this.feature.client,
      clientPriority: this.feature.clientPriority,
      targetDate: this.feature.targetDate,
      productArea: this.feature.productArea,
    };
    console.log(this.feature)
    this.featureService.create(data).subscribe(
      (response:any) => {
        console.log(response);
        if(response.success){
          alert("Feature Request created successfully for "+ this.feature.title)
          this.router.navigate(["/features"]);
        }
        this.submitted = true;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  
  newFeature() {
    this.submitted = false;
    this.feature = {
      title: "",
      description: "",
      client: "",
      clientPriority: "",
      targetDate: "",
      productArea: "",
    };
  }
}
