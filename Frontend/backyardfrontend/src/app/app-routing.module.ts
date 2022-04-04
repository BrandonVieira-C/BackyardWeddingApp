import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PartnerDashboardComponent } from "./dashboard/partner-dashboard/partner-dashboard.component";
import { HomeComponent } from "./home/home.component";
import { PartnerLoginComponent } from "./login/partner-login/partner-login.component";
import { PartnerSignupComponent } from "./signup/partner-signup/partner-signup.component";

const routes: Routes=[
  { path: '', redirectTo:'home', pathMatch:'full'},
  { path: 'home', component: HomeComponent},
  { path: 'partner-login', component: PartnerLoginComponent},
  { path: 'partner-signup', component: PartnerSignupComponent},
  { path: 'partner-dashboard', component: PartnerDashboardComponent}
]

@NgModule({
  declarations:[],
  imports:[
    RouterModule.forRoot(routes)
  ],
  exports:[
    RouterModule
  ]
})

export class AppRoutingModule {}