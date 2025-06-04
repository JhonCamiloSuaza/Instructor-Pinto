import java.util.Scanner;
public class exercise29 {
    public static Scanner teclado = new Scanner(System.in); 
    public static todos Todos = new todos();

    public static void votos(){
        todos.numero1 = 0; 
        todos.numero2 = 0; 
        todos.numero3 = 0; 
        todos.numero4 = 0; 

                    
        for ( todos.contador = 1; todos.contador <= 10; todos.contador++) {
            System.out.print("Ingrese el voto del elector " + todos.contador + " (1, 2, 3 o cualquier otro para nulo/blanco): ");
            todos.numero5 = teclado.nextInt();

            switch (todos.numero5) {
                case 1:
                todos.numero1++;
                break;
                case 2:
                todos.numero2++;
                break;
            case 3:
                todos.numero3++;
                break;
            default:
                todos.numero4++;
            }   
        }

        if (todos.numero1 > todos.numero2 && todos.numero1 > todos.numero3 && todos.numero1 > todos.numero4) {
            todos.calcularInt = 1;
        } else if (todos.numero2 > todos.numero1 && todos.numero2 > todos.numero3 && todos.numero2 > todos.numero4) {
            todos.calcularInt = 2;
        } else if (todos.numero3 > todos.numero1 && todos.numero3 > todos.numero2 && todos.numero3 > todos.numero4) {
            todos.calcularInt = 3;
        } else {
            todos.calcularInt = 0; 
        }

                        
        System.out.println("\nResultados:");
        System.out.println("Candidato 1: " + todos.numero1 + " votos");
        System.out.println("Candidato 2: " + todos.numero2 + " votos");
        System.out.println("Candidato 3: " + todos.numero3 + " votos");
        System.out.println("Votos nulos o en blanco: " + todos.numero4);

        if (todos.calcularInt == 0) {
            System.out.println("No hay un ganador claro o ganó el voto nulo/blanco.");
        } else {
            System.out.println("El ganador es el Candidato " + todos.calcularInt);
        }
    }
}
