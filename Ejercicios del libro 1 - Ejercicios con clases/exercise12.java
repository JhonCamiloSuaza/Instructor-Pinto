public class exercise12 {
    public static todos Todos = new todos();
    public static void numeroMayor() {
        
        if ((todos.numero1>todos.numero2)&&(todos.numero1>todos.numero3)) {
            System.out.println("El numero es: "+todos.numero1);
        } else if (todos.numero2>todos.numero3) {
            System.out.println("El numero mayor es el: "+todos.numero2);
        } else{
            System.out.println("El numero mayor es el: "+todos.numero3);
        }
        
    }
}
