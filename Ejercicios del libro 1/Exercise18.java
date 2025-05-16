import java.util.Scanner;
public class Exercise18 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int NE;      
        int Q;       
        int R;       
        String MSG;  

        System.out.println("Ingrese un número entero distinto de cero:");
        NE = teclado.nextInt();

        if (NE != 0) {
            Q = NE / 2;
            R = NE - (Q * 2);

            if (R == 0) {
                MSG = "Es Par";
            } else {
                MSG = "Es Impar";
            }

            System.out.println(MSG);
        } else {
            System.out.println("El número no puede ser cero.");
        }

        teclado.close();
    }
}