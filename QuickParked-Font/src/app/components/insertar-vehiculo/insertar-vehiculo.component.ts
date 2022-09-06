import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserParking } from 'src/app/models/UserParking';
import { ServicioService } from '../../services/servicio.service';


@Component({
  selector: 'app-insertar-vehiculo',
  templateUrl: './insertar-vehiculo.component.html',
  styleUrls: ['./insertar-vehiculo.component.css']
})
export class InsertarVehiculoComponent implements OnInit {

  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
  }

  Pagar(){}

}
