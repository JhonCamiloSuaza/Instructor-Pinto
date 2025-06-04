public class exercise4 {
    public static todos Todos = new todos();

    public static void partidos() {
        
        todos.calcularInt=todos.numero1*3;
        todos.calcularInt2=todos.numero2*1;

        todos.calcularInt3= todos.calcularInt+todos.calcularInt2;
        
        System.out.println("sus puntos totales son... :  "+todos.calcularInt3);
        

    }
}
