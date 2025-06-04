public class exercise24 {
    public static todos Todos = new todos();
    public static void sarie(){

        todos.numero1=0;
        while (todos.numero1<1000) {
            System.out.println(todos.numero1);
            todos.numero1= (todos.numero1 * todos.numero1) + 1;
        }
    }
}
