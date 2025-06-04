
public class exercise16 {
    public static todos Todos = new todos();

    public static void mensaje() {

        switch (todos.numero1) {
            case 1:
            {
                todos.numero1=1;
                System.out.println("su vocal equivalente es: A");
                break;
            }
            case 2:
            {
                todos.numero1=2;
                System.out.println("su vocal equivalente es: E");
                break;
            }
            case 3:
            {
                todos.numero1=3;
                System.out.println("su vocal equivalente es: I");
                break;
            }
            case 4:
            {
                todos.numero1=4;
                System.out.println("su vocal equivalente es: O");
                break;
            }
            case 5:
            {
                todos.numero1=5;
                System.out.println("su vocal equivalente es: U");
                break;
            }
            default:
            break;
        }
    }
}
