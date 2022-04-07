import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { PartnerDashboardComponent } from './dashboard/partner-dashboard/partner-dashboard.component';
import { PartnerDashboardService } from './dashboard/partner-dashboard/partner-dashboard.service';
import { HomeComponent } from './home/home.component';
import { HomeService } from './home/home.service';
import { PartnerLoginComponent } from './login/partner-login/partner-login.component';
import { PartnerLoginService } from './login/partner-login/partner-login.service';
import { PartnerSignupComponent } from './signup/partner-signup/partner-signup.component';
import { PartnerSignupService } from './signup/partner-signup/partner-signup.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PartnerLoginComponent,
    PartnerSignupComponent,
    PartnerDashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    HomeService,
    PartnerLoginService,
    PartnerSignupService,
    PartnerDashboardService,
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
