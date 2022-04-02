import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PartnerHomePageComponent } from "./partner-home-page/partner-home-page.component";
import { PartnerLoginRegistrationComponent } from "./partner-landing-page/login-registration.component";




const routes : Routes = [
  { path: 'partnerLanding', component:PartnerLoginRegistrationComponent, children:[
    // login
    // register
  ]},
  { path: 'partnerHome', component:PartnerHomePageComponent, children: [
    // view all backyards
  ]}
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PartnerRoutingModule { }