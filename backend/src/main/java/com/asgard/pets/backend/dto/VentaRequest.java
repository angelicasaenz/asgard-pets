package com.asgard.pets.backend.dto;

import jakarta.validation.constraints.NotNull;

public class VentaRequest {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long usuarioId;

    public VentaRequest() {}

    public VentaRequest(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}