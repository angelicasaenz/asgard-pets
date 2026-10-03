package com.asgard.pets.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.asgard.pets.backend.dto.ProductoDTO;
import com.asgard.pets.backend.dto.ProductoRequest;
import com.asgard.pets.backend.model.Producto;
import com.asgard.pets.backend.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<ProductoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ProductoDTO buscarPorId(Long id) {
        Producto producto = buscarEntidadPorId(id);
        return convertirADTO(producto);
    }

    public ProductoDTO crear(ProductoRequest request) {
        if (repository.existsByCodigo(request.getCodigo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Ya existe un producto con el código " + request.getCodigo());
        }

        Producto producto = new Producto();
        producto.setCodigo(request.getCodigo());
        producto.setNombre(request.getNombre());
        producto.setCategoria(request.getCategoria());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        Producto guardado = repository.save(producto);
        return convertirADTO(guardado);
    }

    public ProductoDTO actualizar(Long id, ProductoRequest request) {
        Producto producto = buscarEntidadPorId(id);
        producto.setNombre(request.getNombre());
        producto.setCategoria(request.getCategoria());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        Producto actualizado = repository.save(producto);
        return convertirADTO(actualizado);
    }

    public void eliminar(Long id) {
        Producto producto = buscarEntidadPorId(id);
        repository.delete(producto);
    }

    private Producto buscarEntidadPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto con id " + id + " no encontrado"));
    }

    private ProductoDTO convertirADTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getCodigo(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getStock()
        );
    }
}