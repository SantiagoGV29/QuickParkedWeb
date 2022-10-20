import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
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
  userField = new FormControl ('', [Validators.required]);
  passField = new FormControl ('', [Validators.required]);

  constructor(private router:Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.userField.setValue("dani09barreto");
    this.passField.setValue("123");
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
