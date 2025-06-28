public class Ambulancia {
    public String id;
    public Conductor conductor;

    public Ambulancia(String id, Conductor conductor) {
        this.id = id;
        this.conductor = conductor;
    }

    public String mostrarDatos() {
        return "Ambulancia " + id + " Asignada a " + conductor.nombre + " " + conductor.apellido;
    }
}
