public class Paciente {
    public String nombre;
    public boolean estaMuerto;
    public String tipoMuerte;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.estaMuerto = false;
        this.tipoMuerte = "";
    }

    public void marcarComoMuerto(String tipo) {
        estaMuerto = true;
        tipoMuerte = tipo;
    }

    public void mostrarEstado() {
        if (estaMuerto) {
            System.out.println(nombre + " - FALLECIDO (" + tipoMuerte + ")");
        } else {
            System.out.println(nombre + " - Vivo");
        }
    }
}
