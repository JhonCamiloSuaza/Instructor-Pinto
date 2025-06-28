public class Clinica {
    public String nombre;
    public int distanciaKm;

    public Clinica(String nombre, int distanciaKm) {
        this.nombre = nombre;
        this.distanciaKm = distanciaKm;
    }

    public String mostrarDatos() {
        return "Clínica: " + nombre + ", Distancia ida y vuelta: " + distanciaKm + " km";
    }
}
