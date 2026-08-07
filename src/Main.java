import model.Alimento;
import model.Inventario;

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

    }
}