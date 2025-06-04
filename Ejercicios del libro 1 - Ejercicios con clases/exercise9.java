
import java.util.Scanner;
public class exercise9 {

    public static todos Todos = new todos() ;
    public static void Cuil(){

        todos.calcularInt=(todos.numero1-todos.numero2);
        System.out.println("Edad:"+todos.calcularInt);
        if (todos.calcularInt>=18) {
            System.out.println("Debe solicitar su CUIL");
        } else {
            System.out.println("No debe solicitar su CUIL aun");
        }
    }
}
