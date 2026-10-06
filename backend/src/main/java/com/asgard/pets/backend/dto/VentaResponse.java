package com.asgard.pets.backend.dto;

import java.time.LocalDateTime;

public class VentaResponse {

    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private String nombreCliente;

    public VentaResponse() {}

    public VentaResponse(Long id, LocalDateTime fecha, Double total, String nombreCliente) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.nombreCliente = nombreCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}