import java.util.Scanner;

public class Preguntar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean terminar = false; // Guarda booleana para controlar el bucle

        while (!terminar) {
            System.out.print("Escribe algo (o 'salir' para terminar): ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                terminar = true; // Cambia la guarda booleana para salir del bucle
            } else {
                System.out.println("Has escrito: " + entrada);
            }
        }

        System.out.println("Programa terminado.");
        scanner.close();
    }
}
