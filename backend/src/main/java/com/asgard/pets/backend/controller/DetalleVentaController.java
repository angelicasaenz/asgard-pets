package com.asgard.pets.backend.controller;

import com.asgard.pets.backend.model.DetalleVenta;
import com.asgard.pets.backend.service.DetalleVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-ventas")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    // GET: http://localhost:8080/api/detalles-ventas
    @GetMapping
    public List<DetalleVenta> obtenerTodos() {
        return detalleVentaService.obtenerTodos();
    }

    // GET: http://localhost:8080/api/detalles-ventas/1
    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> obtenerPorId(@PathVariable Long id) {
        return detalleVentaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: http://localhost:8080/api/detalles-ventas
    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardar(detalleVenta);
    }

    // DELETE: http://localhost:8080/api/detalles-ventas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleVentaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}