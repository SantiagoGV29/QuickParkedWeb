import { Component, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import {Router} from '@angular/router';
import { ServicioService } from 'src/app/service/servicio.service';
import { FormControl, Validators} from '@angular/forms';
import { TypeVehicle } from '../../models/TypeVehicle';
import { formatDate } from '@angular/common';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-insertar-vehiculo',
  templateUrl: './insertar-vehiculo.component.html',
  styleUrls: ['./insertar-vehiculo.component.css']
})
export class InsertarVehiculoComponent implements OnInit, OnDestroy {

  @Output() private update = new EventEmitter<string>();
  typeVehicles : TypeVehicle [] = [];
  plateVehicle = new FormControl ('', [Validators.required]);
  rateVehicle : number;
  idTypeVehicle : number;
  typeVehicleSelect : string;
  suscription: Subscription = new Subscription;

  constructor(private router:Router,private service: ServicioService) { }


  ngOnInit(): void {
    this.getTypeVehicles();
  }

  ngOnDestroy(): void {
    this.suscription.unsubscribe();
  }

  changeTypeVehicle(_event : any){
    this.typeVehicleSelect = _event.target.value;
  }

  addVehicle(){

    if (this.plateVehicle.hasError('required') && this.plateVehicle.dirty){
      alert("debe insertar la placa del vehiculo");
      return;
    }
    const dateString = formatDate(new Date (), "HH:mm:ss", "en-US");
    const newslotparking = {checkin : dateString};
    this.typeVehicles.forEach((type) => {
      if (type.typevehicle == this.typeVehicleSelect){
        this.rateVehicle = type.rate;
        this.idTypeVehicle = type.id!;
      }
    });

    const newTypeVehicle = {id: this.idTypeVehicle, typevehicle: this.typeVehicleSelect, rate: this.rateVehicle};

    const newVehicle = {licenceplate: this.plateVehicle.value!, slotparking: newslotparking, typevehicle: newTypeVehicle};

    this.service.addVehicle(newVehicle).subscribe({
      next:(res:any)=>{
        console.log(res);
        this.plateVehicle.setValue("");
        this.update.emit("refresh");
      },
      error:err=>{
        console.log(err)
      }
    });
  }

  getTypeVehicles(){
    this.service.getTypeVehicles()
    .subscribe(
      (response) => {                           //Next callback
        this.typeVehicles = response;
      },
      (_error) => {                              //Error callback
        alert("Tiempo de sesion activa incorrecta");
        localStorage.removeItem('token')
        this.router.navigate(['/login']);
      }
    )
    console.log(this.typeVehicles);
  }

}
