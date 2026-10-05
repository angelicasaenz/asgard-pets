package com.asgard.pets.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.asgard.pets.backend.dto.UsuarioDTO;
import com.asgard.pets.backend.dto.UsuarioRequest;
import com.asgard.pets.backend.model.Usuario;
import com.asgard.pets.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public UsuarioDTO buscarPorCedula(String cedula) {
        Usuario usuario = repository.findByCedula(cedula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuario con cédula " + cedula + " no encontrado"));
        return convertirADTO(usuario);
    }

    public UsuarioDTO guardar(UsuarioRequest request) {
        if (repository.existsByCedula(request.getCedula())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Ya existe un usuario con la cédula " + request.getCedula());
        }

        Usuario usuario = new Usuario();
        usuario.setCedula(request.getCedula());
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(request.getRol());

        Usuario guardado = repository.save(usuario);
        return convertirADTO(guardado);
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getCedula(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getRol()
        );
    }
}