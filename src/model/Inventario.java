package model;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario(){
        this.productos = new ArrayList<>();
    }

    public void registrarProducto(Producto producto) {
        productos.add(producto);
    }

    public void buscarProducto(int id){
        boolean productoEncontrado = false;
        for(int i = 0; i < productos.size(); i++){
            if(id == productos.get(i).getId()){
                System.out.println(productos.get(i));
                productoEncontrado = true;
            }
        } if (!productoEncontrado){
            System.out.println("Producto no encontrado");
        }
    }

    public void  actualizarProducto(int id){

    }
}
