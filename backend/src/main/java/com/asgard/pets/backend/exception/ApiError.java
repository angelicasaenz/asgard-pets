package com.asgard.pets.backend.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {

    private int status;
    private String mensaje;
    private List<String> errores;
    private LocalDateTime timestamp;

    public ApiError() {
    }

    public ApiError(int status, String mensaje, List<String> errores) {
        this.status = status;
        this.mensaje = mensaje;
        this.errores = errores;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public List<String> getErrores() { return errores; }
    public void setErrores(List<String> errores) { this.errores = errores; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}