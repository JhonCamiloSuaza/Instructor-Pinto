import java.util.Scanner;

public class calculadora2 {
public static double num1, num2 , resultado;


public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
       
        do { 
            System.out.println("CALCULADORA");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");
            opcion = teclado.nextInt();
            
            if (opcion == 5) {
                System.out.println("¡Hasta luego!");
                break;
            }
        

            System.out.print("Ingrese el primer número: ");
            num1 = teclado.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            num2 = teclado.nextDouble();
            
            switch(opcion) {
                case 1:
                    suma(num1, num2);
                    break;
                case 2:
                    resta(num1, num2);
                    break;
                case 3:
                    multiplicacion(num1, num2);
                    break;
                case 4:
                    division(num1, num2);
                    break;
            }
        } while (opcion != 5);
        
        teclado.close();
    }
    
    
    public static void suma(double num1, double num2) {
        resultado = num1 + num2;
        System.out.println("Resultado: "  + resultado);
    }
    
    public static void resta(double num1, double num2) {
         resultado = num1 - num2;
        System.out.println("Resultado: "  + resultado);
    }
    
    public static void multiplicacion(double num1, double num2) {
        resultado = num1 * num2;
        System.out.println("Resultado: " + resultado);
    }
    
    public static void division(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("No se puede dividir por cero");
        } else {
            resultado= num1 / num2;
            System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
        }
    }
}