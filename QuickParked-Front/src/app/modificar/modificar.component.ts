import { Component, EventEmitter, OnInit, Output, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Vehicle } from 'src/app/models/Vehicle';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ServicioService } from 'src/app/service/servicio.service';
import { TypeVehicle } from '../models/TypeVehicle';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {

  vehicle: Vehicle;
  priceService: number;
  typeVehicles: TypeVehicle[] = [];
  idTypeVehicle : number;
  typeVehicleSelect : string;
  suscription: Subscription = new Subscription;
  payvalue = new FormControl('', [Validators.required]);
  plateVehicle = new FormControl('', [Validators.required]);
  newPlateVehicle = new FormControl('', [Validators.required]);
  rateVehicle : number;


  @Output() private update = new EventEmitter<string>();
  constructor(
    private router: Router,
    private service: ServicioService,
    public dialogRef: MatDialogRef<ModificarComponent>) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.getTypeVehicles();
    this.newPlateVehicle.setValue("");

  }
  ngOnDestroy(): void {
    this.suscription.unsubscribe();
  }


  payService() {
    const valuePayString = this.payvalue.value!;
    const valuePay = Number(valuePayString);
    const licenceplate = this.vehicle.licenceplate;
    const priceService = this.priceService;

    if (valuePay < priceService) {
      alert("el valor de pago del servicio debe ser mayor");
      this.payvalue.setValue('');
      return;
    }

    this.service.payService(licenceplate, priceService, valuePay).subscribe({
      next: (res: any) => {
        console.log(res);
        alert("el cambio para el cliente es" + "$" + res);
        this.router.navigate(["parking"]);
      },
      error: (err) => {
        console.log(err);
      }
    })
    this.onNoClick();

  }
  searchPlate() {
    const plate = this.plateVehicle.value!
    this.service.getVehicle(plate).subscribe({
      next: (res: any) => {
        this.vehicle = res;
        //this.plateVehicle.setValue("");//Para que se mantenga con ese carro.
        this.service.getPrace(this.vehicle.licenceplate).subscribe({
          next: (value: any) => {
            this.priceService = value;
          },
          error: (err) => {
            console.log(err);
          },
        })
      },
      error: err => {
        console.log(err)
        alert("Placa No Encontrada");
      }
    });
  }
  getTypeVehicles() {
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
  changeTypeVehicle(_event : any){
    this.typeVehicleSelect = _event.target.value;
  }
  UpdateVehicle(){
    const newplate = this.newPlateVehicle.value!
//esto debe cambiar
    this.typeVehicles.forEach((type) => {
      if (type.typevehicle == this.typeVehicleSelect){
        this.rateVehicle = type.rate;
        this.idTypeVehicle = type.id!;
      }
    });

    const newTypeVehicle = {id: this.idTypeVehicle, typevehicle: this.typeVehicleSelect, rate: this.rateVehicle};

    ///Save the past plate to search in update.
    let pastPlate : string;
    pastPlate=this.vehicle.licenceplate;
    //
    //Si algo cambio pues hace algo si no pues se mantiene igual vehicle.
    if(newplate!=null && newplate!="" ){
      this.vehicle.licenceplate=newplate;
    }
    if(newTypeVehicle!=null){
      this.vehicle.typevehicle=newTypeVehicle;
    }
    this.service.modifyVehicle(pastPlate, this.vehicle).subscribe({
      next:(res:any)=>{
        console.log(res);
        //this.plateVehicle.setValue("");
        alert("Modificación exitosa");
        this.update.emit("refresh");
      },
      error:err=>{
        console.log(err)
      }
    });

  }
}
