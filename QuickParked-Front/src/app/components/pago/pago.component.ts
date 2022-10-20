import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { Vehicle } from 'src/app/models/Vehicle';
import { ServicioService } from 'src/app/service/servicio.service';
@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.css']
})
export class PagoComponent implements OnInit {

  vehicle: Vehicle;
  priceService : number;
  payvalue = new FormControl ('', [Validators.required]);
  plateVehicle = new FormControl ('', [Validators.required]);
  @Output() private update = new EventEmitter<string>();
  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
  }


  payService(){
    const valuePayString = this.payvalue.value!;
    const valuePay = Number (valuePayString);
    const licenceplate = this.vehicle.licenceplate;
    const priceService = this.priceService;

    if (valuePay < priceService){
      alert("el valor de pago del servicio debe ser mayor");
      this.payvalue.setValue('');
      return;
    }

    this.service.payService(licenceplate, priceService, valuePay).subscribe({
      next:(res : any) =>{
        console.log(res);
        alert("el cambio para el cliente es" + "$" +res);
        this.router.navigate(["parking"]);
      },
      error:(err) =>{
        console.log(err);
      }
    })

  }
  searchPlate(){
    const plate = this.plateVehicle.value!
    this.service.getVehicle(plate).subscribe ({
      next:(res:any)=>{
        this.vehicle = res;
        this.plateVehicle.setValue("");
        this.service.getPrace(this.vehicle.licenceplate).subscribe({
          next:(value : any) =>{
            this.priceService = value;
          },
          error:(err) =>{
              console.log(err);
          },
        })
      },
      error:err=>{
        console.log(err)
        alert("Placa No Encontrada");
      }
    });
  }


}
