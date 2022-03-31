import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";

const routes: Routes=[
  { path: '', redirectTo: 'partnerHome', pathMatch: 'full' }
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