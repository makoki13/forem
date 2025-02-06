import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EntradaDatosBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce tu edad: ");
        int edad = Integer.parseInt(reader.readLine()); // Siempre lee una línea completa
        
        System.out.print("Introduce tu nombre: ");
        String nombre = reader.readLine();

        System.out.println("Edad: " + edad + ", Nombre: " + nombre);
    }
}
