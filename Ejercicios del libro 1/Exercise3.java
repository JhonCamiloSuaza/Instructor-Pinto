import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int RC, RI, RB, PRC, PRI, PF;

        System.out.println("Numero de respuestas correctas: ");
            RC = teclado.nextInt();

        System.out.println("Numero de respuestas incorrectas: ");
            RI = teclado.nextInt();

        System.out.println("Numero de respuestas en blanco: ");
            RB = teclado.nextInt();

        PRC = RC * 4;
        PRI = RI * -1;
        PF = PRC + PRI;

        if(PF<0){
            System.out.println("Puntaje final menor a 0 " );
        }
        System.out.println("Puntaje final: " + PF);

        teclado.close();
    }
}