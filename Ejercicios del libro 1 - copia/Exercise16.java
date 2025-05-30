import java.util.Scanner;
public class Exercise16 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

     
        int NE;       
        String V;     

        System.out.println("Ingrese un número entero del 1 al 5:");
        NE = teclado.nextInt();

        if (NE == 1) {
            V = "A";
        } else if (NE == 2) {
            V = "E";
        } else if (NE == 3) {
            V = "I";
        } else if (NE == 4) {
            V = "O";
        } else if (NE == 5) {
            V = "U";
        } else {
            V = "Valor Incorrecto";
        }

        System.out.println("Vocal : " + V);

        teclado.close();
    }
}