package com.example.tableusuariosbc.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tableusuariosbc.entities.Usuarios;
import com.example.tableusuariosbc.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class UsuarioService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuarios> findAll() {return usuarioRepository.findAll();}
    public Usuarios findById(Integer id) {
        Optional<Usuarios> obj = usuarioRepository.findById(Long.valueOf(id));
        return obj.get();
    }
    public Usuarios registro (Usuarios obj){
        return usuarioRepository.save(obj);
    }
    public void deletar(Integer id) {
        usuarioRepository.deleteById(Long.valueOf(id));
    }
    
    @Transactional
    public Usuarios atualizar(Long id, Usuarios obj) {
    
        Usuarios usuarios = usuarioRepository.getReferenceById(id);
        
        updateData(usuarios,obj);
        usuarioRepository.save(usuarios);
        return usuarios;
    }

    private void updateData(Usuarios usuarios, Usuarios obj) {
    	usuarios.setId(obj.getId());
        usuarios.setNome(obj.getNome());
        usuarios.setIdade(obj.getIdade());
    }
}
