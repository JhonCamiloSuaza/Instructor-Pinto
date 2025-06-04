public class exercise18 {
    public static todos Todos = new todos();
    public static void entero() {

        todos.calcularInt=todos.numero1/2;
        todos.calcularInt2=todos.numero1-(todos.calcularInt*2);

        if (todos.calcularInt2==0) {
            System.out.println("El numero es par");
        }else{
            System.out.println("El numero es impar");
        }
    }
}
