import java.util.Scanner;

public class FraseContarLasVocales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa una frase:");
        String frase = sc.nextLine().toLowerCase(); 
        int contadorVocales = 0;
        for (char c : frase.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) { 
                contadorVocales++;
            }
        }
        
        System.out.println("La frase tiene " + contadorVocales + " vocales.");
        sc.close();
    }
}
