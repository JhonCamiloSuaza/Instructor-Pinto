import java.util.Scanner;
public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, resultado;
        String operacion;

        System.out.println("Ingrese el primer numero:");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        num2 = sc.nextInt();
        System.out.println("Ingrese la operacion a realizar (suma, resta, multiplicacion, division):");
        operacion = sc.next();
        System.out.println("Ingrese O Para salir del Sistema");

        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = num1 + num2;
                System.out.println("Resultado: " + resultado);
                break;

            case "resta":
                resultado = num1 - num2;
                System.out.println("Resultado: " + resultado);
                break;

            case "multiplicacion":
                resultado = num1 * num2;
                System.out.println("Resultado: " + resultado);
                break;

            case "division":
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Error: Division por cero no permitida.");
                }
                break;




            default:
                System.out.println("Operacion no reconocida.");
                break;
        }

        sc.close();
    }
}

