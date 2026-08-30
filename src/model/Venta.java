package model;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private double sumaTotalAPagar;

    public Venta(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.sumaTotalAPagar = 0.0;
    }


    public void agregarProducto(Producto producto){
        productos.add(producto);
        sumaTotalAPagar += producto.getPrecio();
    }

    public void mostrarFactura(){
        System.out.println("\n**** DETALLES DE LA VENTA ID: " + id  +" ****");
        System.out.println("\nID: #" + id);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println();
        for (Producto p : productos){
            System.out.println("- " + p.getNombre() + ": $" + p.getPrecio());
        }
        System.out.println("\nTotal: " + sumaTotalAPagar);
    }
}
