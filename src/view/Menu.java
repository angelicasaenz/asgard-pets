package view;

import model.*;
import service.FundacionAuroraService;
import service.InventarioService;
import service.VentaService;
import util.Validador;

import java.util.Scanner;

public class Menu {

    private InventarioService inventarioService;
    private FundacionAuroraService fundacionAuroraService;
    private VentaService ventaService;

    private Scanner sc;

    public Menu(){
        this.fundacionAuroraService = new FundacionAuroraService();
        this.inventarioService = new InventarioService();
        this.ventaService = new VentaService();
        this.sc = new Scanner(System.in);
    }

    // ================= MENÚ PRINCIPAL =================

    public void iniciar(){
        boolean salir = false;

        while (!salir){
            System.out.println("\n========== SISTEMA PRINCIPAL ASGARD PETS Y AURORA ==========");
            System.out.println("""
                    
                    1. Módulo Asgard Pets (Inventario)
                    2. Módulo Fundación Aurora (Adopciones)
                    3. Módulo de Ventas (Registrar ventas)
                    4. Módulo de Personas (Clientes, Empleados, Proveedores)
                    5. Salir
                    
                    """);

            int opcion = Validador.leerEntero(sc, "Seleccione una opción: ");

            switch (opcion){
                case 1:
                    menuInventario();
                    break;
                case 2:
                    menuAurora();
                    break;
                case 3:
                    menuVentas();
                    break;
                case 4:
                    menuPersonas();
                    break;
                case 5:
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

            switch (opcion) {
                case 1:
                        System.out.println("""
                                        \n¿Qué tipo de producto desea registrar?
                                        1. Alimento                   
                                        2. Medicamento                            
                                        3. Accesorio
                                        4. Cancelar / Salir
                                        """);
                        int tipo = Validador.leerEntero(sc, "Seleccione el tipo: ");

                        if (tipo == 4){
                            System.out.println("\nSaliendo...");
                            break;
                        } else if (tipo < 1 || tipo > 3){
                            System.out.println("Opción invalida.");
                            break;
                        } else {
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
                case 2:
                    int idABuscar = Validador.leerEntero(sc, "Ingrese el ID: ");
                    inventarioService.buscarProducto(idABuscar);
                    break;
                case 3:
                    inventarioService.mostrarInventario();
                    break;
                case 4:
                    int idAcualizar = Validador.leerEntero(sc, "\nIngrese el ID del producto a acutalizar: ");
                    if(inventarioService.buscarProducto(idAcualizar)){
                        String nombreNuevo = Validador.leerTexto(sc, "\nNombre a modificar: ");
                        double precioNuevo = Validador.leerDouble(sc, "\nPrecio a modificar: ");
                        int cantidadNueva = Validador.leerEntero(sc, "\nCantidad a modificar: ");
                        inventarioService.actualizarProducto(idAcualizar, nombreNuevo, precioNuevo, cantidadNueva);
                        System.out.println("\n Producto actualizado con exito!");
                        break;
                    } else {
                        System.out.println("No existe producto con ese ID");
                        break;
                    }


                case 5:
                    int idEliminar = Validador.leerEntero(sc, "Ingrese el ID del producto que desea eliminar: ");
                    inventarioService.eliminarProducto(idEliminar);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida");
                    }
        }
    }

    // ================= SUBMENÚ AURORA =================

    private void menuAurora(){

        boolean salir = false;
        while (!salir){
            System.out.println("\n--- GESTIÓN FUNDACIÓN AURORA ---");
            System.out.println("""
                    1. Mostrar información de la Fundación Aurora
                    2. Registrar mascota rescatada
                    3. Registrar adopción
                    4. Mostrar mascotas disponibles para adopción
                    5. Volver al menú principal
                    """);
            int opcion = Validador.leerEntero(sc, "Por favor ingrese una opción: ");

            switch (opcion) {
                case 1:
                    System.out.println("""
                            
                            ===================================================================
                                                   FUNDACIÓN AURORA 💜🐾
                                        "Cuidado, Amor y Bienestar para Mascotas"
                            ===================================================================
                             La Fundación Aurora es una iniciativa sin ánimo de lucro creada\s
                             por Asgard Pets. Nuestro propósito es rescatar, rehabilitar y\s
                             dar en adopción responsable a mascotas en situación de vulnerabilidad.
                            
                             Asgard Pets destina un porcentaje de sus ganancias para financiar\s
                             el sostenimiento, alimentación y atención médica de nuestros rescatados.
                            
                             ¡Gracias por formar parte de nuestra labor social y ayudar a proteger
                             a quienes no tienen voz!
                            ===================================================================
                            
                            """);
                    break;
                case 2:
                    int id = Validador.leerEntero(sc, "ID: ");
                    String nombre = Validador.leerTexto(sc, "Nombre: ");
                    String especie = Validador.leerTexto(sc, "Especie: ");
                    int edad = Validador.leerEntero(sc, "Edad: ");

                    fundacionAuroraService.agregarMascota(new Mascota(id, nombre, especie, edad));
                    System.out.println("\n" + nombre + " se ha unido a nuestra familia Aurora!! 🐾 ");
                    break;

                case 3:
                    int idAdoptar = Validador.leerEntero(sc, "\n Ingrese el ID de la mascota que será adoptada: ");
                    fundacionAuroraService.adoptarMascota(idAdoptar);
                    break;
                case 4:
                    fundacionAuroraService.mostrarMascotas();
                    break;
                case 5:
                    System.out.println("\nSaliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida. Intente de nuevo");
                    break;
            }
        }
    }

    // ================= SUBMENÚ VENTAS =================

    private void menuVentas() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN VENTAS ---");
            System.out.println("""
                    
                    1. Registrar venta
                    2. Mostrar historial de ventas
                    3. Volver al menú principal                 
                    """);
            int opcion = Validador.leerEntero(sc, "Por favor ingrese una opción: ");

            switch (opcion) {
                case 1:
                    // Crear cliente
                    System.out.println("\nDatos del cliente: ");
                    String cedulaCliente = Validador.leerTexto(sc, "Cédula cliente: ");
                    String nombreCliente = Validador.leerTexto(sc, "Nombre cliente: ");
                    Cliente cliente = new Cliente(cedulaCliente, nombreCliente);

                    // Crear venta
                    int idVenta = 0;
                    Venta venta = new Venta(idVenta++, cliente);

                    // Agregar productos

                    boolean finalizar = false;
                    while (!finalizar) {
                        System.out.println("\nDatos del producto: ");
                        int idProductoComprar = Validador.leerEntero(sc, "ID del producto: ");

                        // Obtener producto
                        Producto productoEncontrado = inventarioService.obtenerProductoPorId(idProductoComprar);

                        if (productoEncontrado != null) {
                            int cantidadComprar = Validador.leerEntero(sc,"Cantidad: ");
                            if( inventarioService.reducirStock(idProductoComprar,cantidadComprar)){
                                venta.agregarProducto(productoEncontrado, cantidadComprar);
                            }
                        } else {
                            System.out.println("No se encontró ningún producto con ese ID.");
                        }

                        System.out.println("\n1. Agregar otro producto");
                        System.out.println("2. Finalizar compra");
                        int op = Validador.leerEntero(sc, "Seleccione una opción: ");

                        if (op == 2) {
                            finalizar = true;
                        }
                    }
                    ventaService.registrarVenta(venta);
                    venta.mostrarFactura();
                    break;
                case 2:

                    System.out.println("**** HISTORIAL DE VENTAS ****");



            }
        }
    }

    // ================= SUBMENÚ PERSONAS =================

    private void menuPersonas(){
    }

}

//                     4. Mostrar mascotas disponibles para adopción
//                    5. Consultar historial de adopciones
//                    6. Volver al menú principal