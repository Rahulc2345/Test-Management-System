import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from './view/view.component';
import { UploadComponent } from './upload/upload.component';
import { HeaderComponent } from "src/app/header/header.component";
import { AuthGuardService } from './shared/auth-guard.service';
import { LoginComponent } from "src/app/login/login.component";

const routes: Routes = [ 
  { path: 'view', component: ViewComponent, canActivate:[AuthGuardService] },
  { path: 'test', component: HeaderComponent, canActivate:[AuthGuardService] },
  { path: 'upload',  component: UploadComponent, canActivate:[AuthGuardService] }, 
  { path: 'login',  component: LoginComponent }
  // { path: 'logout',  component: LogoutComponent, canActivate:[AuthGuardService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

