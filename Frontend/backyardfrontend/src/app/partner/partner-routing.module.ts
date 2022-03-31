import { NgModule } from "@angular/core";
import { Router, RouterModule, Routes } from "@angular/router";
import { PartnerHomeComponent } from "./partnerHome/partnerHome.component";




const routes : Routes = [
  { path: 'partnerHome', component: PartnerHomeComponent, children:[
    //login
    //add backyard
  ]}
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class PartnerRoutingModule { }