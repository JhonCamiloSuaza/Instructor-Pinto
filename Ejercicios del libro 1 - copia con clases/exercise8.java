
import java.lang.Math;
public class exercise8 {
    public static todos Todos = new todos();
    public static void puntos() {

        todos.CalcularDouble = Math.sqrt(Math.pow(todos.numero2D - todos.numero1D, 2)+ Math.pow(todos.numero3D - todos.numero4D, 2));
        System.out.println("La distancia entre los puntos es: " + todos.CalcularDouble);

    }
}
