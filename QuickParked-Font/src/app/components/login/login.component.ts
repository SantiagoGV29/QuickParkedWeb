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

  _user!: string;
  _pass! : string;

  constructor(private router:Router, private service: ServicioService) { }

  ngOnInit(): void {
  }

  autentic (){
  
    console.log(this._user + " " + this._pass);
    this.service.getToken(this._user, this._pass)
    .subscribe(
      (response) => {                           //Next callback
        console.log('response received')
        localStorage.setItem('token', response[<any>'token'])
        this.router.navigate(['/parking']);
      },
      (_error) => {                              //Error callback
        alert("usuario o contraseña incorrecta");
      }
    )
  }

}
