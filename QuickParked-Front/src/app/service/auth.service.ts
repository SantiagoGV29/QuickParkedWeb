import { Injectable } from '@angular/core';
import { BehaviorSubject, tap } from 'rxjs';
import { ServicioService } from './servicio.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _itsLoggedIn$ = new BehaviorSubject<boolean>(false); 
  itsLoggedIn$ = this._itsLoggedIn$.asObservable();

  
  
  constructor(private service: ServicioService) { 
    const token = localStorage.getItem('token');
    this._itsLoggedIn$.next(!!token);
  }

  login (username: string, password: string){
    return this.service.getToken(username, password).pipe(
      tap(response => {
        this._itsLoggedIn$.next(true);
        localStorage.setItem('token', response[<any>'token'])
      })
    )
  }
}
