package model;

public class Cliente extends Usuario{

    public Cliente(String cedula, String nombre, String correo){
        super(cedula, nombre, correo);
    }

    @Override
    public String panelInicio(){
        return "Panel del Cliente";
    }
}
