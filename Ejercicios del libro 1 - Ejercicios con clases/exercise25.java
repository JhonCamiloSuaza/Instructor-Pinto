public class exercise25 {

    public static todos Todos = new todos();

    public static void vocal(){

        todos.SEMAF = 'V';

        while (todos.SEMAF == 'V') {
            switch (Character.toLowerCase(todos.letra)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                todos.SEMAF = 'R';
                break;
                default:
                todos.SEMAF = 'V';
                break;
            }              
        }
    }
}
