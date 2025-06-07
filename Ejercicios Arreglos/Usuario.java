public class Usuario {
    public String primerNombre ;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public int telefono;
    public int edad;
    public String rh;
    public String correo;
    public String ocupacion;

    public Usuario(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
        int telefono, int edad, String rh, String correo, String ocupacion) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.edad = edad;
        this.rh = rh;
        this.correo = correo;
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido +
                ", Tel: " + telefono +
                ", Edad: " + edad +
                ", RH: " + rh +
                ", Correo: " + correo +
                ", Ocupación: " + ocupacion;
    }
}