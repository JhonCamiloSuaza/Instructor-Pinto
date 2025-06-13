import java.util.Scanner;

public class Main {
    static Conductor[] listaConductores = new Conductor[10];
    static Ambulancia[] listaAmbulancias = new Ambulancia[10];
    static Paciente[][] matrizPacientes = new Paciente[10][10];
    static Funeraria funerariaCentral = new Funeraria("Funeraria Central");
    static Scanner entradaUsuario = new Scanner(System.in);
    static Conductor conductorFunebre;  
    public static void main(String[] args) {
        int opcion;
        inicializarSistema();

        do {
            System.out.println("\n--- MENÚ DEL SISTEMA ---");
            System.out.println("1. Mostrar conductores y ambulancias");
            System.out.println("2. Mostrar todos los pacientes");
            System.out.println("3. Registrar una muerte");
            System.out.println("4. Mostrar reporte de muertes");
            System.out.println("5. Mostrar estado general del sistema");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (opcion) {
                case 1:
                    for (Ambulancia a : listaAmbulancias) {
                        System.out.println(a.mostrarDatos());
                    }
                    break;

                case 2:
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Conductor " + (i + 1) + " (" + listaConductores[i].nombre + "): ");
                        for (int j = 0; j < 10; j++) {
                            matrizPacientes[i][j].mostrarEstado();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese fila del paciente (0-9): ");
                    int fila = entradaUsuario.nextInt();
                    System.out.print("Ingrese columna del paciente (0-9): ");
                    int col = entradaUsuario.nextInt();
                    entradaUsuario.nextLine();

                    System.out.print("Tipo de muerte: ");
                    String tipo = entradaUsuario.nextLine();

                    if (conductorFunebre == null) {
                        System.out.println("\nSeleccione conductor para recoger el muerto:");
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i + ". " + listaConductores[i].nombre + " " + listaConductores[i].apellido);
                        }
                        System.out.print("Ingrese número del conductor: ");
                        int num = entradaUsuario.nextInt();
                        entradaUsuario.nextLine();
                        conductorFunebre = listaConductores[num];
                    }

                    funerariaCentral.registrarMuerte(conductorFunebre, matrizPacientes[fila][col], tipo);
                    break;

                case 4:
                    funerariaCentral.mostrarReporte();
                    break;

                case 5:
                    mostrarEstadoGeneral();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    static void inicializarSistema() {
        System.out.println("REGISTRO DE CONDUCTORES Y AMBULANCIAS ");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nIngrese datos del conductor " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = entradaUsuario.nextLine();
            System.out.print("Apellido: ");
            String apellido = entradaUsuario.nextLine();
            System.out.print("Celular: ");
            String celular = entradaUsuario.nextLine();
            System.out.print("ID de ambulancia asignada: ");
            String idAmbulancia = entradaUsuario.nextLine();

            listaConductores[i] = new Conductor(nombre, apellido, celular, idAmbulancia);
            listaAmbulancias[i] = new Ambulancia(idAmbulancia, listaConductores[i]);
        }

        System.out.println("\n REGISTRO DE PACIENTES ==");
        for (int i = 0; i < 10; i++) {
            System.out.println("Conductor " + (i + 1) + " atenderá 10 pacientes:");
            for (int j = 0; j < 10; j++) {
                System.out.print("Nombre del paciente " + (j + 1) + ": ");
                String nombrePaciente = entradaUsuario.nextLine();
                matrizPacientes[i][j] = new Paciente(nombrePaciente);
            }
        }
    }

    static void mostrarEstadoGeneral() {
        System.out.println("\nESTADO GENERAL DEL SISTEMA ");
        for (int i = 0; i < 10; i++) {
            System.out.println(listaAmbulancias[i].mostrarDatos());
            for (int j = 0; j < 10; j++) {
                System.out.print("  Paciente " + (j + 1) + ": ");
                matrizPacientes[i][j].mostrarEstado();
            }
        }

        if (conductorFunebre != null) {
            System.out.println("\nConductor asignado para recoger muertos: " + conductorFunebre.nombre + " " + conductorFunebre.apellido);
        } else {
            System.out.println("\nNo hay conductor asignado aún para la carroza fúnebre.");
        }
    }
}
