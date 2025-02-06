import java.util.Scanner;

public class CondicionalesTernario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ejemplo 1: Uso del operador ternario para determinar la mayoría de edad
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        String resultadoEdad = (edad >= 18) ? "Eres mayor de edad." : "";
        System.out.println(resultadoEdad);

        // Ejemplo 2: Uso del operador ternario para determinar si un número es par o impar
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        String resultadoNumero = (numero % 2 == 0) ? "El número es par." : "El número es impar.";
        System.out.println(resultadoNumero);

        // Ejemplo 3: Uso del operador ternario para clasificar una nota
        System.out.print("Introduce tu nota (0-100): ");
        int nota = scanner.nextInt();
        String resultadoNota = (nota >= 90) ? "Tienes una calificación de Sobresaliente." :
                              (nota >= 70) ? "Tienes una calificación de Notable." :
                              (nota >= 50) ? "Tienes una calificación de Aprobado." : "Has suspendido. Necesitas mejorar.";
        System.out.println(resultadoNota);
        
        scanner.close(); // Cerrar Scanner para evitar fugas de recursos
    }
}