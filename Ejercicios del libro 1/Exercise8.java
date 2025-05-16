import java.util.Scanner;
public class Exercise8 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double AA; 
        double AB; 
        double OA; 
        double OB; 
        double D;  

        System.out.println("Ingrese la abscisa del punto A:");
        AA = teclado.nextDouble();

        System.out.println("Ingrese la abscisa del punto B:");
        AB = teclado.nextDouble();

        System.out.println("Ingrese la ordenada del punto A:");
        OA = teclado.nextDouble();

        System.out.println("Ingrese la ordenada del punto B:");
        OB = teclado.nextDouble();

      
        D = Math.sqrt(Math.pow((AB - AA), 2) + Math.pow((OB - OA), 2));

        System.out.println("La distancia entre los puntos A y B es: " + D);

        teclado.close();
    }
}






















