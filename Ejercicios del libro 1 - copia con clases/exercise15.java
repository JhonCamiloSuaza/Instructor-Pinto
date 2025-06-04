public class exercise15 {

    public static todos Todos = new todos();

    public static void ventas() {

        todos.calcularInt=0;

        switch (todos.numero1) {
            case 1:
            {
                if (todos.numero1>=0 && todos.numero1<1000) {
                    todos.calcularInt=(0*todos.numero1)/100;
                }
                break;
            }
            case 2:
            {
                if (todos.numero1>=1000 && todos.numero1<5000) {
                    todos.calcularInt=(3*todos.numero1)/100;
                }
                break;
            }
            case 3:
            {
                if (todos.numero1>=5000 && todos.numero1<20000) {
                    todos.calcularInt=(5*todos.numero1)/100;
                }
                break;
            }
            case 4:
            {
                if (todos.numero1==20000) {
                    todos.calcularInt=(8*todos.numero1)/100;
                } 
                break; 
            }
            default:
            break;
        }
        System.out.println("Su bonificacion es: "+todos.calcularInt);
    }
}

