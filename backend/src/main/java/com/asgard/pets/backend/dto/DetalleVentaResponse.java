package com.asgard.pets.backend.dto;

public class DetalleVentaResponse {

    private Long id;
    private Long ventaId;
    private String nombreProducto;
    private Integer cantidad;
    private Double subtotal;

    public DetalleVentaResponse() {}

    public DetalleVentaResponse(Long id, Long ventaId, String nombreProducto, Integer cantidad, Double subtotal) {
        this.id = id;
        this.ventaId = ventaId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}