import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int opcion;

    public static void main(String[] args) {
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch(opcion) {
                case 1:
                    Sistema.registrarRegionalCentroSede();
                    break;
                case 2:
                    Sistema.definirCantidadAmbientes();
                    break;
                case 3:
                    Sistema.asignarAmbienteALinea();
                    break;
                case 4:
                    Sistema.identificarTipoAmbiente();
                    break;
                case 5:
                    Sistema.asignarAprendices();
                    break;
                case 6:
                    Sistema.registrarAprendices();
                    break;
                case 7:
                    Sistema.registrarInstructor();
                    break;
                case 8:
                    Sistema.asignarHorarioInstructor();
                    break;
                case 9:
                    Sistema.definirCoordinador();
                    break;
                case 10:
                    Sistema.descripcionAmbientes();
                    break;
                case 11:
                    Sistema.asignarInstructorAmbiente();
                    break;
                case 12:
                    Sistema.asignarAprendizPorPrograma();
                    break;
                case 13:
                    Sistema.mostrarHorarioAprendiz();
                    break;
                case 14:
                    Sistema.asignarProgramasPorLinea();
                    break;
                case 15:
                    Sistema.registrarInventarioAmbientes();
                    break;
                case 16:
                    Sistema.validarUsuarioNoRepetido();
                    break;
                case 17:
                    Sistema.asignarHorarioSinRepetir();
                    break;
                case 18:
                    Sistema.validarAprendizUnaLineaUnPrograma();
                    break;
                case 19:
                    Sistema.validarAprendizMaxDosJornadas();
                    break;
                case 20:
                    Sistema.reporteInstructores();
                    break;
                case 21:
                    System.out.print("Ingrese la línea tecnológica: ");
                    Sistema.reporteAprendices();
                    break;
                case 22:
                    System.out.print("Ingrese el programa de formación: ");
                    Sistema.reporteAmbientes();
                    case 23:
                    System.out.print("Reporte de horarios por jornada cantidad de Alumnos e Instructores:");
                    Sistema.reporteHorariosPorJornada();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        System.out.println("\nPrograma finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar Regional, Centro y Sede");
        System.out.println("2. Definir Cantidad de Ambientes");
        System.out.println("3. Asignar ambiente a línea");
        System.out.println("4. Identificar tipo de ambiente");
        System.out.println("5. Asignar aprendices a ambiente");
        System.out.println("6. Registrar aprendices (línea y programa)");
        System.out.println("7. Registrar instructor y asociar a línea");
        System.out.println("8. Asignar horario al instructor");
        System.out.println("9. Definir coordinador y asignar instructores");
        System.out.println("10. Descripción de ambientes");
        System.out.println("11. Asignar instructor a ambiente");
        System.out.println("12. Asignar aprendiz por programa");
        System.out.println("13. Asignar horario a cada aprendiz");
        System.out.println("14. Asignar programa de formación por línea");
        System.out.println("15. Registrar inventario por ambiente RNF15");
        System.out.println("16. Validar usuario que no esté repetido RNF16");
        System.out.println("17. Asignar horario sin repetir instructor (RNF17)");
        System.out.println("18. Validar que aprendiz no esté en más de una línea o programa (RNF18)");
        System.out.println("19. Validar que este Max 2 Jornada (RNF19)");
        System.out.println("20. Reporte Instructores (Todos)");
        System.out.println("21. Reporte aprendices");
        System.out.println("22. Reporte ambientes ");
        System.out.println("23. Reporte horarios por jornada");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}