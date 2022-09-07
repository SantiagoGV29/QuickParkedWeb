import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { UserParking } from '../models/UserParking'
@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  constructor(private http : HttpClient) { }

  url = 'http://localhost:8080/';

  /*
  getLibros(){
    return this.http.get<Libro[]>(this.url+"libros");
  }
  */

  iniciarSesion(usuario:UserParking){
    return this.http.post<UserParking>(this.url+"login",usuario);
  }

  /*
  getLibroId(id:number){
    return this.http.get<Libro>(this.url+"libro/"+id);
  }
  deleteLibro(libro:Libro){
    return this.http.delete<Libro>(this.url+"libro/"+libro.id);
  }*/


}
