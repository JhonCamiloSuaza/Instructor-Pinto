import java.util.Scanner;
public class Exercise17 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int NE; 
        int Q;  
        int R; 
        int D;  
        int U;  

        
        System.out.println("Ingrese un número entero de dos cifras (entre 10 y 99):");
        NE = teclado.nextInt();

        if (NE >= 10 && NE <= 99) {
            Q = NE / 10;        
            R = NE - (Q * 10);  
            D = Q;
            U = R;

            System.out.println("Decenas: " + D);
            System.out.println("Unidades: " + U);
        } else {
            System.out.println("Número inválido. Debe tener exactamente dos cifras.");
        }

        teclado.close();
    }
}
