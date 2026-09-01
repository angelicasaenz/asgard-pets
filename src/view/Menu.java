package view;

import model.Accesorio;
import model.Alimento;
import model.Medicamento;
import service.FundacionAuroraService;
import service.InventarioService;
import util.Validador;

import java.util.Scanner;

public class Menu {

    private InventarioService inventarioService;
    private FundacionAuroraService fundacionAuroraService;

    private Scanner sc;

    public Menu(){
        this.fundacionAuroraService = new FundacionAuroraService();
        this.inventarioService = new InventarioService();
        this.sc = new Scanner(System.in);
    }

    // ================= MENÚ PRINCIPAL =================

    public void iniciar(){
        boolean salir = false;

        while (!salir){
            System.out.println("\n========== SISTERMA PRINCIPAL ASGARD PETS Y AURORA ==========");
            System.out.println("1. Módulo Asgard Pets (Inventario)");
            System.out.println("2. Módulo Fundación Aurora (Adopciones)");
            System.out.println("3. Salir");

            int opcion = Validador.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion){
                case 1:
                    menuInventario();
                    break;
                case 2:
                    menuAurora();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema! Hasta pronto.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        }
    }

    // ================= SUBMENÚ INVENTARIO =================

    private void menuInventario(){

        boolean salir = false;

        while (!salir){
            System.out.println("\n--- GESTIÓN DE INVENTARIO (ASGARD PETS) ---");
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Mostrar inventario completo");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Volver al menú principal");

            int opcion = Validador.leerEntero(sc, "Por favor seleccione una opción: ");

            switch (opcion){
                case 1:
                    System.out.println("""
            \n¿Qué tipo de producto desea registrar?
            1. Alimento                   
            2. Medicamento                            
            3. Accesorio
            4. Cancelar / Salir
            """);
                    int tipo = Validador.leerEntero(sc, "Seleccione el tipo: ");

                    if (tipo == 4) {
                        System.out.println("Registro cancelado.");
                        break;
                    }

                    int id = Validador.leerEntero(sc, "ID: ");
                    String nombre = Validador.leerTexto(sc, "Nombre: ");
                    double precio = Validador.leerDouble(sc, "Precio: ");
                    int cantidad = Validador.leerEntero(sc, "Cantidad: ");

                    switch (tipo) {
                        case 1:
                            inventarioService.registrarProducto(new Alimento(id, nombre, precio, cantidad));
                            System.out.println("¡Alimento registrado exitosamente!");
                            break;
                        case 2:
                            inventarioService.registrarProducto(new Medicamento(id, nombre, precio, cantidad));
                            System.out.println("¡Medicamento registrado exitosamente!");
                            break;
                        case 3:
                            inventarioService.registrarProducto(new Accesorio(id, nombre, precio, cantidad));
                            System.out.println("¡Accesorio registrado exitosamente!");
                            break;
                        default:
                            System.out.println("Opción de producto no válida.");
                    }
                    break;
                    }

        }
    }

    // ================= SUBMENÚ INVENTARIO =================

    private void menuAurora(){

    }
}
