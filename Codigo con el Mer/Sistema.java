import java.util.Scanner;

public class Sistema {
    static Scanner sc = new Scanner(System.in);

    // Variables para RF1 y RF2
    static String regional, centro, sede;
    static int cantidadAmbientes;

    // Variables generales
    static String[] lineas;
    static String[] tiposAmbiente;
    static String[][] aprendices;
    static String[][] aprendicesPorAmbiente; 
    static String[][] horariosAprendices;     
    static int[] cantidadAprendicesPorAmbiente;
    static java.util.ArrayList<Aprendiz> aprendicesRegistrados = new java.util.ArrayList<>();

    // Variables para RF7 y RF8
    static String[] programas;
    static String[] instructores;
    static String[] lineasInstructores;

    // Variables para RF9
    static String[] horariosInstructor;

    // Variables para RF10 y RF11
    static String coordinador;
    static String[] instructoresCoordinador;
    static String[] instructorPorAmbiente;

    // Variable para RF14
    static String[][] programasPorLinea;

    // Variable para RF15
    static Inventario[] inventarios;

    // Variables para RNF16
    static String[] instructoresAsignados = new String[50];
    static String[] sedesInstructor = new String[50];
    static String[] lineasInstructor = new String[50];
    static String[] programasInstructor = new String[50];
    static int totalInstructores = 0;

    // Variables para RNF17, RNF18, RNF19
    static int contadorInstructores = 0;
    static String[] horarioInstructor = new String[50];
    static int contadorAprendices = 0;
    static String[] lineaAprendiz = new String[100];
    static String[] programaAprendiz = new String[100];
// Variable 20, 21, 22
static Ambiente[] ambientes = new Ambiente[50];


    static int totalAmbientes = 0;
    static int totalAprendices = 0;
    String nombre;
    String linea;

    // RF1 - Registrar Regional, Centro y Sede
    public static void registrarRegionalCentroSede() {
        System.out.print("Ingrese el nombre de la Regional: ");
        regional = sc.nextLine();
        System.out.print("Ingrese el nombre del Centro: ");
        centro = sc.nextLine();
        System.out.print("Ingrese el nombre de la Sede: ");
        sede = sc.nextLine();
        System.out.println("Datos registrados correctamente.");
    }

    // RF2 - Definir Cantidad de Ambientes
    public static void definirCantidadAmbientes() {
        System.out.print("Ingrese la cantidad de ambientes: ");
        cantidadAmbientes = sc.nextInt();
        sc.nextLine();

        // Inicializar arrays
        lineas = new String[cantidadAmbientes];
        tiposAmbiente = new String[cantidadAmbientes];
        aprendices = new String[cantidadAmbientes][10];
        cantidadAprendicesPorAmbiente = new int[cantidadAmbientes];
        programas = new String[cantidadAmbientes];
        instructores = new String[cantidadAmbientes];
        lineasInstructores = new String[cantidadAmbientes];
        horariosInstructor = new String[cantidadAmbientes];
        instructoresCoordinador = new String[cantidadAmbientes];
        instructorPorAmbiente = new String[cantidadAmbientes];
        aprendicesPorAmbiente = new String[cantidadAmbientes][];
        horariosAprendices = new String[cantidadAmbientes][];
        programasPorLinea = new String[cantidadAmbientes][];
        inventarios = new Inventario[cantidadAmbientes];

        System.out.println("Cantidad de ambientes definidos.");
    }

