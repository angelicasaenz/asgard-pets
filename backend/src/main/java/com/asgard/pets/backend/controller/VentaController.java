package com.asgard.pets.backend.controller;

import com.asgard.pets.backend.dto.VentaRequest;
import com.asgard.pets.backend.dto.VentaResponse;
import com.asgard.pets.backend.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@Tag(name = "Ventas", description = "Endpoints para la gestión de ventas de Asgard Pets")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las ventas registradas")
    public ResponseEntity<List<VentaResponse>> obtenerTodas() {
        return ResponseEntity.ok(ventaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una venta por su ID")
    public ResponseEntity<VentaResponse> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ventaService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva venta")
    public ResponseEntity<VentaResponse> guardar(@Valid @RequestBody VentaRequest request) {
        VentaResponse ventaCreada = ventaService.guardar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaCreada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una venta por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}