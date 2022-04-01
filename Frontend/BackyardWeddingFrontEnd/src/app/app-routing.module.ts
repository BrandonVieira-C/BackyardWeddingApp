import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BackyardClickedComponent } from './backyard-clicked/backyard-clicked.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { EventsComponent } from './events/events.component';
import { FindABackyardComponent } from './find-abackyard/find-abackyard.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';
import { RegisterFormPageComponent } from './register-form-page/register-form-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';

const routes: Routes = [
 { path: '', redirectTo: 'home', pathMatch: 'full' },
 { path: 'home', component: HomePageComponent},
 { path: 'backyard/:backyardId', component: BackyardClickedComponent },
 { path: 'login', component: LoginPageComponent },
 { path: 'register', component: RegisterPageComponent },
 { path: 'backyards', component: FindABackyardComponent },
 { path: 'customer', component: CustomerRegisterComponent },
 { path: 'partner', component: PartnerRegisterComponent },
 { path: 'events', component: EventsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
