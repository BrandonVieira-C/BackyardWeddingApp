import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Partner } from "src/app/shared/entity/Partner";
import { PartnerHomeService } from "./partnerHome.service";

@Component({
  selector: "partnerHome",
  templateUrl: './partnerHome.component.html'
})



export class PartnerHomeComponent implements OnInit {

  constructor(private partnerHomeService: PartnerHomeService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.createForm();
    this.getAllPartner();
  }

  /* ====================================================================================================================================================== */

  // function to get all registered partners
  partnersInDB: Partner[];

  public getAllPartner(): void {
    this.partnerHomeService.getAllPartner().subscribe({
      next: response => {
        console.log(response);
        this.partnersInDB = response;
      },
      error: error => {
        console.log(error);
      }
    });
  }

  /* ====================================================================================================================================================== */

  // functions to register new partner
  addPartnerForm: FormGroup;
  newPartner: Partner = new Partner;
  errMsg: string;
  successMsg: string;

  public createForm(): void {
    this.addPartnerForm = this.fb.group({
      firstName: [this.newPartner.firstName, [Validators.required], null],
      lastName: [this.newPartner.lastName, [Validators.required], null]
    });
  }

  public onAddPartner(): void {
    this.errMsg = '';
    this.successMsg = '';
    this.newPartner = this.addPartnerForm.value as Partner; // passing values into Partner, then into service
    this.partnerHomeService.addPartner(this.newPartner).subscribe({
      next: msg => {
        this.successMsg = msg;
        console.log(msg);
        this.addPartnerForm.reset();
        this.getAllPartner(); // updates table immediately
      },
      error: msg => {
        console.log(msg);
        this.errMsg = <any> msg;
      }
    })
  }

  /* ====================================================================================================================================================== */

  // function to delete registered partner

  deletePartner: Partner = new Partner;

  public onDeletePartner(deletePartner: Partner): void {
    this.partnerHomeService.deletePartner(deletePartner.partnerId).subscribe({
      next: msg => {
        this.successMsg = msg;
        console.log(msg);
        
        this.getAllPartner();

      }, error: msg => {
        console.log(msg.message);
        this.errMsg = <any>msg;
      }
    })
  }


}