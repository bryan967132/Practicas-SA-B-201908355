package Test;

public class Test {
    public static void main(String[] args) {
        Producto.Inventario inventario = new Producto.Inventario();

        // Test agregar producto
        inventario.agregarProducto(new Producto.Producto("Corn Flakes", 12, 24));

        System.out.println(inventario.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        inventario.agregarProducto(new Producto.Producto("Manzana Verde", 34, 7));

        System.out.println(inventario.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        inventario.agregarProducto(new Producto.Producto("Alcon Milenario LEGO", 8, 1200));

        System.out.println(inventario.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        inventario.agregarProducto(new Producto.Producto("XBox One", 3, 3500));

        System.out.println(inventario.mostrarProductos()); // Mostrar Lista de Productos


        System.out.println(inventario.mostrarProductosOrdenados()); // Mostrar Lista de Productos Ordenados por Precio

        inventario.eliminarProducto("Manzana Verde"); // Eliminación de Producto

        System.out.println(inventario.mostrarProductos()); // Mostrar Lista de Productos

        System.out.println(inventario.mostrarProductosOrdenados()); // Mostrar Lista de Productos Ordenados por Precio

        System.out.println(inventario.buscarProducto("Alcon Milenario LEGO")); // Búsqueda de Producto
    }
}