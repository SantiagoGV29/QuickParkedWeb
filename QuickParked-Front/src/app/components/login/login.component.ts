import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { ServicioService } from 'src/app/service/servicio.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  _user!: string;
  _pass! : string;

  constructor(private router:Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  autentic (){
    console.log(this._user + " " + this._pass);
    this.authService.login(this._user, this._pass)
    .subscribe(
      (response) => {                           //Next callback
        console.log('response received')
        this.router.navigate(['/parking']);
      },
      (_error) => {                              //Error callback
        alert("usuario o contraseña incorrecta");
      }
    )
  }

}
