import java.util.Scanner;

public class ExerciseParesImparesYPrimos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0, j, k, opcion, contador;

        System.out.println("Ingresa un numero: ");
            i = scanner.nextInt();

            while (i > 500) {
                System.out.println("Numero Menor O Igual a 500");
                System.out.println("Por favor digite otro valor en el rango");
                i = scanner.nextInt();
            }

            System.out.println("Seleccione un ejercicio:");
            System.out.println("1. Numeros pares");
            System.out.println("2. Numeros impares");
            System.out.println("3. Numeros primos");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Numeros pares hasta: " + i);
                for(j = 1; j <= i; j++){
                    if(j % 2 == 0){
                        System.out.println(j);
                    }
                }
                break;

                case 2:
                System.out.println("Numeros impares hasta: " + i);
                for(j = 1; j <= i; j += 2){
                    System.out.println(j);
                }
                break;

                case 3:
                    System.out.println("numeros primo hasta:");
                    for (j = 2; j <= i; j++) {
                        contador = 0;
                    for (k = 1; k <= j; k++) {
                        if (j % k == 0) {
                        contador++;
                    }
                }
                    if (contador == 2) {
                        System.out.println(j);
                    }
                }
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
    scanner.close();
    }
}