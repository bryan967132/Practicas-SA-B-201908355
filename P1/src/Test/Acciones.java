package Test;

public class Acciones {
    public static void main(String[] args) {
        Producto.Acciones acciones = new Producto.Acciones();

        // Test agregar producto
        acciones.agregarProducto(new Producto.Producto("Corn Flakes", 12, 24));

        System.out.println(acciones.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        acciones.agregarProducto(new Producto.Producto("Manzana Verde", 34, 7));

        System.out.println(acciones.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        acciones.agregarProducto(new Producto.Producto("Alcon Milenario LEGO", 8, 1200));

        System.out.println(acciones.mostrarProductos()); // Mostrar Lista de Productos

        // Test agregar producto
        acciones.agregarProducto(new Producto.Producto("XBox One", 3, 3500));

        System.out.println(acciones.mostrarProductos()); // Mostrar Lista de Productos


        System.out.println(acciones.mostrarProductosOrdenados()); // Mostrar Lista de Productos Ordenados por Precio

        acciones.eliminarProducto("Manzana Verde"); // Eliminación de Producto

        System.out.println(acciones.mostrarProductos()); // Mostrar Lista de Productos

        System.out.println(acciones.mostrarProductosOrdenados()); // Mostrar Lista de Productos Ordenados por Precio

        System.out.println(acciones.buscarProducto("Alcon Milenario LEGO")); // Búsqueda de Producto
    }
}