import java.util.Arrays;
import java.util.Scanner;


public class ExerciseArregloDeOrdenNombres {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] nombres = new String[10];

        for (int x = 0; x < 10; x++) {
            System.out.print("Ingrese un nombre (" + (x + 1) + "): ");
            nombres[x] = teclado.nextLine();
        }

        Arrays.sort(nombres);

        System.out.println("Nombres ordenados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        teclado.close();
    }
}