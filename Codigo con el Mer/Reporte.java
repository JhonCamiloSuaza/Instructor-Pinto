public class Reporte {

    public static void reporteInstructoresTotales(Instructor[] instructores) {
        System.out.println(" INSTRUCTORES REGISTRADOS ");
        for (int i = 0; i < instructores.length; i++) {
            if (instructores[i] != null) {
                System.out.println("Nombre: " + instructores[i].nombre);
                System.out.println("Línea: " + instructores[i].linea);
                System.out.println("Horario: " + instructores[i].horario);
            }
        }
    }

    public static void reporteInstructoresPorLinea(Instructor[] instructores, String linea) {
        System.out.println(" INSTRUCTORES POR LÍNEA: " + linea + "");
        for (int i = 0; i < instructores.length; i++) {
            if (instructores[i] != null && instructores[i].linea.equalsIgnoreCase(linea)) {
                System.out.println("Nombre: " + instructores[i].nombre);
                System.out.println("Horario: " + instructores[i].horario);
            
            }
        }
    }

    public static void reporteAprendicesTotales(Aprendiz[] aprendices) {
        System.out.println("APRENDICES REGISTRADOS");
        for (int i = 0; i < aprendices.length; i++) {
            if (aprendices[i] != null) {
                aprendices[i].mostrarInformacion();
            
            }
        }
    }

    public static void reporteAprendicesPorLinea(Aprendiz[] aprendices, String linea) {
        System.out.println(" APRENDICES POR LÍNEA: " + linea + " ");
        for (int i = 0; i < aprendices.length; i++) {
            if (aprendices[i] != null && aprendices[i].linea.equalsIgnoreCase(linea)) {
                aprendices[i].mostrarInformacion();
    
            }
        }
    }

    public static void reporteAmbientesPorEspecialidad(String[] especialidades, String[] programas, int cantidadAmbientes, String filtroEspecialidad) {
        System.out.println(" AMBIENTES POR ESPECIALIDAD: " + filtroEspecialidad + " ");
        for (int i = 0; i < cantidadAmbientes; i++) {
            if (especialidades[i] != null && especialidades[i].equalsIgnoreCase(filtroEspecialidad)) {
                System.out.println("Ambiente #" + (i + 1));
                System.out.println("Especialidad: " + especialidades[i]);
                System.out.println("Programa: " + programas[i]);
         
            }
        }
    }

    public static void reporteAmbientesPorPrograma(String[] especialidades, String[] programas, int cantidadAmbientes, String filtroPrograma) {
        System.out.println(" AMBIENTES POR PROGRAMA: " + filtroPrograma + " ");
        for (int i = 0; i < cantidadAmbientes; i++) {
            if (programas[i] != null && programas[i].equalsIgnoreCase(filtroPrograma)) {
                System.out.println("Ambiente #" + (i + 1));
                System.out.println("Especialidad: " + especialidades[i]);
                System.out.println("Programa: " + programas[i]);
           
            }
        }
    }
}
