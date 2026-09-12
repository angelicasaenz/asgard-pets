package service;

import model.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaService {

    private List<Venta> listaVentas;

    public VentaService() {
        this.listaVentas = new ArrayList<>();
    }

    public void registrarVenta(Venta venta) {
        listaVentas.add(venta);
        System.out.println("¡Venta registrada exitosamente!");
    }

    public void mostrarHistorialVentas() {
        if (listaVentas.isEmpty()) {
            System.out.println("No hay ventas registradas en el historial.");
            return;
        }

        System.out.println("\n**** HISTORIAL DE VENTAS REGISTRADAS ****");
        for (Venta v : listaVentas) {
            v.mostrarFactura();
        }
    }
}
