
import java.util.Scanner;


 public class ExerciseRegistroCompletoGeneral {
 public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in); 

        
        String[] N = new String[10];  
        String[] SN = new String[10];  
        String[] PA = new String[10];  
        String[] SA = new String[10];
        int[] telefono = new int[10];
        int[] edad = new int[100];
        String[] RH = new String[10];
        String[] correo = new String[50];
        String[] ocupacion = new String[100];
       

       
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese PRIMER NOMBRE " + (i + 1)+":" );
            N[i] = Sc.nextLine();

            System.out.print("Ingrese SEGUNDO NOMBRE " + (i + 1)+":" );
            SN[i] = Sc.nextLine();

            System.out.print("Ingrese PRIMER APELLIDO " + (i + 1)+":" );
            PA[i] = Sc.nextLine();

            System.out.print("Ingrese SEGUNDO APELLIDO " + (i + 1)+":" );
            SA[i] = Sc.nextLine();

             System.out.print("ingrese telefono " + (i + 1)+":" );
            telefono[i] =  Sc.nextInt();

            System.out.print("ingrese edad " + (i + 1)+":" );
            edad[i] =  Sc.nextInt();

            System.out.print("ingrese RH " + (i + 1)+":" );
            RH[i] =  Sc.nextLine();

            System.out.print("ingrese correo " + (i + 1)+":" );
            correo[i] = Sc.nextLine();

            System.out.print("ingrese ocupacion " + (i + 1)+":" );
            ocupacion[i] = Sc.nextLine();
        }

        System.out.println("tabla de usuarios");
        for (int i = 0; i < 10; i++) {
            System.out.println("Usuario " + (i + 1) + ": "
                + N[i] + " " + SN[i] + " " + PA[i] + " " + SA[i]
                + ", Tel: " + telefono[i]
                + ", Edad: " + edad[i]
                + ", RH: " + RH[i]
                + ", Correo: " + correo[i]
                + ", Ocupación: " + ocupacion[i]);
        }

        Sc.close(); 
    }
}