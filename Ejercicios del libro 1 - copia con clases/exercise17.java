public class exercise17 {
    public static todos Todos = new todos();
    
    public static void decenas(){
        todos.calcularInt= (int)(todos.numero1/10);
        todos.calcularInt2=todos.numero1-(todos.calcularInt*10);
        System.out.println("Decenas:"+todos.calcularInt);
        System.out.println("Unidades"+todos.calcularInt2);
    }

}
