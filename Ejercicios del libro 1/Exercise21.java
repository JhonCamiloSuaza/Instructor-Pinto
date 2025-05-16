import java.util.Scanner;
public class Exercise21 {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        int EP;  
        int MAY = 0;
        int MEN = 0; 
        int K;    

        for (K = 1; K <= 200; K++) {
            System.out.print("Ingrese la edad de la persona " + K + ": ");
            EP = teclado.nextInt();

            if (EP < 18) {
                MEN = MEN + 1;
            } else {
                MAY = MAY + 1;
            }
        }

    
        System.out.println("Cantidad de personas mayores de edad: " + MAY);
        System.out.println("Cantidad de personas menores de edad: " + MEN);

    

        teclado.close();
    }
}