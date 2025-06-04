public class exercise28 {
    public static todos Todos = new todos();
    public static void consonantes(){
        todos.numero1 = 0; 
        todos.numero2 = 0;

        for (todos.contador = 1; todos.contador <= 10; todos.contador++) {
            System.out.print("Ingrese una letra (" + todos.contador + " de 10): ");
            todos.letra = todos.teclado.next().charAt(0);

                        
            todos.letra = Character.toLowerCase(todos.letra);

            switch (todos.letra) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    todos.numero1++;
                    break;
                    default:
                    if (Character.isLetter(todos.letra)) {
                        todos.numero2++;
                    } else {
                        System.out.println("No es una letra válida, no se cuenta.");
                    }
            }
            System.out.println("\nNúmero de vocales: " + todos.numero1);
            System.out.println("Número de consonantes: " + todos.numero2);    
                        
        }
    }
}
