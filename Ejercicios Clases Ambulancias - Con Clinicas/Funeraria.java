import java.util.ArrayList;

public class Funeraria {
    public String nombre;
    public ArrayList<String> reporteMuertes = new ArrayList<>();

    public Funeraria(String nombre) {
        this.nombre = nombre;
    }

    public void registrarMuerte(Conductor conductor, Paciente paciente, String tipoMuerte) {
        paciente.marcarComoMuerto(tipoMuerte);
        String registro = "Paciente: " + paciente.nombre + ", Muerte: " + tipoMuerte +
                ", Recolectado por: " + conductor.nombre + " " + conductor.apellido +
                " (" + conductor.idAmbulancia + ")";
        reporteMuertes.add(registro);
        System.out.println("\nMuerte registrada correctamente.\n");
    }

    public void mostrarReporte() {
        System.out.println("\nREPORTE DE MUERTES");
        if (reporteMuertes.isEmpty()) {
            System.out.println("No hay muertes registradas...");
        } else {
            for (String r : reporteMuertes) {
                System.out.println(r);
            }
        }
    }
}
