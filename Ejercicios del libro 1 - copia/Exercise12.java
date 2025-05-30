import java.util.Scanner;
public class Exercise12 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int N1, N2, N3;   
        int NM;          

        
        System.out.println("Ingrese el primer número entero:");
        N1 = teclado.nextInt();

        System.out.println("Ingrese el segundo número entero:");
        N2 = teclado.nextInt();

        System.out.println("Ingrese el tercer número entero:");
        N3 = teclado.nextInt();

        
        if (N1 > N2 && N1 > N3) {
            NM = N1;
        } else if (N2 > N3) {
            NM = N2;
        } else {
            NM = N3;
        }

    
        System.out.println("El número mayor es: " + NM);

        teclado.close();
    }
}