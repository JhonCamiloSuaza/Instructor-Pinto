import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double MV;  
        double TB;  

    
        System.out.println("Ingrese el monto de venta mensual:");
        MV = teclado.nextDouble();

        
        if (MV >= 0 && MV < 1000) {
            TB = (0 * MV) / 100;
        } else if (MV >= 1000 && MV < 5000) {
            TB = (3 * MV) / 100;
        } else if (MV >= 5000 && MV < 20000) {
            TB = (5 * MV) / 100;
        } else if (MV >= 20000) {
            TB = (8 * MV) / 100;
        } else {
            
            TB = 0;
            System.out.println("Monto inválido. Debe ser mayor o igual a 0.");
        }

        
        if (MV >= 0) {
            System.out.println("La bonificación correspondiente es: $" + TB);
        }

        teclado.close();
    }
}