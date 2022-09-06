import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Vehiculo } from 'src/app/models/Vehiculo';
import { ServicioService } from '../../services/servicio.service';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
  }

}
