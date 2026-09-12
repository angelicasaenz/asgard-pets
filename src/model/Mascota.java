package model;

public class Mascota {

    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private boolean adoptado;


    public Mascota(int id, String nombre, String especie, int edad){

        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.adoptado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isAdoptado() {
        return adoptado;
    }


    public void adoptar(){
        this.adoptado = true;
    }
}