    // RF3 - Asignar ambiente a línea
    public static void asignarAmbienteALinea() {
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.print("Ingrese la línea para el ambiente " + (i + 1) + ": ");
            lineas[i] = sc.nextLine();
        }
        System.out.println("Ambientes asignados a líneas correctamente.");
    }

    // RF4 - Identificar tipo de ambiente
    public static void identificarTipoAmbiente() {
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.print("Ingrese el tipo de ambiente (Normal/Especializado) para " + lineas[i] + ": ");
            tiposAmbiente[i] = sc.nextLine();
        }
        System.out.println("Tipos de ambiente registrados.");
    }

    // RF5 - Asignar aprendices a ambiente
    public static void asignarAprendices() {
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.print("¿Cuántos aprendices desea asignar al ambiente " + (i + 1) + "? ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            cantidadAprendicesPorAmbiente[i] = cantidad;

            for (int j = 0; j < cantidad; j++) {
                System.out.print("Nombre del aprendiz " + (j + 1) + ": ");
                aprendices[i][j] = sc.nextLine();
            }
        }
        System.out.println("Aprendices asignados exitosamente.");
    }

    // RF6 - Registrar aprendices (línea y programa)
    public static void registrarAprendices() {
    System.out.print("¿Cuántos aprendices desea registrar?: ");
    int cantidad = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < cantidad; i++) {
        System.out.println(" Aprendiz #" + (i + 1) + "");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Programa de formación: ");
        String programa = sc.nextLine();

        System.out.print("Línea tecnológica: ");
        String linea = sc.nextLine();

        System.out.print("Jornada (mañana,tarde,noche, separadas por coma ): ");
        String jornada = sc.nextLine().toLowerCase();   

        // RNF18: Validar si ya está en otra línea o programa
        boolean duplicado = false;
        for (Aprendiz a : aprendicesRegistrados) {
            if (a.nombre.equalsIgnoreCase(nombre)) {
                if (!a.programa.equalsIgnoreCase(programa) || !a.linea.equalsIgnoreCase(linea)) {
                    System.out.println(" ERROR: El aprendiz ya está registrado en otro programa o línea.");
                    duplicado = true;
                    break;
                }
            }
        }

            // RNF19: Validar si ya tiene más de 2 jornadas distintas
            int contadorJornadas = 0;
            for (Aprendiz a : aprendicesRegistrados) {
                if (a.nombre.equalsIgnoreCase(nombre)) {
                    if (!a.jornada.equalsIgnoreCase(jornada)) {
                        contadorJornadas++;
                    }
                }
            }
            if (contadorJornadas >= 2) {
                System.out.println(" ERROR: El aprendiz no puede estar en más de dos jornadas.");
                continue;
            }

            if (!duplicado) {
                aprendicesRegistrados.add(new Aprendiz(nombre, programa, linea, jornada));
                System.out.println(" Aprendiz registrado correctamente.\n");
            }
        }
    }

    // RF7 - Registrar instructor y asociar a línea
