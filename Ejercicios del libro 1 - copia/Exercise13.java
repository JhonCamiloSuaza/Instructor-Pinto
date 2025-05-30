import java.util.Scanner;

public class Exercise13 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int L1, L2, L3;  
        String TT;       

        
        System.out.println("Ingrese el primer lado del triángulo:");
        L1 = teclado.nextInt();

        System.out.println("Ingrese el segundo lado del triángulo:");
        L2 = teclado.nextInt();

        System.out.println("Ingrese el tercer lado del triángulo:");
        L3 = teclado.nextInt();
       
        if (L1 != L2 && L2 != L3 && L3 != L1) {
            TT = "Escaleno";        
         } else if (L1 == L2 && L2 == L3) {
            TT = "Equilátero";  
        } else {
            TT = "Isósceles";  
        }

    
        System.out.println("El triángulo es: " + TT);

        teclado.close();
    }
}
