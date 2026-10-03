package com.asgard.pets.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.asgard.pets.backend.model.Usuario;
import com.asgard.pets.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorCedula(String cedula) {
        return repository.findByCedula(cedula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario con cédula " + cedula + " no encontrado"));
    }

    public Usuario guardar(Usuario usuario) {
        if (repository.existsByCedula(usuario.getCedula())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Ya existe un usuario con la cédula " + usuario.getCedula());
        }
        return repository.save(usuario);
    }
}