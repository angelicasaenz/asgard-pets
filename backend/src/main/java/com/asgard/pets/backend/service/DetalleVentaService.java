package com.asgard.pets.backend.service;

import com.asgard.pets.backend.dto.DetalleVentaRequest;
import com.asgard.pets.backend.dto.DetalleVentaResponse;
import com.asgard.pets.backend.model.DetalleVenta;
import com.asgard.pets.backend.model.Producto;
import com.asgard.pets.backend.model.Venta;
import com.asgard.pets.backend.repository.DetalleVentaRepository;
import com.asgard.pets.backend.repository.ProductoRepository;
import com.asgard.pets.backend.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository,
                               VentaRepository ventaRepository,
                               ProductoRepository productoRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
    }

    public List<DetalleVentaResponse> obtenerTodos() {
        return detalleVentaRepository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public DetalleVentaResponse registrarDetalle(DetalleVentaRequest request) {
        Venta venta = ventaRepository.findById(request.getVentaId())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + request.getVentaId()));

        Producto producto = productoRepository.findById(request.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + request.getProductoId()));

        // 1. Validar si hay stock disponible
        if (producto.getStock() < request.getCantidad()) {
            throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre() + ". Stock disponible: " + producto.getStock());
        }

        // 2. Descontar el stock
        producto.setStock(producto.getStock() - request.getCantidad());
        productoRepository.save(producto);

        // 3. Calcular subtotal (cantidad * precio)
        Double subtotal = producto.getPrecio() * request.getCantidad();

        // 4. Crear y guardar el detalle
        DetalleVenta detalle = new DetalleVenta();
        detalle.setVenta(venta);
        detalle.setProducto(producto);
        detalle.setCantidad(request.getCantidad());

        DetalleVenta detalleGuardado = detalleVentaRepository.save(detalle);

        // 5. Actualizar el total de la venta acumulado
        Double totalActual = (venta.getTotal() != null) ? venta.getTotal() : 0.0;
        venta.setTotal(totalActual + subtotal);
        ventaRepository.save(venta);

        return convertirAResponse(detalleGuardado, subtotal);
    }

    public void eliminar(Long id) {
        detalleVentaRepository.deleteById(id);
    }

    private DetalleVentaResponse convertirAResponse(DetalleVenta detalle) {
        Double subtotal = 0.0;
        if (detalle.getProducto() != null && detalle.getProducto().getPrecio() != null && detalle.getCantidad() != null) {
            subtotal = detalle.getProducto().getPrecio() * detalle.getCantidad();
        }
        return convertirAResponse(detalle, subtotal);
    }

    private DetalleVentaResponse convertirAResponse(DetalleVenta detalle, Double subtotal) {
        String nombreProducto = (detalle.getProducto() != null) ? detalle.getProducto().getNombre() : "Sin Producto";
        Long ventaId = (detalle.getVenta() != null) ? detalle.getVenta().getId() : null;

        return new DetalleVentaResponse(
                detalle.getId(),
                ventaId,
                nombreProducto,
                detalle.getCantidad(),
                subtotal
        );
    }
}