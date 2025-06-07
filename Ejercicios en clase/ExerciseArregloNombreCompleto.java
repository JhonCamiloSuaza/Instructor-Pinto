import java.util.Scanner;

public class ExerciseArregloNombreCompleto {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in); 


        String[] primerosNombres = new String[10];  
        String[] segundosNombres = new String[10];  
        String[] primerosApellidos = new String[10];  
        String[] segundosApellidos = new String[10];  

      
        for (int i = 0; i < 10; i++) {
            System.out.println("\nRegistro #" + (i + 1));
            
            System.out.print("Ingrese PRIMER NOMBRE: ");
            primerosNombres[i] = Sc.nextLine();

            System.out.print("Ingrese SEGUNDO NOMBRE: ");
            segundosNombres[i] = Sc.nextLine();

            System.out.print("Ingrese PRIMER APELLIDO: ");
            primerosApellidos[i] = Sc.nextLine();

            System.out.print("Ingrese SEGUNDO APELLIDO: ");
            segundosApellidos[i] = Sc.nextLine(); 
        }

        System.out.println("\nNOMBRES COMPLETOS REGISTRADOS:");
        for (int i = 0; i < 10; i++) {
            String nombreCompleto = primerosNombres[i] + " " + 
        segundosNombres[i] + " " + 
        primerosApellidos[i] + " " + 
        segundosApellidos[i];
            
            System.out.println((i + 1) + ". " + nombreCompleto);
        }

        Sc.close();
    }
}