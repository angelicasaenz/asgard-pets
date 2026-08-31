import model.*;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        Alimento a1 = new Alimento(1, "BR For Cat", 23000, 3);
        Alimento a2 = new Alimento(1, "Cat chow", 23000, 3);
        Alimento a3 = new Alimento(1, "Alpiste", 23000, 3);
        Alimento a4 = new Alimento(1, "Mirringo", 23000, 3);
        Alimento a5 = new Alimento(1, "Felix", -3, 3);
        Alimento a6 = new Alimento(1, "Fancy Feast", 23000, 3);


        inventario.registrarProducto(a1);
        inventario.registrarProducto(a2);
        inventario.registrarProducto(a3);
        inventario.registrarProducto(a4);
        inventario.registrarProducto(a5);
        inventario.registrarProducto(a6);

        inventario.mostrarInventario();

        Cliente c1 = new Cliente("1000234232", "Catalina", "catalina@gmail.com");
        Venta v1 = new Venta(1, c1);
        v1.agregarProducto(a1);
        v1.agregarProducto(a2);
        v1.agregarProducto(a6);

        v1.mostrarFactura();

        Mascota m1 = new Mascota(112, "Laika", "gato", 3);

        FundacionAurora f = new FundacionAurora();
        f.agregarMascota(m1);
        f.adoptarMascota(12);

    }
}