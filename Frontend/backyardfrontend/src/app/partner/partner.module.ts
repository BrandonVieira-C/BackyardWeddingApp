import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { PartnerRoutingModule } from "./partner-routing.module";
import { PartnerLoginRegistrationComponent } from "./partner-landing-page/login-registration.component"
import { PartnerLoginRegistrationService } from "./partner-landing-page/login-registration.service"


@NgModule({
  declarations:[
    PartnerLoginRegistrationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    PartnerRoutingModule
  ],
  providers:[
    PartnerLoginRegistrationService
  ],
  exports: []
})

export class PartnerModule {}