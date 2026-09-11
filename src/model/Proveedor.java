package model;

public class Proveedor extends Usuario {

    public Proveedor(String cedula, String nombre, String correo){
        super(cedula, nombre, correo);
    }

    @Override
    public String panelInicio(){
        return "Panel del Proveedor";
    }
}
