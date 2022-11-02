import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { catchError, Observable, Subject, throwError } from 'rxjs';
import { TypeVehicle } from '../models/TypeVehicle';
import { SlotParking } from '../models/SlotParking';
import { Vehicle } from '../models/Vehicle';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private refresh = new Subject <void> ();

  constructor(private _http : HttpClient) { }

  url = 'http://localhost:8080/';

  /*
  getLibros(){
    return this.http.get<Libro[]>(this.url+"libros");
  }
  */

  getRefresh(){
    return this.refresh;
  }

  getParkingVehicles(): Observable <Vehicle[]>{
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    return this._http.get <Vehicle[]> (this.url + 'parking/vehicles', options)
    .pipe(
      catchError((err) => {
        console.log('error caught in service')
        console.error(err);
        return throwError(err);
      })
    );
  }

  getTypeVehicles (){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    return this._http.get <TypeVehicle[]> (this.url + 'parking/TypeVehicles', options)
    .pipe(
      catchError((err) => {
        console.log('error caught in service')
        console.error(err);
        return throwError(err);
      })
    );
  }

  addVehicle (vehicle : Vehicle){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    console.log(vehicle);
    return this._http.post <Vehicle> (this.url + 'parking/insert', vehicle , options);
  }

  getToken(_user: string, _pass : string){
    const headersUser = new HttpHeaders().set('Authorization', 'Basic ' + btoa(_user + ':' + _pass));
    const optionsUser = {
      headers: headersUser
    };
    return this._http.get <string []> (this.url + 'parking/token', optionsUser);
  }

  getVehicle(_plate: string){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    return this._http.get <Vehicle> (this.url + 'parking/vehicle/' + _plate, options);
  }

  getPrace (_plate: string){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    return this._http.get <number> (this.url + 'parking/pay/' + _plate , options);
  }

  payService (_plate: string, _value: number, _service: number){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    return this._http.delete <boolean> (this.url + 'parking/pay/' + _plate + '/' + _value + '/' + _service , options)
  }
  modifyVehicle (pastPlate:string, vehicle : Vehicle){
    const headers = new HttpHeaders().set('Authorization', 'Bearer '+localStorage.getItem('token'));
    const options = {
      headers: headers,
    };
    console.log(vehicle);
    return this._http.put <Vehicle> (this.url + 'parking/modify/'+pastPlate , vehicle , options);
  }
}
