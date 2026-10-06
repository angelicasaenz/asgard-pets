package com.asgard.pets.backend.controller;

import com.asgard.pets.backend.dto.DetalleVentaRequest;
import com.asgard.pets.backend.dto.DetalleVentaResponse;
import com.asgard.pets.backend.service.DetalleVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
@Tag(name = "Detalles de Venta", description = "Endpoints para la gestión de ítems y control de stock")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los detalles de ventas")
    public ResponseEntity<List<DetalleVentaResponse>> obtenerTodos() {
        return ResponseEntity.ok(detalleVentaService.obtenerTodos());
    }

    @PostMapping
    @Operation(summary = "Agregar un producto a una venta (Valida y descuenta stock)")
    public ResponseEntity<DetalleVentaResponse> registrarDetalle(@Valid @RequestBody DetalleVentaRequest request) {
        DetalleVentaResponse detalleCreado = detalleVentaService.registrarDetalle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleCreado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un detalle de venta por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleVentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}