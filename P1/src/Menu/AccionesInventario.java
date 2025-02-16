package Menu;

import java.util.Scanner;

import Producto.Producto;

public class AccionesInventario {
    public static int leerEntero(Scanner sc, String mensaje, String error) {
        System.out.print(mensaje);
        while(!sc.hasNextInt()) {
            System.out.println("\u001B[31m" + error + "\u001B[0m"); // Carga de la alerta

            System.out.print(mensaje);

            sc.next(); // Se limpia el buffer de entrada
        }
        return sc.nextInt();
    }

    public static double leerDecimal(Scanner sc, String mensaje, String error) {
        System.out.print(mensaje);
        while(!sc.hasNextDouble()) {
            System.out.println("\u001B[31m" + error + "\u001B[0m"); // Carga de la alerta
            
            System.out.print(mensaje);
            
            sc.next(); // Se limpia el buffer de entrada
        }
        return sc.nextDouble();
    }

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