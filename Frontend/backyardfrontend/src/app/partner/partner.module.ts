import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { PartnerRoutingModule } from "./partner-routing.module";
import { PartnerHomeComponent } from "./partnerHome/partnerHome.component";
import { PartnerHomeService } from "./partnerHome/partnerHome.service";


@NgModule({
  declarations:[
    PartnerHomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    PartnerRoutingModule
  ],
  providers:[
    PartnerHomeService
  ],
  exports: []
})

export class PartnerModule {}