public static void registrarInstructor() {
    for (int i = 0; i < cantidadAmbientes; i++) {
        System.out.print("Nombre del instructor del ambiente " + (i + 1) + ": ");
        instructores[i] = sc.nextLine();
        System.out.print("Línea que orienta el instructor: ");
        lineasInstructores[i] = sc.nextLine();
        contadorInstructores++;
    }

    System.out.println("Instructores registrados.");

    // Mostrar lo registrado
    System.out.println(" LISTA DE INSTRUCTORES REGISTRADOS ");
    for (int i = 0; i < cantidadAmbientes; i++) {
        System.out.println("Ambiente " + (i + 1) + ": " + instructores[i] + " - Línea: " + lineasInstructores[i]);
    }
}

    // RF8 - Asignar horario al instructor
    public static void asignarHorarioInstructor() {
        System.out.println("ASIGNACIÓN DE HORARIO (RNF17)");
    System.out.print("Ingrese el nombre del instructor: ");
    String nombre = sc.nextLine();

    boolean encontrado = false;
    for (int i = 0; i < instructores.length; i++) {
        if (instructores[i] != null && instructores[i].equalsIgnoreCase(nombre)) {
            encontrado = true;
            if (horariosInstructor[i] != null && !horariosInstructor[i].isEmpty()) {
                System.out.println(" Este instructor ya tiene un horario asignado: " + horariosInstructor[i]);
            } else {
                System.out.print("Ingrese la jornada (mañana,tarde,noche, separadas por coma): ");
                String jornada = sc.nextLine().toLowerCase();
                System.out.print("Ingrese el horario: ");
                String horas = sc.nextLine();
                horariosInstructor[i] = jornada + ":" + horas;
                System.out.println(" Horario asignado correctamente.");
            }
            break;
        }
    }

    if (!encontrado) {
        System.out.println(" Instructor no encontrado.");
    }
}

    // RF9 - Definir coordinador y asignar instructores
    public static void definirCoordinador() {
        System.out.print("Ingrese el nombre del coordinador académico: ");
        coordinador = sc.nextLine();
        for (int i = 0; i < cantidadAmbientes; i++) {
            instructoresCoordinador[i] = instructores[i];
        }
        System.out.println("Coordinador e instructores asociados correctamente.");
    }

    // RF10 - Descripción de ambientes
    public static void descripcionAmbientes() {
        System.out.println(" Descripción de ambientes");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + ": Línea: " + lineas[i] +
                            ", Programa: " + programas[i]);
            System.out.println("Coordinador de la línea: " + coordinador);
            System.out.println("Aprendices:");
            for (int j = 0; j < cantidadAprendicesPorAmbiente[i]; j++) {
                System.out.println("- " + aprendices[i][j]);
            }
            System.out.println();
        }
    }

    // RF11 - Asignar instructor a ambiente
    public static void asignarInstructorAmbiente() {
        System.out.println(" Asignar Instructor a Ambiente");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + ": Línea " + lineas[i]);
            System.out.println("Instructores disponibles:");
            for (int j = 0; j < instructores.length; j++) {
                System.out.println((j + 1) + ". " + instructores[j]);
            }
            System.out.print("Seleccione el número del instructor para este ambiente: ");
            int opcion = Integer.parseInt(sc.nextLine());
            instructorPorAmbiente[i] = instructores[opcion - 1];
            System.out.println("Instructor asignado correctamente.");
        }

        System.out.println("Resumen de asignación de instructores:");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + " - Instructor asignado: " + instructorPorAmbiente[i]);
        }
    }

    // RF12 - Asignar aprendiz por programa
    public static void asignarAprendizPorPrograma() {
        System.out.println("Asignar aprendices a cada ambiente según programa ");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + ": Línea " + lineas[i]);
            System.out.print("Digite el programa de formación: ");
            programas[i] = sc.nextLine();
            System.out.print("¿Cuántos aprendices tiene este ambiente?: ");
            cantidadAprendicesPorAmbiente[i] = Integer.parseInt(sc.nextLine());
            aprendicesPorAmbiente[i] = new String[cantidadAprendicesPorAmbiente[i]];
            for (int j = 0; j < cantidadAprendicesPorAmbiente[i]; j++) {
                System.out.print("Nombre del aprendiz " + (j + 1) + ": ");
                aprendicesPorAmbiente[i][j] = sc.nextLine();
            }
        }

        System.out.println("Resumen de asignación de aprendices:");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + " - Programa: " + programas[i]);
            for (int j = 0; j < cantidadAprendicesPorAmbiente[i]; j++) {
                System.out.println("- " + aprendicesPorAmbiente[i][j]);
            }
        }
    }

    // RF13 - Asignar horario a cada aprendiz
    public static void mostrarHorarioAprendiz() {
        System.out.println(" Asignar horarios a los aprendices ");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + " - Programa: " + programas[i]);
            horariosAprendices[i] = new String[cantidadAprendicesPorAmbiente[i]];
            for (int j = 0; j < cantidadAprendicesPorAmbiente[i]; j++) {
                System.out.print("Horario del aprendiz " + aprendicesPorAmbiente[i][j] + ": ");
                horariosAprendices[i][j] = sc.nextLine();
            }
        }

        System.out.println("Resumen de horarios por aprendiz:");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + ":");
            for (int j = 0; j < cantidadAprendicesPorAmbiente[i]; j++) {
                System.out.println("- " + aprendicesPorAmbiente[i][j] + ": " + horariosAprendices[i][j]);
            }
        }
    }

    // RF14 - Asignar programa de formación por línea
    public static void asignarProgramasPorLinea() {
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.print("¿Cuántos programas tiene la línea " + lineas[i] + "?: ");
            int cantidadProgramas = sc.nextInt();
            sc.nextLine(); 
            programasPorLinea[i] = new String[cantidadProgramas];
            for (int j = 0; j < cantidadProgramas; j++) {
                System.out.print("Ingrese el nombre del programa " + (j + 1) + ": ");
                programasPorLinea[i][j] = sc.nextLine();
            }
        }
        System.out.println("Programas de formación registrados por línea correctamente.");
    }

    // RF15 - Registrar inventario por ambiente RNF15
    public static void registrarInventarioAmbientes() {
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Inventario para ambiente " + (i + 1) + " (" + lineas[i] + ")");

            System.out.print("Ingrese cantidad de sillas: ");
            int sillas = sc.nextInt();

            System.out.print("Ingrese cantidad de tableros: ");
            int tableros = sc.nextInt();

            System.out.print("Ingrese cantidad de proyectores: ");
            int proyectores = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Ingrese observaciones: ");
            String observaciones = sc.nextLine();

            // Crear el inventario para este ambiente
            inventarios[i] = new Inventario(sillas, tableros, proyectores, observaciones);
        }

        // Mostrar todos los inventarios registrados
        System.out.println(" INVENTARIO REGISTRADO EN TODOS LOS AMBIENTES ");
        for (int i = 0; i < cantidadAmbientes; i++) {
            System.out.println("Ambiente " + (i + 1) + ":");
            inventarios[i].mostrarInventario();
            System.out.println();
        }
    }

    // RNF16 - Validar usuario que no esté repetido
    public static void validarUsuarioNoRepetido() {
        System.out.println("ASIGNACIÓN UNICA (RNF16)");

        System.out.print("Nombre del instructor: ");
        String nombre = sc.nextLine();

        System.out.print("Sede: ");
        String sede = sc.nextLine();

        System.out.print("Línea: ");
        String linea = sc.nextLine();

        System.out.print("Programa: ");
        String programa = sc.nextLine();

        for (int i = 0; i < totalInstructores; i++) {
            if (instructoresAsignados[i] != null && instructoresAsignados[i].equalsIgnoreCase(nombre)) {
                System.out.println(" ERROR: El instructor ya está asignado a:");
                System.out.println(" Sede: " + sedesInstructor[i]);
                System.out.println(" Línea: " + lineasInstructor[i]);
                System.out.println(" Programa: " + programasInstructor[i]);
                return;
            }
        }

        // Registrar si no está repetido
        instructoresAsignados[totalInstructores] = nombre;
        sedesInstructor[totalInstructores] = sede;
        lineasInstructor[totalInstructores] = linea;
        programasInstructor[totalInstructores] = programa;
        totalInstructores++;

        System.out.println(" Instructor asignado correctamente.");
    }

    // RNF17 - Asignar horario sin repetir instructor
   public static void asignarHorarioSinRepetir() {
    System.out.println("ASIGNACIÓN DE HORARIO (RNF17)");
    System.out.print("Ingrese el nombre del instructor: ");
    String nombre = sc.nextLine();

    for (int i = 0; i < totalInstructores; i++) {
        if (instructoresAsignados[i] != null && instructoresAsignados[i].equalsIgnoreCase(nombre)) {
            if (horarioInstructor[i] != null && !horarioInstructor[i].isEmpty()) {
                System.out.println(" Este instructor ya tiene un horario asignado: " + horarioInstructor[i]);
            } else {
                System.out.print("Ingrese la jornada (mañana,tarde,noche, separadas por coma ): ");
                String jornada = sc.nextLine().toLowerCase();
                System.out.print("Ingrese el horario: ");
                String horas = sc.nextLine();
                horarioInstructor[i] = jornada + ":" + horas;
                System.out.println(" Horario asignado correctamente.");
            }
            return;
        }
    }
    System.out.println(" Instructor no encontrado.");
}
    // Validar aprendiz en una sola línea y programa

