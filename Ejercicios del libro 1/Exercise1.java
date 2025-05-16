
import java.util.Scanner;
public class Exercise1{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la velocidad constante: ");
        int velocidadCostante = teclado.nextInt();

        System.out.print("Ingrese el tiempo: ");
        int tiempo = teclado.nextInt();

        int distancia = velocidadCostante * tiempo;
        System.out.println("La distancia es: " + distancia);
   
        teclado.close();
    }
}
