public class Conductor {
    public String nombre;
    public String apellido;
    public String celular;
    public String idAmbulancia;

    public Conductor(String nombre, String apellido, String celular, String idAmbulancia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.idAmbulancia = idAmbulancia;
    }

    public String mostrarDatos() {
        return "Conductor: " + nombre + " " + apellido + ", Celular: " + celular + ", Ambulancia: " + idAmbulancia;
    }
}
