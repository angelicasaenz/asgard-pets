package com.asgard.pets.backend.controller;

import com.asgard.pets.backend.dto.UsuarioDTO;
import com.asgard.pets.backend.dto.UsuarioRequest;
import com.asgard.pets.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<UsuarioDTO> crear(@Valid @RequestBody UsuarioRequest request) {
        UsuarioDTO creado = service.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}