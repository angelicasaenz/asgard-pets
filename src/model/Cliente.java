package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{

    private List<Mascota> mascotasAdoptadas = new ArrayList<>();


    public Cliente(String cedula, String nombre){

        super(cedula, nombre, "Sin Correo");
        this.mascotasAdoptadas = new ArrayList<>();

    }


    @Override
    public String panelInicio(){

        return "Panel del Cliente";
    }

    public void agregarAdopcion(Mascota mascota){
        mascotasAdoptadas.add(mascota);
    }

    public void listadoMascotasAdoptadas(){
        System.out.println("**** MASCOTAS ADOPTADAS POR " + getNombre().toUpperCase() + " ****");
        if (mascotasAdoptadas.isEmpty()){
            System.out.println("Este Cliente no ha adoptado ninguna mascota");
        } else {
            for (Mascota mascota : mascotasAdoptadas){
                System.out.println("- ID " + mascota.getId() + " | Nombre: " + mascota.getNombre() + " | Especie: " + mascota.getEspecie());

            }
    }
    }

}
