package modelos;

import java.util.Scanner;

public class MenuDeOpciones {
    private int opcion = 0; // Inicializa con un valor que no sea 7
    Scanner scanner = new Scanner(System.in);

    public void menuDeOpciones() {
        while (opcion != 7) {
            try {
                System.out.println("Elige una opción válida: ");
                System.out.println(" 1) Dólar a Peso Argentino");
                System.out.println(" 2) Peso Argentino a Dólar");
                System.out.println(" 3) Dólar a Real Brasileño");
                System.out.println(" 4) Real brasileño a Dólar");
                System.out.println(" 5) Dólar a Peso Colombiano");
                System.out.println(" 6) Peso Colombiano a Dólar");
                System.out.println(" 7) Salir");

                // Validar si la entrada es un número
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (opcion >= 1 && opcion <= 6) {
                        ConsultarMoneda consultarMoneda = new ConsultarMoneda();
                        consultarMoneda.enviarConsulta(opcion);
                    } else if (opcion == 7) {
                        System.out.println("Programa finalizado");
                    } else {
                        System.out.println("Número incorrecto. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.nextLine(); // Consumir entrada incorrecta
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar el búfer en caso de excepción
            }
        }
        scanner.close(); // Cerrar el scanner solo cuando se termine el bucle
    }
}

