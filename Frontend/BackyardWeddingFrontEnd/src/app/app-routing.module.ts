import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BackyardClickedComponent } from './backyard-clicked/backyard-clicked.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterFormPageComponent } from './register-form-page/register-form-page.component';

const routes: Routes = [
 { path: '', redirectTo: 'home', pathMatch: 'full' },
 { path: 'home', component: HomePageComponent},
 { path: 'backyard/:backyardId', component: BackyardClickedComponent },
 { path: 'login', component: LoginPageComponent },
 { path: 'register', component: RegisterFormPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
