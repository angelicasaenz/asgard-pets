package com.asgard.pets.backend.service;

import com.asgard.pets.backend.model.Producto;
import com.asgard.pets.backend.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto con id " + id + " no encontrado"));
    }

    public Producto crear(Producto producto) {
        if (repository.existsByCodigo(producto.getCodigo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Ya existe un producto con el código " + producto.getCodigo());
        }
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto datosNuevos) {
        Producto producto = buscarPorId(id);
        producto.setNombre(datosNuevos.getNombre());
        producto.setCategoria(datosNuevos.getCategoria());
        producto.setPrecio(datosNuevos.getPrecio());
        producto.setStock(datosNuevos.getStock());
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        Producto producto = buscarPorId(id);
        repository.delete(producto);
    }
}