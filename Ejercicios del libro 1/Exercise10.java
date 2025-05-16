import java.util.Scanner;
public class Exercise10 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int E1;
        int E2; 
        int DE;

       
        System.out.println("Ingrese la edad del primer hermano:");
        E1 = teclado.nextInt();

        System.out.println("Ingrese la edad del segundo hermano:");
        E2 = teclado.nextInt();

       
        if (E1 > E2) {
            DE = E1 - E2;
            System.out.println("El primer hermano es el mayor por " + DE + " años.");
        } else if (E2 > E1) {
            DE = E2 - E1;
            System.out.println("El segundo hermano es el mayor por " + DE + " años.");
        } else {
            System.out.println("Ambos hermanos tienen la misma edad.");
        }

        teclado.close();
    }
}