package com.asgard.pets.backend.service;

import com.asgard.pets.backend.dto.VentaRequest;
import com.asgard.pets.backend.dto.VentaResponse;
import com.asgard.pets.backend.model.Usuario;
import com.asgard.pets.backend.model.Venta;
import com.asgard.pets.backend.repository.UsuarioRepository;
import com.asgard.pets.backend.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final UsuarioRepository usuarioRepository;

    public VentaService(VentaRepository ventaRepository, UsuarioRepository usuarioRepository) {
        this.ventaRepository = ventaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<VentaResponse> obtenerTodas() {
        return ventaRepository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public VentaResponse guardar(VentaRequest request) {
        // Validamos que el cliente exista en la base de datos
        Usuario cliente = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + request.getUsuarioId()));

        Venta venta = new Venta();
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(0.0);

        Venta ventaGuardada = ventaRepository.save(venta);
        return convertirAResponse(ventaGuardada, cliente.getNombre());
    }

    public VentaResponse obtenerPorId(Long id) {
        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));
        return convertirAResponse(venta, "Cliente registrado");
    }

    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }

    private VentaResponse convertirAResponse(Venta venta) {
        return convertirAResponse(venta, "Cliente registrado");
    }

    private VentaResponse convertirAResponse(Venta venta, String nombreCliente) {
        return new VentaResponse(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                nombreCliente
        );
    }
}