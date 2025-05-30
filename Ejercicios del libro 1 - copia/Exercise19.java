import java.util.Scanner;

public class Exercise19 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int N;
        int K; 

        System.out.println("Números pares del 1 al 10:");

        N = 2; 
        System.out.println(N); 

        for (K = 1; K <= 4; K++) {
            N = N + 2; 
            System.out.println(N); 
        }

        teclado.close();
}

}