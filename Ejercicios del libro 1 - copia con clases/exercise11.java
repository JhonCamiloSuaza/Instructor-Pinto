public class exercise11 {

    public static todos Todos = new todos() ;
    public static void promedio() {

        todos.calcularInt=(todos.numero1+todos.numero2+todos.numero3+todos.numero4+todos.numero5+todos.numero6);
        todos.calcularInt2=todos.calcularInt/6;

        if (todos.calcularInt2>=100) {
            System.out.println("Recibira incestivos");
        } else {
            System.out.println("No recibira incestivos");
        }
    }
}
