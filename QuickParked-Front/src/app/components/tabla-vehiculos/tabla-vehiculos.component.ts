import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Vehicle } from 'src/app/models/Vehicle';
import { ServicioService } from 'src/app/service/servicio.service';
import { ParkingComponent } from '../parking/parking.component';

@Component({
  selector: 'app-tabla-vehiculos',
  templateUrl: './tabla-vehiculos.component.html',
  styleUrls: ['./tabla-vehiculos.component.css']
})
export class TablaVehiculosComponent implements OnInit {

  myVehicles : Vehicle [] = [];

  p: number=1;
  constructor(private router:Router,private service:ServicioService, private park:ParkingComponent ) { }

  ngOnInit(): void {
    this.getVehicles();
  }

  getVehicles(){
    this.service.getParkingVehicles()
    .subscribe(
      (response) => {                           //Next callback
        this.myVehicles = response;
      },
      (_error) => {                              //Error callback
        alert("Tiempo de sesion activa incorrecta");
        localStorage.removeItem('token')
        this.router.navigate(['/login']);
      }
    )
    console.log(this.myVehicles);
  }

  GenerarPago(){
    //this.router.navigate(["payment"]);
    this.park.openDialogPay();
  }

  Modificar(){
    //this.router.navigate(["payment"]);
    
    this.park.openDialogModify();
  }

}