public static void validarAprendizUnaLineaUnPrograma() {
    for (int i = 0; i < aprendicesRegistrados.size(); i++) {
        Aprendiz a = aprendicesRegistrados.get(i);
        for (int j = i + 1; j < aprendicesRegistrados.size(); j++) {
            Aprendiz b = aprendicesRegistrados.get(j);
            if (a.nombre.equalsIgnoreCase(b.nombre)) {
                if (!a.linea.equalsIgnoreCase(b.linea) ||
                    !a.programa.equalsIgnoreCase(b.programa)) {
                    System.out.println("ERROR: El aprendiz " + a.nombre +
                            " está en más de una línea o programa.");
                    return;
                }
            }
        }
    }
    System.out.println(" Todos los aprendices tienen una sola línea y programa.");
}
    //  RNF19 
  public static void validarAprendizMaxDosJornadas() {
    System.out.println(" VALIDACIÓN DE JORNADAS (MÁXIMO 2) ");
    boolean hayInconsistencias = false;

    
    java.util.Map<String, java.util.List<String>> aprendizJornadas = new java.util.HashMap<>();

    // Paso 1: Recopilar todas las jornadas de cada aprendiz
    for (Aprendiz a : aprendicesRegistrados) {
        String[] jornadas = a.jornada.split(",");
        aprendizJornadas.putIfAbsent(a.nombre, new java.util.ArrayList<>());
        
        for (String j : jornadas) {
            String jornadaLimpia = j.trim().toLowerCase();
            if (!aprendizJornadas.get(a.nombre).contains(jornadaLimpia)) {
                aprendizJornadas.get(a.nombre).add(jornadaLimpia);
            }
        }
    }

    // Paso 2: Identificar aprendices con más de 2 jornadas
    for (java.util.Map.Entry<String, java.util.List<String>> entry : aprendizJornadas.entrySet()) {
        if (entry.getValue().size() > 2) {
            hayInconsistencias = true;
            System.out.println("\n[ALERTA] El aprendiz '" + entry.getKey() + "' tiene " + 
                    entry.getValue().size() + " jornadas:");
            System.out.println("Jornadas: " + String.join(", ", entry.getValue()));
            System.out.println("Programa: " + obtenerProgramaAprendiz(entry.getKey())); // Función auxiliar
        }
    }

    // Paso 3: Resumen final
    if (!hayInconsistencias) {
        System.out.println(" Todos los aprendices cumplen con el máximo de 2 jornadas.");
    } else {
        System.out.println("CORRECCIÓN REQUERIDA:");
        System.out.println("Los aprendices marcados deben ajustar sus jornadas a máximo 2.");
    }
}

