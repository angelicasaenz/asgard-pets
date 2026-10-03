package com.asgard.pets.backend.dto;

import com.asgard.pets.backend.model.Rol;

public class UsuarioDTO {

    private Long id;
    private String cedula;
    private String nombre;
    private String email;
    private String telefono;
    private Rol rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String cedula, String nombre, String email, String telefono, Rol rol) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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