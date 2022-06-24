import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/entities/usuario/usuario.model';
import {UsuarioService} from 'src/app/entities/usuario/usuario.service';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
usuarios : Usuario [] = [];

  constructor(private usuarioservice: UsuarioService) { }

//
//    nomeUsuario ='';
//    idadeUsuario ='';
//    idUsuario = '';

  ngOnInit(): void {
  }

getAllUsers(): void {
    this.usuarioservice.getAllUser().subscribe((usuario) => (this.usuarios = usuario))
  }
}
