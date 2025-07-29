import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        String opcion;
        boolean salir = false;

        do {
            System.out.println(" MENU DEL COLEGIO");
            System.out.println("1. Nombre del colegio que va a crear");
            System.out.println("2. Crear un máximo de 11 aulas, con grados aleatorios");
            System.out.println("3. Reporte general del colegio");
            System.out.println("4. Buscar cuántos salones hay de un grado específico");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = Teclado.nextLine();

            switch (opcion) {
                case "1":
                    Salida.nombre();
                    break;
                case "2":
                    Salida.Aula();
                    break;
                case "3":
                    Salida.Reporte();
                    break;
                case "4":
                    Salida.buscarSalonesPorGrado();
                    break;
                case "5":
                    salir = true;
                    break;
                
                default:
                    System.out.println("Opción no válida");
            }
        } while (!salir);
        Teclado.close();
        System.out.println("Gracias por usar el sistema del colegio. ¡Hasta luego!...");
    }
}
