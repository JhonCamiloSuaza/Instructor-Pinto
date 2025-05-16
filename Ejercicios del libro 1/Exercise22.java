import java.util.Scanner;

public class Exercise22 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int PN; 
        int SN;  
        int K;   
        int P = 0; 
        System.out.print("Ingrese el primer número: ");
        PN = teclado.nextInt();

        System.out.print("Ingrese el segundo número: ");
        SN = teclado.nextInt();

        for (K = 1; K <= SN; K++) {
            P = P + PN;
        }

        
        System.out.println("El producto por sumas sucesivas es: " + P);

        

        teclado.close();
    }
}
