import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { PagoComponent } from './components/pago/pago.component';
import  {ParkingComponent } from './components/parking/parking.component'
import { IsAuthenticatedGuard } from './guards/is-authenticated.guard';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'home', component: HomeComponent },
  {path:'payment', component: PagoComponent, canActivate: [IsAuthenticatedGuard]},
  {path:'parking', component: ParkingComponent, canActivate: [IsAuthenticatedGuard]},
  //Este siempre de último
  {path:'**', component: HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
