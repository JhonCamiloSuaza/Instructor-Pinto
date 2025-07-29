import java.util.Random;
import java.util.Scanner;

public class Salida {
    static Scanner Teclado = new Scanner(System.in);
    static Random random = new Random();

    static int totalSalones = 0;
    static int totalAlumnos = 0;
    static String nombreColegio = "";
    static String[][] aulas = new String[11][2]; 

    public static void nombre() {
        System.out.print("Ingrese nombre del colegio:  " + nombreColegio);
        nombreColegio = Teclado.nextLine();
        System.out.println("Bienvenido al colegio: " + nombreColegio);
    }

    public static void Aula() {
        System.out.print("¿Cuántas aulas desea crear? (máximo 11): ");
        int cantidad = Teclado.nextInt();
        Teclado.nextLine(); 

        if (cantidad > 11) {
            System.out.println("Error: no puede crear más de 11 aulas");
            return;
        }

        String[] grados = {
            "Primero", "Segundo", "Tercero", "Cuarto", "Quinto",
            "Sexto", "Séptimo", "Octavo", "Noveno", "Décimo", "Once"
        };

        totalSalones = cantidad;
        totalAlumnos = 0;

        System.out.println("\n--- Distribución de aulas ---");
        for (int i = 0; i < cantidad; i++) {
            String grado = grados[random.nextInt(grados.length)];
            char seccion = (char) ('A' + contarSecciones(grado)); // sección A, B, C...
            aulas[i][0] = grado;
            aulas[i][1] = String.valueOf(seccion);
            int alumnos = 25;
            totalAlumnos += alumnos;
            System.out.println("Aula " + (i + 1) + " - Grado " + grado + " " + seccion + ": " + alumnos + " alumnos");
        }
    }

    public static int contarSecciones(String grado) {
        int count = 0;
        for (int i = 0; i < aulas.length; i++) {
            if (aulas[i][0] != null && aulas[i][0].equalsIgnoreCase(grado)) {
                count++;
            }
        }
        return count;
    }

    public static void Reporte() {
        System.out.println("REPORTE DEL COLEGIO ");
        System.out.println("Nombre del colegio: " + nombreColegio);
        System.out.println("Total de aulas: " + totalSalones);
        System.out.println("Total de alumnos: " + totalAlumnos);
    }

    public static void buscarSalonesPorGrado() {
        if (aulas[0][0] == null) {
            System.out.println("Primero debe crear las aulas con la opción 2.");
            return;
        }

        System.out.print("Ingrese el grado que desea buscar (ejemplo: Noveno): ");
        String gradoBuscado = Teclado.nextLine();
        int contador = 0;

        System.out.print("Salones: ");
        for (int i = 0; i < totalSalones; i++) {
            if (aulas[i][0] != null && aulas[i][0].equalsIgnoreCase(gradoBuscado)) {
                contador++;
                System.out.print(gradoBuscado + " " + aulas[i][1] + "  ");
            }
        }

        if (contador == 0) {
            System.out.println("No hay salones asignados al grado " + gradoBuscado);
        } else {
            System.out.println("\nGrado " + gradoBuscado + ": " + contador + " salones");
            System.out.println("Total de alumnos en grado " + gradoBuscado + ": " + (contador * 25));
        }
        
    }
}
 