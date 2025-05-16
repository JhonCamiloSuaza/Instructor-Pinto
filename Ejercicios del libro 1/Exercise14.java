import java.util.Scanner;
public class Exercise14 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int NE;
        String ER;

        System.out.println("Ingrese un número entero entre 1 y 10:");
        NE = teclado.nextInt();

        if (NE == 1) {
            ER = "I";
        } else if (NE == 2) {
            ER = "II";
        } else if (NE == 3) {
            ER = "III";
        } else if (NE == 4) {
            ER = "IV";
        } else if (NE == 5) {
            ER = "V";
        } else if (NE == 6) {
            ER = "VI";
        } else if (NE == 7) {
            ER = "VII";
        } else if (NE == 8) {
            ER = "VIII";
        } else if (NE == 9) {
            ER = "IX";
        } else if (NE == 10) {
            ER = "X";
        } else {
            ER = "Número fuera de rango (debe ser entre 1 y 10)";
        }

        System.out.println("Equivalente en romano: " + ER);

        teclado.close();
    }
}