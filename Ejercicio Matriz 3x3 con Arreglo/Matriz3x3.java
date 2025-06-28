import java.util.ArrayList;
import java.util.Scanner;

public class Matriz3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        ArrayList<Integer> datosUsuario = new ArrayList<>();

        System.out.println("Ingrese 9 números para llenar la matriz 3x3:");
        for (int i = 0; i < 9; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            datosUsuario.add(scanner.nextInt());
        }


        int index = 0;
        System.out.println("\nMatriz generada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = datosUsuario.get(index++);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nIngrese un número objetivo (1 a 45): ");
        int objetivo = scanner.nextInt();

  
        ArrayList<Integer> combinacion = encontrarCombinacion(datosUsuario, objetivo);

        if (combinacion != null) {
            System.out.println("Combinación encontrada que suma " + objetivo + ": " + combinacion);
        } else {
            System.out.println("No se encontró ninguna combinación que sume " + objetivo);
        }
    }

  
    public static ArrayList<Integer> encontrarCombinacion(ArrayList<Integer> numeros, int objetivo) {
        return backtrack(numeros, objetivo, new ArrayList<>(), 0);
    }

    private static ArrayList<Integer> backtrack(ArrayList<Integer> numeros, int objetivo, ArrayList<Integer> camino, int inicio) {
        int suma = 0;
        for (int num : camino) suma += num;
        if (suma == objetivo) return new ArrayList<>(camino);
        if (suma > objetivo) return null;

        for (int i = inicio; i < numeros.size(); i++) {
            camino.add(numeros.get(i));
            ArrayList<Integer> resultado = backtrack(numeros, objetivo, camino, i + 1);
            if (resultado != null) return resultado;
            camino.remove(camino.size() - 1);
        }

        return null;
    }
}
