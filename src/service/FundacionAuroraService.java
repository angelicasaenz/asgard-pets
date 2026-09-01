package service;

import model.Mascota;

import java.util.ArrayList;
import java.util.List;

public class FundacionAuroraService {

    private List<Mascota> mascotas = new ArrayList<>();

    public FundacionAuroraService(){
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

    public void mostrarMascotas(){
        System.out.println("\n **** LISTADO DE MASCOTAS DISPONIBLES PARA ADOPCIÓN ****");
        boolean hayMascotas = false;
        for (Mascota m : mascotas){
            if (!m.isAdoptado()){
                System.out.println("- " + m.getId() + " | " + m.getNombre() + " | " + m.getEspecie() + " | " + m.getEdad() + " años.");
                hayMascotas = true;
            }
        }
        if (!hayMascotas){
            System.out.println("No hay mascotas disponibles para la adoción");

        }
    }
}
