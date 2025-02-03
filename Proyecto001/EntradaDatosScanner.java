import java.util.Scanner; // Importamos la clase Scanner

public class EntradaDatosScanner {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada desde la consola
        Scanner scanner = new Scanner(System.in);

        // Solicitar y leer un String (una línea completa de texto)
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        // Solicitar y leer un número entero
        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();

        // Solicitar y leer un número decimal
        System.out.print("Introduce tu altura en metros: ");
        double altura = scanner.nextDouble();

        // Limpieza de buffer antes de leer otro String (opcional, para evitar problemas con nextLine())
        scanner.nextLine();

        // Solicitar y leer una línea adicional de texto
        System.out.print("Introduce tu ciudad: ");
        String ciudad = scanner.nextLine();


        // Mostrar los datos ingresados
        System.out.println("\nResumen de datos ingresados:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Ciudad: " + ciudad);
        
        // Cerrar el Scanner (buena práctica para liberar recursos)
        scanner.close();
    }
}
