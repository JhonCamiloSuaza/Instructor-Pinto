import java.util.Scanner;
public class Exercise9 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int AN;
        int AA;
        int E;

        System.out.println("Ingrese el año de nacimiento:");
        AN = teclado.nextInt();

        System.out.println("Ingrese el año actual:");
        AA = teclado.nextInt();

        E = AA - AN;

        if (E > 17) {
            System.out.println("Debe solicitar su CUIL");
        } else {
            System.out.println("No debe solicitar su CUIL por el momento");
        }

        teclado.close();
    
}

}