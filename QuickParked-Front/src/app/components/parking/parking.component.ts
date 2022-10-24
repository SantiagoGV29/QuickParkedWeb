import { Component, OnInit, ViewChild } from '@angular/core';
import {Router} from '@angular/router';
import { Subject } from 'rxjs';

import { ServicioService } from 'src/app/service/servicio.service';
import { TablaVehiculosComponent } from '../tabla-vehiculos/tabla-vehiculos.component';
import {MatDialog} from '@angular/material/dialog';
import { PagoComponent } from '../pago/pago.component';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  private ref = new Subject <void> ();
  @ViewChild(TablaVehiculosComponent) hijo: TablaVehiculosComponent;


  constructor(private router:Router, private service:ServicioService, public dialog: MatDialog) {

   }
  //constructor(private router:Router, private service:ServicioService) { }

  ngOnInit(): void {
  }

  refresh(dato: string){
    if (dato == 'refresh'){
      this.hijo.getVehicles();
    }
  }

  openDialog(): void {

    //this.router.navigate(["payment"]);

    const dialogRef = this.dialog.open(PagoComponent, {
      //width: '250px',
      data: {},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });

  }

}
