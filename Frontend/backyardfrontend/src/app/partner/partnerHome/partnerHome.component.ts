import { HttpErrorResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Partner } from "src/app/shared/entity/Partner";
import { PartnerHomeService } from "./partnerHome.service";

@Component({
  selector:"partnerHome",
  templateUrl: './partnerHome.component.html'
})



export class PartnerHomeComponent implements OnInit{
  public partners: Partner[];


  constructor(private partnerHomeService: PartnerHomeService) { }

  ngOnInit(): void {
    this.getPartners();
  }

  public getPartners(): void {
    this.partnerHomeService.getAllPartner().subscribe(
      (response: Partner[]) => {
        this.partners = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }




}