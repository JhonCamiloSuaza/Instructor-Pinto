public class exercise22 {
    public static todos Todos = new todos() ;

    public static void suma(){

        for (todos.contador=0; todos.contador<todos.numero2;todos.contador++){
            todos.calcularInt=todos.calcularInt+todos.numero1;
        }
        System.out.println("Resultado: "+todos.calcularInt);
        
    }
}
