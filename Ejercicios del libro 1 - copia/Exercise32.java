import java.util.Scanner;
public class Exercise32 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int N;      
        int K;      
        int Q;      
        int P;      
        int R;      

        System.out.println("Ingrese un número entero distinto de cero:");
        N = teclado.nextInt();

        if (N != 0) {
            System.out.println("Los divisores de " + N + " son:");

            for (K = 1; K <= Math.abs(N); K++) {
                Q = N / K;
                P = Q * K;
                R = N - P;

                if (R == 0) {
                    System.out.println(K);
                }
            }
        } else {
            System.out.println("El número no puede ser cero.");
        }

        teclado.close();
    }
}

