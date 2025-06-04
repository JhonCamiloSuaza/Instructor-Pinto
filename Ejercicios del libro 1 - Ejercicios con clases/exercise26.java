
public class exercise26 {

    public static todos Todos = new todos() ;
    public static void fibonacci() {
        
        todos.numero1=0;
        todos.numero2=1;
        todos.numero3=todos.numero1+todos.numero2;

        System.out.println(todos.numero1);
        System.out.println(todos.numero2);

        while (todos.numero3<1000) {
            System.out.println(todos.numero3);
            
            todos.numero1=todos.numero2;
            todos.numero2=todos.numero3;
            todos.numero3=todos.numero1+todos.numero2;
        }
    }
}
