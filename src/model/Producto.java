package model;

public abstract class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor
    public Producto(int id, String nombre, double precio, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters

    public int getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return  this.precio;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    // Modificadores
    public void setId(int id){
        if (id > 0){
            this.id = id;
        } else {
            System.out.println("Id inválido");
        }
    }
    public void setNombre(String nombre){
        if (!nombre.trim().isEmpty()){
            this.nombre = nombre;
        } else {
            System.out.println("Nombre inválido");
        }
    }
    public void setPrecio(double precio){
        if (precio >= 0){
            this.precio = precio;
        } else {
            System.out.println("Precio invalido");
        }
    }
    public void setCantidad(int cantidad){
        if (cantidad >= 0){
            this.cantidad = cantidad;
        } else {
            System.out.println("Cantidad invalido");
        }
    }

    public double calcularValorTotal(){
        return precio * cantidad;
    }

    @Override
    public String toString(){
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: " + precio +
                " | Cantidad: " + cantidad;
    }




}
