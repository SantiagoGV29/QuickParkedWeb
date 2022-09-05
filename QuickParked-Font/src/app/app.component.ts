import { Component } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'QuickParked-web';
  constructor(private router: Router){}
  //Tiene que haber routes para que desaparezca el error de route en el app.component.html
}
