import java.util.Scanner;
public class Exercise28 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

    
        int NV = 0; 
        int NC = 0; 
        String L;  
        

       for (int K = 1; K <= 10; K++) {
            System.out.print("Ingrese la letra número " + K + ": ");
            L = teclado.nextLine().toLowerCase(); // convierte todo a minúscula directamente

            // Validar que sea una sola letra
            if (L.length() != 1 || !Character.isLetter(L.charAt(0))) {
                System.out.println("Entrada inválida. Debe ingresar solo una letra.");
                K--; // repetir intento
                continue;
            }

            // Usar equals() para comparar strings
            if (L.equals("a") || L.equals("e") || L.equals("i") || L.equals("o") || L.equals("u")) {
                NV++;
            } else {
                NC++;
            }
        }

        System.out.println("Cantidad de vocales ingresadas: " + NV);
        System.out.println("Cantidad de consonantes ingresadas: " + NC);

        teclado.close();
    }
}
