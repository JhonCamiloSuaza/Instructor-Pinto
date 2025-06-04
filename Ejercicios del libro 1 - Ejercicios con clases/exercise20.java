public class exercise20 {

    public static todos Todos = new todos();

    public static void sueldo() {
        todos.calcularInt=0;

        for(todos.contador=1; todos.contador<=todos.numero1; todos.contador++){

            todos.calcularInt=todos.calcularInt+todos.numero2;
        }

        todos.calcularInt3=todos.calcularInt+todos.numero2;

        System.out.println("Sueldo promedio: "+todos.calcularInt3);
    }
}
