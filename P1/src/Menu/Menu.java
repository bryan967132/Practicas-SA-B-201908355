package Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    /**
     * Variable que almacena un mensaje de alerta que se mostrará en el menú.
     * Se actualiza cuando hay un error o una notificación para el usuario.
     */
    static String alerta = "";

    /**
     * Diccionario de colores ANSI para imprimir texto en diferentes colores en la consola
     * Las llaves son los nombres de los colores y los valores son los códigos ANSI correspondientes
     */
    static HashMap<String, String> colores = new HashMap<>() {{
        put("Azul",     "\u001B[96m");
        put("Amarillo", "\u001B[33m");
        put("Verde",    "\u001B[32m");
        put("Rojo",     "\u001B[31m");
        put("Blanco",   "\u001B[0m");
    }};

    /**
     * Método para limpiar la consola dependiendo del sistema operativo
     * 
     * En Windows, ejecuta el comando "cls" en cmd
     * En Linux/macOS, imprime los caracteres de escape ANSI para limpiar la pantalla
     */
    static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para imprimir un texto en la consola con un color específico
     * 
     * @param color Nombre del color definido en el HashMap "colores"
     * @param texto Texto a imprimir en la consola
     */
    static void imprimir(String color, String texto) {
        System.out.print(colores.get(color));
        System.out.println(texto);
        System.out.print(colores.get("Blanco"));
    }

    /**
     * Método para almacenar un mensaje de alerta en la variable "alerta"
     * Este mensaje se imprimirá en el menú la próxima vez que se muestre
     * 
     * @param color Nombre del color definido en el HashMap "colores"
     * @param texto Mensaje a mostrar como alerta
     */
    static void cargarAlerta(String color, String texto) {
        alerta = colores.get(color) + texto + colores.get("Blanco");
    }

    /**
     * Método para mostrar el menú de opciones en la consola
     * Borra la pantalla antes de mostrar las opciones y si hay un mensaje de alerta, lo muestra
     */
    static void mostrarOpciones() {
        limpiarConsola();
        System.out.print(colores.get("Verde"));
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║                  Menú Principal                   ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║     1. Agregar producto al inventario             ║");
        System.out.println("║     2. Eliminar producto del inventario           ║");
        System.out.println("║     3. Mostrar productos y sus detalles           ║");
        System.out.println("║     4. Mostrar productos ordenados por precio     ║");
        System.out.println("║     5. Buscar producto por nombre                 ║");
        System.out.println("║     6. Salir                                      ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.print(colores.get("Blanco"));

        // Si hay una alerta cargada se imprime y se reinicia la variable "alerta"
        if(!alerta.equals("")) {
            System.out.println(alerta);
            alerta = "";
        }
    }

    /**
     * Método que ejecuta el menú cíclico
     * El usuario puede seleccionar opciones del menú hasta que decida salir
     */
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarOpciones();

            System.out.print("\nOpción: ");

            // Validación de entrada: Se valida que se haya ingresado un número
            while (!sc.hasNextInt()) {
                cargarAlerta("Rojo", "\n¡Entrada Inválida!"); // Carga de la alerta
                mostrarOpciones();

                System.out.print("\nOpción: ");

                sc.next(); // Se limpia el buffer de entrada
            }

            opcion = sc.nextInt(); // Captura la entrada

            switch(opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    // Carga de la alerta
                    cargarAlerta("Amarillo", "\n¡Opción inválida!");
            }

        } while(opcion != 6);
        imprimir("Azul", "\n¡Adios!");
        sc.close();
    }
}