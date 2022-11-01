import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';

import{FormsModule}from '@angular/forms';

import {MatDialogModule} from '@angular/material/dialog';


import{HttpClientModule}from '@angular/common/http'
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './components/login/login.component';
import { InsertarVehiculoComponent } from './components/insertar-vehiculo/insertar-vehiculo.component';
import { InfoUsuarioComponent } from './components/info-usuario/info-usuario.component';
import { TablaVehiculosComponent } from './components/tabla-vehiculos/tabla-vehiculos.component';
import { PagoComponent } from './components/pago/pago.component';
import { HomeComponent } from './components/home/home.component';

import { NgxPaginationModule } from 'ngx-pagination';
import { ParkingComponent } from './components/parking/parking.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    InsertarVehiculoComponent,
    InfoUsuarioComponent,
    TablaVehiculosComponent,
    PagoComponent,
    HomeComponent,
    ParkingComponent
  ],
  imports: [
    NgbModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbPaginationModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatDialogModule

  ],
  providers: [],//Luego se coloca el service
  bootstrap: [AppComponent]
})
export class AppModule { }
