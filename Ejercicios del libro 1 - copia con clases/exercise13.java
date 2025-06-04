public class exercise13 {
    public static todos Todos = new todos();

    public static void triangulo() {
        
        if ((todos.numero1!=todos.numero2)&&(todos.numero2 != todos.numero3) && (todos.numero3!=todos.numero1)) {
            System.out.println("El triangulo es Escaleno");

        }else if ((todos.numero1==todos.numero2)&&(todos.numero2==todos.numero3)){
            System.out.println("El triangulo es Equilatero");
            
        }else{
            System.out.println("El tipo de triangulo es Isoceles");
        }
        
    }
}
