public class Ambiente {
    String linea;
    String tipo;
     String especialidad;
    String programa;
    int cantidadAprendices;
    boolean ocupado;

    public Ambiente(String linea, String tipo, String especialidad, String programa) {
        this.linea = linea;
        this.tipo = tipo;
        this.especialidad = especialidad;
        this.programa = programa;
        this.cantidadAprendices = 0;
        this.ocupado = false;
    }

    public void mostrarInfo() {
    }
}