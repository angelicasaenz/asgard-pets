package service;

import model.Producto;

import java.util.ArrayList;

public class InventarioService {

    private ArrayList<Producto> productos;

    public InventarioService(){
        this.productos = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean buscarProducto(int id){
        boolean productoEncontrado = false;
        for(int i = 0; i < productos.size(); i++){
            if(id == productos.get(i).getId()){
                System.out.println("\nProducto encontrado: ");
                System.out.println(productos.get(i));
                productoEncontrado = true;
            }
        } if (!productoEncontrado){
            System.out.println("\nProducto no encontrado");
        }
        return productoEncontrado;
    }

    public void  actualizarProducto(int id, String nombreNuevo, double precioNuevo, int cantidadNueva){
        for(int i = 0; i < productos.size(); i++){
            if(id == productos.get(i).getId()){
                System.out.println(productos.get(i));
                productos.get(i).setNombre(nombreNuevo);
                productos.get(i).setPrecio(precioNuevo);
                productos.get(i).setCantidad(cantidadNueva);
                System.out.println("Producto actualizado correctamente");
                return;
            }
        }
        System.out.println("Producto no encontrado");

    }

    public void  eliminarProducto(int id){
        for(int i = 0; i < productos.size(); i++){
            if(id == productos.get(i).getId()){
                System.out.println(productos.get(i));
                productos.remove(i);
                System.out.println("Producto eliminado correctamente");
                return;
            }
        }
        System.out.println("Producto no encontrado");

    }

    public void mostrarInventario(){
        for(int i = 0; i < productos.size(); i++){
            System.out.println(productos.get(i));
        }
    }

    public Producto obtenerProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean reducirStock(int id, int cantidad){

        Producto p = obtenerProductoPorId(id);

        if (p !=  null){
            if (p.getCantidad() >= cantidad) {
                p.setCantidad(p.getCantidad() - cantidad);
                return true;
            } else {
                System.out.println("Stock insuficiente. Disponible: " + p.getCantidad());
                return false;
            }
        }
        return false;

    }

}

