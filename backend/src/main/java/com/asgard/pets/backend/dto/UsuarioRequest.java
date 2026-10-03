package com.asgard.pets.backend.dto;

import com.asgard.pets.backend.model.Rol;

public class UsuarioRequest {

    private String cedula;
    private String nombre;
    private String email;
    private String telefono;
    private Rol rol;

    public UsuarioRequest() {
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}