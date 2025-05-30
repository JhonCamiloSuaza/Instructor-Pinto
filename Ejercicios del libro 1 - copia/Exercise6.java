import java.util.Scanner;
public class Exercise6 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double At, la, lb, lc, ls;

        System.out.println("Longitud del lado A: ");
        la = teclado.nextDouble();

        System.out.println("Longitud del lado B: ");
        lb = teclado.nextDouble();

        System.out.println("Longitud del lado C: ");
        lc = teclado.nextDouble();

        ls = (la + lb + lc) / 2;
        At = Math.sqrt(ls * (ls - la) * (ls - lb) * (ls - lc));

        System.out.println("El área del triángulo es: " + At);

        teclado.close();
    }
}