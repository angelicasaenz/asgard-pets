package com.asgard.pets.backend.service;


import com.asgard.pets.backend.model.DetalleVenta;
import com.asgard.pets.backend.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository){
        this.detalleVentaRepository = detalleVentaRepository;
    }


    public List<DetalleVenta> obtenerTodos(){
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta guardar(DetalleVenta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public Optional<DetalleVenta> obtenerPorId(Long id){
        return detalleVentaRepository.findById(id);
    }

    public void eliminar(Long id){
        detalleVentaRepository.deleteById(id);
    }

}
