public class exercise27 {
    public static todos Todos = new todos();
    public static void operador(){
        todos.calcularInt=0;
        switch (todos.letra){
            case '+':{
                todos.calcularInt=todos.numero1+todos.numero2;
                break;
            }
            case '-':{           
                todos.calcularInt=todos.numero1-todos.numero2;         
            }
            case '*':{           
                todos.calcularInt=todos.numero1*todos.numero2;           
                break;
            }
            case '^':{
                todos.calcularInt=((todos.numero1*todos.numero1)+(todos.numero2*todos.numero2));
                break;
            }
        }
        System.out.println("El resultado es: "+todos.calcularInt);
    }
}
