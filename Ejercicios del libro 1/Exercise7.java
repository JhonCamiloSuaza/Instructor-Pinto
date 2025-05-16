import java.util.Scanner;
public class Exercise7 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double cd;
        double gb;
        double mg;

        System.out.println("Número de CDs (se calculará automáticamente):");

        System.out.println("Número de Gigabytes del Disco Duro:");
        gb = teclado.nextDouble();

        // Convertimos GB a MB
        mg = gb * 1024;

        // Cálculo del número de CDs necesarios (700 MB por CD)
        cd = Math.floor(mg / 700) + 1;

        System.out.println("El número de CDs necesarios: " + (int)cd);

        teclado.close();
    }
}