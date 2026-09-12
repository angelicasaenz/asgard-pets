package model;

public abstract class Usuario {

    private String cedula;
    private String nombre;
    private String correo;

    // Constructor
    public Usuario(String cedula, String nombre, String correo){
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters
    public String getCedula(){
        return this.cedula;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCorreo(){
        return this.correo;
    }
    // Modificadores
    public void setNombre(String nombre){
        if (!nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
        else {
            System.out.println("Nombre invalido");
        }
    }
    public void setCedula(String cedula){
        if (!cedula.trim().isEmpty()){
            this.cedula = cedula;
        }
        else {
            System.out.println("Cedula invalido");
        }
    }
    public void setCorreo(String correo){
        if (!correo.trim().isEmpty()){
            this.correo = correo;
        }
        else {
            System.out.println("Correo invalido");
        }
    }

    public abstract String panelInicio();

    @Override
    public String toString(){
        return  "Cedula: " + cedula +
                " | Nombre: " + nombre +
                " | Correo: " + correo;
    }
}
