
import java.util.Scanner;
public class exercise10 {
public static todos Todos = new todos() ;
    public static void Edad_mayor() {
    if (todos.numero1>todos.numero2) {
        System.out.println("El primer hermano es mayor");
        todos.calcularInt=todos.numero1-todos.numero2;
        }else{
            System.out.println("El segundo hermano es mayor");
            todos.calcularInt=todos.numero2-todos.numero1;
        }
        System.out.println("La diferencia de edad es: "+todos.calcularInt);
    
    }
}
