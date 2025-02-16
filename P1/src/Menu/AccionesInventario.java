package Menu;

import java.util.Scanner;

import Producto.Producto;

public class AccionesInventario {
    /**
     * Solicita al usuario un número entero, validando la entrada para evitar errores
     *
     * @param sc Objeto utilizado para la entrada de datos
     * @param mensaje Mensaje a mostrar antes de solicitar la entrada
     * @param error Mensaje de error a mostrar si la entrada no es un número entero
     * @return El número entero ingresado por el usuario
     */
    public static int leerEntero(Scanner sc, String mensaje, String error) {
        System.out.print(mensaje);
        while(!sc.hasNextInt()) {
            System.out.println("\u001B[31m" + error + "\u001B[0m"); // Carga de la alerta

            System.out.print(mensaje);

            sc.next(); // Se limpia el buffer de entrada
        }
        return sc.nextInt();
    }

    /**
     * Solicita al usuario un número entero o con punto decimal, validando la entrada para evitar errores
     *
     * @param sc Objeto utilizado para la entrada de datos
     * @param mensaje Mensaje a mostrar antes de solicitar la entrada
     * @param error Mensaje de error a mostrar si la entrada no es un número entero o con punto decimal
     * @return El número entero o decimal ingresado por el usuario
     */
    public static double leerDecimal(Scanner sc, String mensaje, String error) {
        System.out.print(mensaje);
        while(!sc.hasNextDouble()) {
            System.out.println("\u001B[31m" + error + "\u001B[0m"); // Carga de la alerta
            
            System.out.print(mensaje);
            
            sc.next(); // Se limpia el buffer de entrada
        }
        return sc.nextDouble();
    }

    /**
     * Solicita al usuario los datos para crear un nuevo producto
     * Se valida la entrada de cantidad y precio para asegurar que sean valores numéricos válidos.
     *
     * @param sc Objeto utilizado para la entrada de datos.
     * @return Un nuevo objeto {@code Producto} con los datos ingresados, o {@code null} en caso de error.
     */
    public static Producto obtenerNuevoProducto(Scanner sc) {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            int cantidad = leerEntero(sc, "Cantidad: ", "¡Cantidad Inválida!");

            double precio = leerDecimal(sc, "Precio: ", "¡Precio Inválida!");

            return new Producto(nombre, cantidad, precio);
        } catch (Exception e) {
            return null;
        }
    }
}