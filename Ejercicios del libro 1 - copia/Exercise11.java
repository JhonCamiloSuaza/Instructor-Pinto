import java.util.Scanner;
public class Exercise11 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int PL, PMa, PMi, PJ, PV, PS;
        int PT;         
        double PP;      
        String MSG;   

        
        System.out.println("producción del día Lunes:");
        PL = teclado.nextInt();

        System.out.println("  del día Martes:");
        PMa = teclado.nextInt();

        System.out.println(" producción del día Miércoles:");
        PMi = teclado.nextInt();

        System.out.println("producción del día Jueves:");
        PJ = teclado.nextInt();

        System.out.println(" producción del día Viernes:");
        PV = teclado.nextInt();

        System.out.println(" producción del día Sábado:");
        PS = teclado.nextInt();

        
        PT = PL + PMa + PMi + PJ + PV + PS;
        PP = PT / 6.0;

    
        if (PP >= 100) {
            MSG = "Recibirá Incentivos";
        } else {
            MSG = "No Recibirá Incentivos";
        }

    
        System.out.println(MSG);

        teclado.close();
    }
}