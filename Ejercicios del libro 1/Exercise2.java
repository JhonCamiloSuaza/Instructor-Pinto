
        import java.util.Scanner;
public class Exercise2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

       
        System.out.print("Ingrese la primera nota: ");
        int nota1 = teclado.nextInt();

        System.out.print("Ingrese la segunda nota: ");
        int nota2 = teclado.nextInt();

        System.out.print("Ingrese la tercera nota: ");
        int nota3 = teclado.nextInt();

        double promedio = (nota1 + nota2 + nota3);

        System.out.println("El promedio es: " + promedio);
  
        teclado.close();
    }
}
    