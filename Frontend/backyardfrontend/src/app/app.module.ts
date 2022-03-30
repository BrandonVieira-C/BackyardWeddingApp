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


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    BackyardClickedComponent,
    RegisterFormPageComponent,
    LoginPageComponent,
    LocationFilterPipe
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
