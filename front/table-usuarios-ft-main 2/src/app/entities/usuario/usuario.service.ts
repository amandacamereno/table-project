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


  public saveUser(usuario: Usuario): Observable<any> {
    console.log(usuario);
    const body = JSON.stringify({nomeUsuario: usuario.nome, idadeUsuario: usuario.idade});

    return this.http.request('POST', 'http://localhost:8080/usuario', {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: body
    })
  }

  public updateUser(usuario: Usuario): Observable<any> {
    const body = JSON.stringify(usuario);

    return this.http.request('PUT', 'http://localhost:8080/usuario', {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: body
    })
  }
}
