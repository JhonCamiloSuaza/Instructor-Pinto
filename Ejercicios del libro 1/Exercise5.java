import java.util.Scanner;
public class Exercise5 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int P, HL, TH;

        System.out.println("Tarifa por hora: ");
        TH = teclado.nextInt();

        System.out.println("Numero de horas laboradas: ");
        HL = teclado.nextInt();

        P = HL * TH;

        System.out.println("Pago total: " + P);
        

        teclado.close();
    }
}


