import java.util.Scanner;
public class Exercise20 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        double SE;      
        double SS = 0;  
        double SP;      
        int NE;         
        int K;

        System.out.print("Ingrese el número de empleados: ");
        NE = teclado.nextInt();


        if (NE <= 0) {
            System.out.println("El número de empleados debe ser mayor que cero.");
        } else {
            
            for ( K = 1; K <= NE; K++) {
                
                System.out.print("Ingrese el sueldo del empleado " + K + ": ");
                SE = teclado.nextDouble();

                
                SS += SE;
            }

            
            SP = SS / NE;

            System.out.printf("El sueldo promedio es: %.2f%n", SP);
        }

        

        teclado.close();
    }
}