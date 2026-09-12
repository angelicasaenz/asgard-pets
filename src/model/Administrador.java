package model;

public class Administrador extends Usuario{

    public Administrador(String cedula, String nombre, String correo){
        super(cedula, nombre, correo);
    }

    @Override
    public String panelInicio(){
        return "Panel del Administrador";
    }
}
