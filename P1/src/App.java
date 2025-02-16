import Producto.Inventario;

public class App {
    public static void main(String[] args) throws Exception {
        Inventario inventario = new Inventario();
        Menu.Menu.mostrarMenu(inventario);
    }
}