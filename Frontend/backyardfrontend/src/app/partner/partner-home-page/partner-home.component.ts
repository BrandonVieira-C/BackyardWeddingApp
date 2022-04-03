import { Component, OnInit } from "@angular/core";
import { Backyard } from "src/app/shared/entity/Backyard";
import { Partner } from "src/app/shared/entity/Partner";
import { PartnerHomeService } from "./partner-home.service";


@Component({
  selector:'partner-home',
  templateUrl:'./partner-home.component.html'
})

export class PartnerHomePageComponent implements OnInit { 

  backyardList: Backyard[]
  loggedInPartner: Partner;

  constructor(private partnerHomeService: PartnerHomeService) { }

  ngOnInit(): void {
    this.loggedInPartner = JSON.parse(sessionStorage.getItem('partner') || '{}');
    this.partnerHomeService.getPartnerBackyards(this.loggedInPartner.partnerId).subscribe(
      backyard => {
        this.backyardList = backyard;
        console.log(this.backyardList);
        sessionStorage.setItem("backyard", JSON.stringify(this.backyardList));
      }
    )
  }

}