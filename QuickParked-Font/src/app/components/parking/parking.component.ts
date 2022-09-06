import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserParking } from 'src/app/models/UserParking';
import { Vehiculo } from 'src/app/models/Vehiculo';
import { ServicioService } from '../../services/servicio.service';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  usuario:UserParking = new UserParking();
  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
    this.usuario.userName="admin";
    //Eliminar lo anterior
  }

}
