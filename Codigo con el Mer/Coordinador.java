import java.util.ArrayList;

public class Coordinador {
    String nombre;
    ArrayList<Instructor> instructoresAsignados = new ArrayList<>();

    public Coordinador(String nombre) {
        this.nombre = nombre;
    }
}
