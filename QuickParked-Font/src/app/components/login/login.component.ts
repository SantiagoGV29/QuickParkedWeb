import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { UserParking } from 'src/app/models/UserParking';
import { ServicioService } from '../../services/servicio.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  usuario:UserParking = new UserParking();

  constructor(private router:Router,private service:ServicioService) { }

  ngOnInit(): void {
  }

  IniciarSesion(){
    this.service.iniciarSesion(this.usuario)
    .subscribe(data=>{
      alert("Se Inicia con Exito");
      this.router.navigate(["home"]);
    })
    alert("Usuario y Contraseña Incorrectos");
    this.router.navigate(["home"]);

  }

}
