public class exercise23 {
    public static todos Todos = new todos() ;
    public static void menores(){
        while (todos.numero1<1000) {
            todos.numero1=(todos.numero1*todos.numero1)+1;
            System.out.println(todos.numero1);

        }
    }
}
