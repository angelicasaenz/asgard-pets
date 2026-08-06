package model;

public class Empleado extends Usuario{

    public Empleado(String cedula, String nombre, String correo){
        super(cedula, nombre, correo);
    }

    @Override
      public String panelInicio(){
            return "Panel del Empleado";
        }

}
