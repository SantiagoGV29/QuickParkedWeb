import { Component, OnInit, ViewChild } from '@angular/core';
import {Router} from '@angular/router';
import { Subject } from 'rxjs';
import { Vehicle } from 'src/app/models/Vehicle';
import { ServicioService } from 'src/app/service/servicio.service';
import { TablaVehiculosComponent } from '../tabla-vehiculos/tabla-vehiculos.component';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  private ref = new Subject <void> ();
  @ViewChild(TablaVehiculosComponent) hijo: TablaVehiculosComponent;

  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit(): void {
  }

  refresh(dato: string){
    if (dato == 'refresh'){
      this.hijo.getVehicles();
    }
  }

}