// Función auxiliar para obtener el programa de un aprendiz
private static String obtenerProgramaAprendiz(String nombreAprendiz) {
    for (Aprendiz a : aprendicesRegistrados) {
        if (a.nombre.equalsIgnoreCase(nombreAprendiz)) {
            return a.programa;
        }
    }
    return "No registrado";
}

    // RF20 - Reporte de instructores

    public static void reporteInstructores() {
        System.out.println("1. Reportar Todos");
        System.out.println("2. Reportar por Línea");
        System.out.print("Seleccione opción: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op == 1) {
            for (int i = 0; i < totalInstructores; i++) {
                System.out.println("Nombre: " + instructores[i]);
                System.out.println("Línea: " + lineasInstructores[i]);
                System.out.println("");
            }
        } else if (op == 2) {
            System.out.print("Ingrese línea: ");
            String lineaBuscada = sc.nextLine();
            for (int i = 0; i < totalInstructores; i++) {
                if (lineasInstructores[i].equalsIgnoreCase(lineaBuscada)) {
                    System.out.println("Nombre: " + instructores[i]);
                    System.out.println("Línea: " + lineasInstructores[i]);
                    System.out.println("");
                }
            }
        }
    }

    public static void reporteAprendices() {
        System.out.println("1. Reportar Todos");
        System.out.println("2. Reportar por Línea");
        System.out.println("3. Reportar por Programa");
        System.out.print("Seleccione opción: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op == 1) {
            for (Aprendiz aprendiz : aprendicesRegistrados) {
                aprendiz.mostrarInformacion();
                System.out.println("");
            }
        } else if (op == 2) {
            System.out.print("Ingrese línea: ");
            String linea = sc.nextLine();
            for (Aprendiz aprendiz : aprendicesRegistrados) {
                if (aprendiz.linea.equalsIgnoreCase(linea)) {
                    aprendiz.mostrarInformacion();
                    System.out.println("");
                }
            }
        } else if (op == 3) {
            System.out.print("Ingrese programa: ");
            String programa = sc.nextLine();
            for (Aprendiz aprendiz : aprendicesRegistrados) {
                if (aprendiz.programa.equalsIgnoreCase(programa)) {
                    aprendiz.mostrarInformacion();
                    System.out.println("");
                }
            }
        }
    }


