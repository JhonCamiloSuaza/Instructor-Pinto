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
            System.out.println("6. Ejecutar despachos a clínicas");
            System.out.println("7. Salir");
            System.out.print("Opción: ");
            opcion = entradaUsuario.nextInt();
            entradaUsuario.nextLine();

            switch (opcion) {
                case 1 -> mostrarConductores();
                case 2 -> mostrarPacientes();
                case 3 -> registrarMuerte();
                case 4 -> funerariaCentral.mostrarReporte();
                case 5 -> mostrarEstadoGeneral();
                case 6 -> CentroDespacho.ejecutarDespachos(listaConductores, matrizPacientes, listaAmbulancias);
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 7);
    }

    static void inicializarSistema() {
        for (int i = 0; i < 10; i++) {
            System.out.print("Nombre del conductor " + (i + 1) + ": ");
            String nombre = entradaUsuario.nextLine();
            System.out.print("Apellido: ");
            String apellido = entradaUsuario.nextLine();
            System.out.print("Celular: ");
            String celular = entradaUsuario.nextLine();
            System.out.print("ID ambulancia: ");
            String idAmb = entradaUsuario.nextLine();

            listaConductores[i] = new Conductor(nombre, apellido, celular, idAmb);
            listaAmbulancias[i] = new Ambulancia(idAmb, listaConductores[i]);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("Nombre del paciente [" + i + "][" + j + "]: ");
                matrizPacientes[i][j] = new Paciente(entradaUsuario.nextLine());
            }
        }
    }

    static void mostrarConductores() {
        for (Ambulancia a : listaAmbulancias) {
            System.out.println(a.mostrarDatos());
        }
    }

    static void mostrarPacientes() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Conductor " + (i + 1) + ":");
            for (int j = 0; j < 10; j++) {
                matrizPacientes[i][j].mostrarEstado();
            }
        }
    }

    static void registrarMuerte() {
        System.out.print("Fila del paciente (0-9): ");
        int fila = entradaUsuario.nextInt();
        System.out.print("Columna (0-9): ");
        int col = entradaUsuario.nextInt();
        entradaUsuario.nextLine();

        System.out.print("Tipo de muerte: ");
        String tipo = entradaUsuario.nextLine();

        if (conductorFunebre == null) {
            System.out.println("Seleccione conductor:");
            for (int i = 0; i < 10; i++) {
                System.out.println(i + ". " + listaConductores[i].nombre);
            }
            conductorFunebre = listaConductores[entradaUsuario.nextInt()];
            entradaUsuario.nextLine();
        }

        funerariaCentral.registrarMuerte(conductorFunebre, matrizPacientes[fila][col], tipo);
    }

    static void mostrarEstadoGeneral() {
        for (int i = 0; i < 10; i++) {
            System.out.println(listaAmbulancias[i].mostrarDatos());
            for (int j = 0; j < 10; j++) {
                matrizPacientes[i][j].mostrarEstado();
            }
        }

        if (conductorFunebre != null) {
            System.out.println("Conductor funeraria: " + conductorFunebre.nombre);
        }
    }
}
