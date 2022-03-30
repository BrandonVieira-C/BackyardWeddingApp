import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { BackyardClickedComponent } from './backyard-clicked/backyard-clicked.component';
import { RegisterFormPageComponent } from './register-form-page/register-form-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LocationFilterPipe } from './pipes/location-filter';
import { RESTService } from './REST.service';
import { HttpClientModule } from '@angular/common/http';
import { FindABackyardComponent } from './find-abackyard/find-abackyard.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { PartnerRegisterComponent } from './partner-register/partner-register.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    BackyardClickedComponent,
    RegisterFormPageComponent,
    LoginPageComponent,
    LocationFilterPipe,
    FindABackyardComponent,
    RegisterPageComponent,
    CustomerRegisterComponent,
    PartnerRegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [RESTService],
  bootstrap: [AppComponent]
})
export class AppModule { }