public static void reporteAmbientes() {
    System.out.println(" REPORTE DE AMBIENTES ");
    System.out.println("1. Reportar por Línea Tecnológica (Especialidad)");
    System.out.println("2. Reportar por Programa de Formación");
    System.out.print("Seleccione opción: ");
    int opcion = Integer.parseInt(sc.nextLine());

    if (opcion == 1) {
        System.out.print("Ingrese la línea tecnológica a consultar: ");
        String lineaBuscada = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < cantidadAmbientes; i++) {
            if (lineas[i] != null && lineas[i].equalsIgnoreCase(lineaBuscada)) {
                System.out.println("Ambiente " + (i + 1));
                System.out.println("Línea: " + lineas[i]);
                System.out.println("Tipo de Ambiente: " + tiposAmbiente[i]);
                System.out.println("Programa: " + programas[i]);
                System.out.println("Instructor: " + instructorPorAmbiente[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron ambientes con esa línea tecnológica.");
        }

    } else if (opcion == 2) {
        System.out.print("Ingrese el programa de formación a consultar: ");
        String programaBuscado = sc.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < cantidadAmbientes; i++) {
            if (programas[i] != null && programas[i].equalsIgnoreCase(programaBuscado)) {
                System.out.println("Ambiente " + (i + 1));
                System.out.println("Programa: " + programas[i]);
                System.out.println("Línea: " + lineas[i]);
                System.out.println("Tipo de Ambiente: " + tiposAmbiente[i]);
                System.out.println("Instructor: " + instructorPorAmbiente[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron ambientes con ese programa de formación.");
        }

    } else {
        System.out.println("Opción inválida.");
    }
}

   public static void reporteHorariosPorJornada() {
    System.out.println(" REPORTE DE HORARIOS POR JORNADA ");
    System.out.println("1. Reportar aprendices por jornada");
    System.out.println("2. Reportar instructores por jornada");
    System.out.println("3. Reporte completo con cantidades");
    System.out.print("Seleccione opción: ");
    int opcion = Integer.parseInt(sc.nextLine());

    switch (opcion) {
      case 1: // Aprendices por jornada 
    System.out.print("Ingrese la jornada (mañana,tarde,noche, por coma): ");
    String jornadaBuscada = sc.nextLine().toLowerCase();
    int contadorAprendices = 0;

    System.out.println("APRENDICES EN JORNADA '" + jornadaBuscada.toUpperCase() + "'");
    for (Aprendiz a : aprendicesRegistrados) {
        String[] jornadas = a.jornada.split(",");
        for (String j : jornadas) {
            if (j.trim().equalsIgnoreCase(jornadaBuscada)) {
                System.out.println("- " + a.nombre + " | " + a.programa + " | " + a.linea);
                contadorAprendices++;
                break; // Evita contar dos veces al mismo aprendiz
            }
        }
    }
    System.out.println("TOTAL APRENDICES: " + contadorAprendices);
    break;

case 2: // Instructores por jornada 
    System.out.print("Ingrese la jornada (mañana,tarde,noche por coma): ");
    String jornadaInstructores = sc.nextLine().toLowerCase();
    int contadorInstructores = 0;

    System.out.println("INSTRUCTORES EN JORNADA '" + jornadaInstructores.toUpperCase() + "'");
    for (int i = 0; i < totalInstructores; i++) {
        if (horarioInstructor[i] != null) {
            String[] partes = horarioInstructor[i].split(":");
            String[] jornadas = partes[0].split(",");
            for (String j : jornadas) {
                if (j.trim().equalsIgnoreCase(jornadaInstructores)) {
                    System.out.println("- " + instructoresAsignados[i] + " | " + 
                        lineasInstructor[i] + " | " + horarioInstructor[i]);
                    contadorInstructores++;
                    break;
                }
            }
        }
    }
    System.out.println("TOTAL INSTRUCTORES: " + contadorInstructores);
    break;
            
        case 3:
            System.out.println(" RESUMEN GENERAL POR JORNADA ");
            
            int mañanaAprendices = 0, tardeAprendices = 0, nocheAprendices = 0;
            int mañanaInstructores = 0, tardeInstructores = 0, nocheInstructores = 0;
            
            // Conteo de aprendices
            for (Aprendiz a : aprendicesRegistrados) {
                if (a.jornada.toLowerCase().contains("mañana")) mañanaAprendices++;
                if (a.jornada.toLowerCase().contains("tarde")) tardeAprendices++;
                if (a.jornada.toLowerCase().contains("noche")) nocheAprendices++;
            }
            // Conteo de instructores
            for (int i = 0; i < totalInstructores; i++) {
                if (horarioInstructor[i] != null) {
                    if (horarioInstructor[i].toLowerCase().contains("mañana")) mañanaInstructores++;
                    if (horarioInstructor[i].toLowerCase().contains("tarde")) tardeInstructores++;
                    if (horarioInstructor[i].toLowerCase().contains("noche")) nocheInstructores++;
                }
            }
            
            System.out.println("MAÑANA:");
            System.out.println("  Aprendices: " + mañanaAprendices);
            System.out.println("  Instructores: " + mañanaInstructores);
            
            System.out.println("TARDE:");
            System.out.println("  Aprendices: " + tardeAprendices);
            System.out.println("  Instructores: " + tardeInstructores);
            
            System.out.println("NOCHE:");
            System.out.println("  Aprendices: " + nocheAprendices);
            System.out.println("  Instructores: " + nocheInstructores);
            
            System.out.println("TOTALES:");
            System.out.println("  Aprendices: " + (mañanaAprendices + tardeAprendices + nocheAprendices));
            System.out.println("  Instructores: " + (mañanaInstructores + tardeInstructores + nocheInstructores));
            break;
            
        default:
            System.out.println("Opción inválida.");
    }
   }
}