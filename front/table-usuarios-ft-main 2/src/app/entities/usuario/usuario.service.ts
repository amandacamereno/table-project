import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { Usuario } from './usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private url = 'http://localhost:8080/usuario';
    constructor(private http: HttpClient) { }
    getAllUser(): Observable<Usuario[]> {
      return this.http.get<Usuario[]>(this.url)
    }
}
