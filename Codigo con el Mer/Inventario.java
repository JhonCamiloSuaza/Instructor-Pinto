public class Inventario {
    public int sillas;
    public int tableros;
    public int proyectores;
    public String observaciones;

    public Inventario(int sillas, int tableros, int proyectores, String observaciones) {
        this.sillas = sillas;
        this.tableros = tableros;
        this.proyectores = proyectores;
        this.observaciones = observaciones;
    }

    public void mostrarInventario() {
        System.out.println("Sillas: " + sillas);
        System.out.println("Tableros: " + tableros);
        System.out.println("Proyectores: " + proyectores);
        System.out.println("Observaciones: " + observaciones);
    }
}
