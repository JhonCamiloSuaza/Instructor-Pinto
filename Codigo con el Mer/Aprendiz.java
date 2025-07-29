public class Aprendiz {
    String nombre;
    String programa;
    String linea;
    String jornada;
    java.util.List<String> jornadas;

    public Aprendiz(String nombre, String programa, String linea, String jornada) {
        this.nombre = nombre;
        this.programa = programa;
        this.linea = linea;
        this.jornada = jornada;
    }
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Programa: " + programa);
        System.out.println("Línea: " + linea);
        System.out.println("Jornada: " + jornada);
    }
}
