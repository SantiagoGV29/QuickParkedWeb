import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Vehiculo } from 'src/app/models/Vehiculo';
import { ServicioService } from '../../services/servicio.service';
@Component({
  selector: 'app-tabla-vehiculos',
  templateUrl: './tabla-vehiculos.component.html',
  styleUrls: ['./tabla-vehiculos.component.css']
})
export class TablaVehiculosComponent implements OnInit {

  vehiculos:Vehiculo[];
  p: number=1;
  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
    /*
    this.service.getLibros().subscribe(data=>{
      this.libros=data;
    })
    */
  }

}
