package Producto;

import java.util.ArrayList;
import java.util.HashMap;

public class Acciones {

    // Diccionario para almacenar los productos con su nombre como llave
    private HashMap<String, Producto> productos = new HashMap<>();

    // Lista que se usará par ordenar los productos por precio
    private ArrayList<Producto> productosOrdenados;

    // Vector que define el ancho de las columnas para la tabla al mostrar los productos
    private int[] columns = {6, 10, 15};

    /**
     * Agregar un nuevo producto al Diccionario de productos
     * 
     * @param nuevoProducto El producto a agregar
     * @return true si el producto se agregó correctamente, false si ya existe un producto con el mismo nombre
     */
    public boolean agregarProducto(Producto nuevoProducto) {
        // Verifica si el producto ya está en el Diccionario por su nombre
        if(!productos.containsKey(nuevoProducto.getNombre())) {
            columns[0] = nuevoProducto.getNombre().length() > columns[0] ? nuevoProducto.getNombre().length() : columns[0];
            // Agrega el producto
            productos.put(nuevoProducto.getNombre(), nuevoProducto);
            return true; // Producto agregado correctamente
        }
        return false; // El producto ya existe
    }

    /**
     * Eliminar un producto del Diccionario
     * 
     * @param nombre El nombre del producto a eliminar
     * @return true si el producto fue eliminado, false si no se encuentra en el HashMap
     */
    public boolean eliminarProducto(String nombre) {
        // Verifica si el producto ya está en el Diccionario por su nombre
        if(productos.containsKey(nombre)) {
            // Elimina el producto
            productos.remove(nombre);
            return true; // Producto eliminado correctamente
        }
        return false; // El producto no se encuentra
    }

    /**
     * Devuelve todos los productos en una tabla
     * 
     * @return Una cadena que representa la tabla con todos los productos
     */
    public String mostrarProductos() {
        // Usa un StringBuilder para construir la tabla
        StringBuilder tabla =  new StringBuilder("\u001B[96m");

        // Construye la cabecera de la tabla
        tabla.append("╔═" + "═".repeat(columns[0]) + "═╦═" + "═".repeat(columns[1]) + "═╦═" + "═".repeat(columns[2]) + "═╗\n");
        tabla.append(String.format("║ %-" + columns[0] + "s ║ %-" + columns[1] + "s ║ %-" + columns[2] + "s ║\n", "Nombre", "Cantidad", "Precio"));
        tabla.append("╠═" + "═".repeat(columns[0]) + "═╬═" + "═".repeat(columns[1]) + "═╬═" + "═".repeat(columns[2]) + "═╣\n");

        // Itera sobre el Diccionario y agrega cada producto a la tabla
        productos.forEach((nombre, producto) -> {
            tabla.append(String.format("║ \u001B[0m%-" + columns[0] + "s\u001B[96m ║ \u001B[0m%-" + columns[1] + "s\u001B[96m ║ \u001B[0m%-" + columns[2] + ".2f\u001B[96m ║\n", nombre, producto.getCantidad(), producto.getPrecio()));
        });

        // Cierra la tabla
        tabla.append("╚═" + "═".repeat(columns[0]) + "═╩═" + "═".repeat(columns[1]) + "═╩═" + "═".repeat(columns[2]) + "═╝\n");
        tabla.append("\u001B[0m");
        return tabla.toString(); // Devuelve la tabla completa
    }

    /**
     * Devuelve todos los productos ordenados por precio en orden descendente en una tabla
     * 
     * @return Una cadena que representa la tabla con los productos ordenados
     */
    public String mostrarProductosOrdenados() {
        // Convierte los valores del Diccionario de productos en una lista
        productosOrdenados = new ArrayList<>(productos.values());
        // Ordena los productos por el precio de forma descendente
        productosOrdenados.sort((producto1, producto2) -> Double.compare(producto2.getPrecio(), producto1.getPrecio()));

        // Usa un StringBuilder para construir la tabla
        StringBuilder tabla =  new StringBuilder("\u001B[96m");

        // Construye la cabecera de la tabla
        tabla.append("╔═" + "═".repeat(columns[0]) + "═╦═" + "═".repeat(columns[1]) + "═╦═" + "═".repeat(columns[2]) + "═╗\n");
        tabla.append(String.format("║ %-" + columns[0] + "s ║ %-" + columns[1] + "s ║ %-" + columns[2] + "s ║\n", "Nombre", "Cantidad", "Precio"));
        tabla.append("╠═" + "═".repeat(columns[0]) + "═╬═" + "═".repeat(columns[1]) + "═╬═" + "═".repeat(columns[2]) + "═╣\n");

        // Itera sobre el Diccionario y agrega cada producto a la tabla
        productosOrdenados.forEach(producto -> {
            tabla.append(String.format("║ \u001B[0m%-" + columns[0] + "s\u001B[96m ║ \u001B[0m%-" + columns[1] + "s\u001B[96m ║ \u001B[0m%-" + columns[2] + ".2f\u001B[96m ║\n", producto.getNombre(), producto.getCantidad(), producto.getPrecio()));
        });

        // Cierra la tabla
        tabla.append("╚═" + "═".repeat(columns[0]) + "═╩═" + "═".repeat(columns[1]) + "═╩═" + "═".repeat(columns[2]) + "═╝\n");
        tabla.append("\u001B[0m");
        return tabla.toString(); // Devuelve la tabla completa
    }

    /**
     * Devuelve un producto específico por su nombre
     * 
     * @param nombre El nombre del producto a buscar
     * @return Una cadena que representa la tabla con el producto encontrado, o null si no se encuentra
     */
    public String buscarProducto(String nombre) {
        // Verifica si el producto existe
        if(productos.containsKey(nombre)) {
            Producto productoEncontrado = productos.get(nombre); // Obtiene el producto

            // Usa un StringBuilder para construir la tabla
            StringBuilder tabla =  new StringBuilder("\u001B[32m");
            tabla.append("╔═" + "═".repeat(nombre.length() > "Nombre".length() ? nombre.length() : "Nombre".length()) + "═╦═" + "═".repeat(columns[1]) + "═╦═" + "═".repeat(columns[2]) + "═╗\n");
            tabla.append(String.format("║ %-" + (nombre.length() > "Nombre".length() ? nombre.length() : "Nombre".length()) + "s ║ %-" + columns[1] + "s ║ %-" + columns[2] + "s ║\n", "Nombre", "Cantidad", "Precio"));
            tabla.append("╠═" + "═".repeat(nombre.length() > "Nombre".length() ? nombre.length() : "Nombre".length()) + "═╬═" + "═".repeat(columns[1]) + "═╬═" + "═".repeat(columns[2]) + "═╣\n");

            // Agrega el producto encontrado a la tabla
            tabla.append(String.format("║ \u001B[0m%-" + (nombre.length() > "Nombre".length() ? nombre.length() : "Nombre".length()) + "s\u001B[32m ║ \u001B[0m%-" + columns[1] + "s\u001B[32m ║ \u001B[0m%-" + columns[2] + ".2f\u001B[32m ║\n", nombre, productoEncontrado.getCantidad(), productoEncontrado.getPrecio()));
            tabla.append("╚═" + "═".repeat(nombre.length() > "Nombre".length() ? nombre.length() : "Nombre".length()) + "═╩═" + "═".repeat(columns[1]) + "═╩═" + "═".repeat(columns[2]) + "═╝\n");
            tabla.append("\u001B[0m");
            return tabla.toString(); // Devuelve la tabla con el producto encontrado
        }
        return null; // El producto no se encuentra
    }
}