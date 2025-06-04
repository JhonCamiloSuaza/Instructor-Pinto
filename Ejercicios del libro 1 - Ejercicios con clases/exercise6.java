public class exercise6 {
    public static todos Todos = new todos();
    public static void areaTriangulo(){
        todos.CalcularDouble = (todos.numero1D + todos.numero2D + todos.numero3D) / 2;

        todos.CalcularDouble2= Math.sqrt(todos.CalcularDouble * (todos.CalcularDouble - todos.numero1D) * (todos.CalcularDouble - todos.numero2D) * (todos.CalcularDouble - todos.numero3D));

        System.out.println("El área del triángulo es... : " + todos.CalcularDouble2);
    }
}
