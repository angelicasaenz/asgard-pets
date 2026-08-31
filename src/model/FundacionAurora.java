package model;

import java.util.ArrayList;
import java.util.List;

public class FundacionAurora {

    private List<Mascota> mascotas = new ArrayList<>();

    public FundacionAurora(){
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public void adoptarMascota(int id){
        for (Mascota m : mascotas ){
            if (id == m.getId()){
                m.adoptar();
                System.out.println("¡Felicidades! " + m.getNombre() + " ahora tiene una familia. :) ");
                return;
            }
        }
        System.out.println("No se encontro una mascota con ese ID");
    }
}
