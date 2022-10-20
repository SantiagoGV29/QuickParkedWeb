import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Vehicle } from 'src/app/models/Vehicle';
import { ServicioService } from 'src/app/service/servicio.service';

@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {

  constructor(private router:Router, private service:ServicioService) { }

  ngOnInit(): void {
  }

}
