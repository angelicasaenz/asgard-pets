package com.asgard.pets.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asgard.pets.backend.dto.UsuarioDTO;
import com.asgard.pets.backend.dto.UsuarioRequest;
import com.asgard.pets.backend.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{cedula}")
    public UsuarioDTO buscarPorCedula(@PathVariable String cedula) {
        return service.buscarPorCedula(cedula);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody UsuarioRequest request) {
        UsuarioDTO creado = service.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}