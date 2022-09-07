import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ServicioService } from 'src/app/service/servicio.service';


@Component({
  selector: 'app-insertar-vehiculo',
  templateUrl: './insertar-vehiculo.component.html',
  styleUrls: ['./insertar-vehiculo.component.css']
})
export class InsertarVehiculoComponent implements OnInit {

  constructor(private router:Router,private service: ServicioService) { }

  ngOnInit(): void {
  }

  Pagar(){}

}
