package com.asgard.pets.backend.service;

import com.asgard.pets.backend.model.Venta;
import com.asgard.pets.backend.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {


    private final VentaRepository ventaRepository;


    public VentaService(VentaRepository ventaRepository){
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> obtenerTodas(){
        return ventaRepository.findAll();
    }

    public Venta guardar(Venta venta){
        return ventaRepository.save(venta);
    }

    public Optional<Venta> obtenerPorId(Long id){
        return ventaRepository.findById(id);
    }

    public void eliminar(Long id){
        ventaRepository.deleteById(id);
    }

}

