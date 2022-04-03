import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Partner } from "src/app/shared/entity/Partner";
import { PartnerLoginRegistrationService } from "./login-registration.service"

@Component({
  selector: "login-registration",
  templateUrl: './login-registration.component.html'
})

export class PartnerLoginRegistrationComponent implements OnInit {
  errMsg: string;
  successMsg: string;

  constructor(
    private partnerLoginRegistrationService: PartnerLoginRegistrationService, 
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllPartner();

    this.createRegisterForm();

    this.loginPartner = new Partner();
    this.createLoginForm();
  }

  /* ====================================================================================================================================================== */
  // Function to get all registered partners
  partnersInDB: Partner[];

  public getAllPartner(): void {
    this.partnerLoginRegistrationService.getAllPartner().subscribe({
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
  // Function to register new partner which will also update table
  addPartnerForm: FormGroup;
  newPartner: Partner = new Partner;

  public createRegisterForm(): void {   // can be used for frontend validations when adding new partner?
    this.addPartnerForm = this.fb.group({
      firstName: [this.newPartner.firstName, [Validators.required], null],
      lastName: [this.newPartner.lastName, [Validators.required], null]
    });
  }

  public onAddPartner(): void {
    this.errMsg = '';
    this.successMsg = '';
    this.newPartner = this.addPartnerForm.value as Partner; // passing values into Partner, then into service
    this.partnerLoginRegistrationService.addPartner(this.newPartner).subscribe({
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
  // Function to delete partner which will also auto update table
  deletePartner: Partner = new Partner;

  public onDeletePartner(deletePartner: Partner): void {
    this.partnerLoginRegistrationService.deletePartner(deletePartner.partnerId).subscribe({
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

  /* ====================================================================================================================================================== */
  // Function to login partner
  loginPartner: Partner = new Partner;
  tryToLogin: boolean = false;
  loginPartnerForm: FormGroup;

  public createLoginForm(): void {
    this.loginPartnerForm = this.fb.group({
      partnerId: [this.loginPartner.partnerId, [Validators.required], null],
      firstName: [this.loginPartner.firstName, [Validators.required], null],
      lastName: [this.loginPartner.lastName, [Validators.required], null]
    })
  }

  public onLoginPartner(): void {
    this.tryToLogin = true;
    this.errMsg = '';
    this.successMsg= '';
    this.loginPartner = this.loginPartnerForm.value as Partner;

    this.partnerLoginRegistrationService.login(this.loginPartner).subscribe({
      next: msg => {
        this.loginPartner = msg;
        sessionStorage.setItem('partner', JSON.stringify(this.loginPartner));

        this.tryToLogin = false;
        this.router.navigate(['/partnerHome']);
      }, error: msg => {
        this.tryToLogin = false;
        this.errMsg = <any> msg;
      }
    })
  }

}