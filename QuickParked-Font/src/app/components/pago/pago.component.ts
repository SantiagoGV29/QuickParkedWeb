import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ServicioService } from '../../services/servicio.service';
@Component({
  selector: 'app-pago',
  templateUrl: './pago.component.html',
  styleUrls: ['./pago.component.css']
})
export class PagoComponent implements OnInit {

  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
  }


  Pagar(){
    alert("No esta disponible esta opcion");
    //this.router.navigate(["home"]);

  }
  BuscarPlaca(){
    alert("Placa No Encontrada");
  }


}
