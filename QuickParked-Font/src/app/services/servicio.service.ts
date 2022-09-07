import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { UserParking } from '../models/UserParking'

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
