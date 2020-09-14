import { Component, OnInit, Inject } from "@angular/core";
import { FeatureService } from "src/app/services/feature.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-feature-details",
  templateUrl: "./feature-details.component.html",
  styleUrls: ["./feature-details.component.css"],
})
export class FeatureDetailsComponent implements OnInit {
  currentFeature = null;

  message = "";

  constructor(
    @Inject(FeatureService)
    private featureService: FeatureService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.message = "";
    this.getFeature(this.route.snapshot.paramMap.get("id"));
  }

  getFeature(id) {
    this.featureService.get(id).subscribe(
      (data:any) => {
       if(data.success){
         if(data.featureRequest){
          this.currentFeature = data.featureRequest;
          console.log(this.currentFeature)
         }
         else{
           alert("There is an error fetching the record, Please try after sometime!");
           this.router.navigate(["/features"]);
          }
       }       
      },
      (error) => {
        console.log(error);
      }
    );
    
  }


  updateFeature() {
    this.featureService
      .update(this.currentFeature.id, this.currentFeature)
      .subscribe(
        (response) => {
          console.log(response);
          this.message = "The feature was updated successfully!";
        },
        (error) => {
          console.log(error);
        }
      );
  }

  deleteFeature() {
    console.log(this.currentFeature.id)
    this.featureService.delete(this.currentFeature.id).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(["/features"]);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
