import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { catchError, Observable, throwError } from 'rxjs';
import { Vehicle } from '../models/Vehicle';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  constructor(private _http : HttpClient) { }

  url = 'http://localhost:8080/';

  /*
  getLibros(){
    return this.http.get<Libro[]>(this.url+"libros");
  }
  */

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

  getToken(_user: string, _pass : string){
    const headersUser = new HttpHeaders().set('Authorization', 'Basic ' + btoa(_user + ':' + _pass));
    const optionsUser = {
      headers: headersUser
    };
    return this._http.get <string []> (this.url + 'parking/token', optionsUser);
  }

  /*
  getLibroId(id:number){
    return this.http.get<Libro>(this.url+"libro/"+id);
  }
  deleteLibro(libro:Libro){
    return this.http.delete<Libro>(this.url+"libro/"+libro.id);
  }*/


}
