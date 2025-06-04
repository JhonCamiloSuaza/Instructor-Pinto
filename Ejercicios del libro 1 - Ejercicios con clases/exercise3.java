public class exercise3 {
    public static todos Todos = new todos();

    public static void respuestas() {

        todos.calcularInt=todos.numero1*4;
        todos.calcularInt2=todos.numero2*-1;

        todos.calcularInt3= todos.calcularInt+todos.calcularInt2;
        
        if (todos.calcularInt3<0) {
            System.out.println("La nota es 0"+todos.calcularInt3);
        }
        System.out.println("el puntaje final es: "+todos.calcularInt3);
       


        
    }
}
