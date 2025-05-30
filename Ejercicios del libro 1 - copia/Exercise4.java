
import java.util.Scanner;
public class Exercise4 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int PG, PE, PP, PT;

        System.out.println("Número de Partidos Ganados:");
        PG = teclado.nextInt();

        System.out.println("Número de Partidos Empatados:");
        PE = teclado.nextInt();

        System.out.println("Número de Partidos Perdidos:");
        PP = teclado.nextInt();

       
        PT = (PG * 3) + (PE * 1);

        System.out.println("Puntaje Total: " + PT);

        teclado.close();
    

    
    }
}



