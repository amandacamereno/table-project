package com.example.tableusuariosbc.controller;

import com.example.tableusuariosbc.entities.Usuarios;
import com.example.tableusuariosbc.repository.UsuarioRepository;
import com.example.tableusuariosbc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll() {
        List<Usuarios> list = usuarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable Integer id) {
        Usuarios obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Usuarios> inserir(@RequestBody Usuarios obj) {
        obj = usuarioService.registro(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuarios> atualizar(@PathVariable Long id, @RequestBody Usuarios  obj) {
        obj = usuarioService.atualizar(id, obj);
        return ResponseEntity.ok().body(obj);

    }

    }

