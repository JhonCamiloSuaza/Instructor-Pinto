import java.util.Scanner;

public class Exercise27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int N1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int N2 = scanner.nextInt();

        System.out.print("Ingrese el operador (+, -, *, ^): ");
        String OP = scanner.next();

        int R = 0;
        boolean operadorValido = true;

        if (OP.equals("+")) {
            R = N1 + N2;
        } else if (OP.equals("-")) {
            R = N1 - N2;
        } else if (OP.equals("*")) {
            R = N1 * N2;
        } else if (OP.equals("^")) {
            R = (int) Math.pow(N1, N2);
        } else {
            System.out.println("Operador no válido.");
            operadorValido = false;
        }

        if (operadorValido) {
            System.out.println("Resultado: " + R);
        }

        scanner.close();
    }
}