package Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    static String alerta = "";

    static HashMap<String, String> colores = new HashMap<>() {{
        put("Azul",     "\u001B[96m");
        put("Amarillo", "\u001B[33m");
        put("Verde",    "\u001B[32m");
        put("Rojo",     "\u001B[31m");
        put("Blanco",   "\u001B[0m");
    }};

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

    static void imprimir(String color, String texto) {
        System.out.print(colores.get(color));
        System.out.println(texto);
        System.out.print(colores.get("Blanco"));
    }

    static void cargarAlerta(String color, String texto) {
        alerta = colores.get(color) + texto + colores.get("Blanco");
    }

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
        if(!alerta.equals("")) {
            System.out.println(alerta);
            alerta = "";
        }
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarOpciones();

            System.out.print("\nOpción: ");

            while (!sc.hasNextInt()) {
                cargarAlerta("Rojo", "\n¡Entrada Inválida!");
                mostrarOpciones();

                System.out.print("\nOpción: ");

                sc.next();
            }

            opcion = sc.nextInt();

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
                    cargarAlerta("Amarillo", "\n¡Opción inválida!");
            }

        } while(opcion != 6);
        imprimir("Azul", "\n¡Adios!");
        sc.close();
    }
}