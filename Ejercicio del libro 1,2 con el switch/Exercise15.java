import java.text.DecimalFormat; 
import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.####");

        int opcion;

        // Variables generales declaradas al inicio
        int n = 0, m = 0;
        long comparaciones = 0;
        long operacionesTrivial = 0;
        long operacionesDivideYVenceras = 0;
        int tiempoOriginal = 0, nuevoTiempo = 0, tamanioOriginal = 0;
        double entradaLineal = 0, entradaCuadratica = 0, entradaExponencial = 0;
        boolean encontrado;

        do {
            System.out.println("Seleccione el número de la pregunta que desea resolver:");
            System.out.println("1. Orden de f(n) - g(n)");
            System.out.println("2. Demostración de logaritmos");
            System.out.println("3. Justificación de afirmaciones");
            System.out.println("4. Procedimiento G(n) - Complejidad");
            System.out.println("5. Números Triangulares");
            System.out.println("6. Mayor tamaño de entrada con tiempo limitado");
            System.out.println("7. Máquina más rápida con tiempo limitado");
            System.out.println("8. Algoritmo máximo y mínimo - Comparaciones");
            System.out.println("9. Ecuación de recurrencia");
            System.out.println("10. Análisis de funciones recursivas");
            System.out.println("11. Algoritmo StringSearch - Comparaciones");
            System.out.println("12. Ordenamiento por Mergesort");
            System.out.println("13. Algoritmo de Palíndromo");
            System.out.println("14. Comparación de algoritmos Divide y Vencerás vs Trivial");
            System.out.println("15. Algoritmo MAX_MIN - Comparaciones");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese n: ");
                    n = scanner.nextInt();

                    int h = n * n;

                    int f1 = h + 3;
                    int g1 = h;
                    int diferencia1 = f1 - g1;

                    int f2 = 2 * h;
                    int g2 = h;
                    int diferencia2 = f2 - g2;

                    System.out.println("Caso 1: Diferencia constante");
                    System.out.println("f(n) = n^2 + 3 = " + f1);
                    System.out.println("g(n) = n^2     = " + g1);
                    System.out.println("f(n) - g(n)    = " + diferencia1);

                    System.out.println("Caso 2: Diferencia proporcional");
                    System.out.println("f(n) = 2n^2 = " + f2);
                    System.out.println("g(n) = n^2  = " + g2);
                    System.out.println("f(n) - g(n) = " + diferencia2);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad para logaritmos: ");
                    n = scanner.nextInt();

                    for (int i = 2; i <= n; i *= 2) {
                        double log_a = Math.log(i) / Math.log(2);
                        double log_b = Math.log(i) / Math.log(4);
                        double powLog2 = Math.pow(2, log_a);
                        double powLog4 = Math.pow(2, log_b);

                        System.out.printf("n=%d, log2(n)=%.2f, log4(n)=%.2f, 2^log2=%.2f, 2^log4=%.2f\n",
                                i, log_a, log_b, powLog2, powLog4);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la cantidad para justificación: ");
                    n = scanner.nextInt();

                    for (int i = 0; i <= n; i++) {
                        double f = Math.pow(2, i);
                        double h3 = Math.pow(3, i);

                        if (f > h3) {
                            System.out.println("Es falso para n = " + i);
                        } else {
                            System.out.println("Es verdadero para n = " + i);
                            System.out.println("f(n) = " + f + ", h(n) = " + h3);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Ingrese x para procedimiento G(n): ");
                    n = scanner.nextInt();
                    int suma = 0;
                    for (int i = 1; i <= n; i++) {
                        suma += i;
                    }
                    System.out.println("G(n) = " + suma);
                    break;

                case 5:
                    System.out.print("Ingrese un número para verificar si es triangular: ");
                    n = scanner.nextInt();

                    int sumaTri = 0;
                    int i = 1;
                    while (sumaTri < n) {
                        sumaTri += i;
                        i++;
                    }

                    if (sumaTri == n) {
                        System.out.println(n + " es un número triangular.");
                    } else {
                        System.out.println(n + " no es un número triangular.");
                    }
                    break;

                case 6:
                    tiempoOriginal = 1;
                    nuevoTiempo = 3 * 60 * 60;
                    tamanioOriginal = 1000000;

                    entradaLineal = (double) tamanioOriginal * nuevoTiempo / tiempoOriginal;
                    entradaCuadratica = Math.sqrt(entradaLineal);
                    entradaExponencial = Math.log10((double) nuevoTiempo / tiempoOriginal) + Math.log10(tamanioOriginal);

                    System.out.printf("Lineal: %.0f\n", entradaLineal);
                    System.out.printf("Cuadrática: %.0f\n", entradaCuadratica);
                    System.out.printf("Exponencial: %.2f\n", entradaExponencial);
                    break;

                case 7:
                    System.out.print("Ingrese tamaño de entrada n: ");
                    n = scanner.nextInt();
                    System.out.print("Ingrese factor de mejora de la nueva máquina: ");
                    int nueva_maquina = scanner.nextInt();

                    int k1 = nueva_maquina * n;
                    int k2 = nueva_maquina * 2 * n;
                    int k3 = nueva_maquina * 10 * n;

                    System.out.println("1. Máquina nueva: " + k1);
                    System.out.println("2. Máquina nueva: " + k2);
                    System.out.println("3. Máquina nueva: " + k3);
                    break;

                case 8:
                    System.out.print("Ingrese la cantidad de números: ");
                    n = scanner.nextInt();

                    int mayor = Integer.MIN_VALUE;
                    int menor = Integer.MAX_VALUE;
                    int num;

                    for (int j = 1; j <= n; j++) {
                        System.out.print("Ingrese número " + j + ": ");
                        num = scanner.nextInt();

                        if (num > mayor) mayor = num;
                        if (num < menor) menor = num;
                    }
                    System.out.println("El número mayor es: " + mayor);
                    System.out.println("El número menor es: " + menor);
                    break;

                case 9:
                    System.out.print("Ingrese n > 1 para ecuación de recurrencia: ");
                    n = scanner.nextInt();

                    if (n <= 1) {
                        System.out.println("n debe ser mayor que 1.");
                    } else {
                        long T = n;
                        for (int it = 1; it <= 5; it++) {
                            long resultado = 2 * T + (long) (Math.log(T) / Math.log(2));
                            System.out.printf("Iteración %d: T(n) = %d, Resultado = %d\n", it, T, resultado);
                            T /= 4;
                            if (T == 0 && it < 5) T = 1;
                        }
                        System.out.println("Orden estimado: Θ(n)");
                    }
                    break;

                case 10:
                    System.out.println("Ejercicio 10: Funciones total y parcial");
                    System.out.print("Introduce n: ");
                    n = scanner.nextInt();

                    int resultadoTotal = 0;
                    for (int x = 1; x <= n; x++) {
                        resultadoTotal += x;
                    }
                    System.out.println("Resultado total(n): " + resultadoTotal);

                    System.out.print("Introduce m para total(n,m): ");
                    m = scanner.nextInt();
                    int resultadoTotalNM = 0;
                    for (int x = n; x <= m; x++) {
                        resultadoTotalNM += x;
                    }
                    System.out.println("Resultado total(n,m): " + resultadoTotalNM);
                    break;

                case 11:
                    System.out.println("Ejercicio 11: Buscar primera aparición de un string");

                    System.out.print("Introduce cadena A: ");
                    String A = scanner.nextLine();
                    System.out.print("Introduce cadena B: ");
                    String B = scanner.nextLine();

                    encontrado = false;
                    int comienzo = -1;
                    int N = A.length();
                    int M = B.length();
                    int limite = N - M + 1;
                    int com = 0;
                    int j;

                    while (!encontrado && com < limite) {
                        int i2 = com;
                        j = 0;
                        while (j < M && A.charAt(i2) == B.charAt(j)) {
                            i2++;
                            j++;
                        }
                        encontrado = (j == M);
                        if (!encontrado) {
                            com++;
                        }
                    }
                    comienzo = encontrado ? com : -1;

                    System.out.println("¿Encontrado?: " + encontrado);
                    System.out.println("Comienzo: " + comienzo);
                    break;

                case 12:
                    System.out.println("Ejercicio 12: Complejidad de mergesort generalizado");
                    System.out.println("T(n) = 2*T(n/2) + O(n log n)"); 
                    System.out.println("Aquí dividir el vector en n/2 trozos de tamaño 2 y hacer merge n/2 secuencias.");
                    System.out.println("Complejidad total: O(n log n) (análisis detallado omiso en código)");
                    break;

                case 13:
                    System.out.println("Ejercicio 13: Comprobar si cadena es palíndromo");

                    System.out.print("Introduce cadena C (solo 'a' y 'b'): ");
                    String C = scanner.nextLine();

                    boolean esPalindromo = true;
                    for (int x = 0; x < C.length() / 2; x++) {
                        if (C.charAt(x) != C.charAt(C.length() - 1 - x)) {
                            esPalindromo = false;
                            break;
                        }
                    }
                    System.out.println("¿Es palíndromo?: " + esPalindromo);
                    break;

                case 14:
                    System.out.println("Ejercicio 14: Estrategia divide y vencerás vs algoritmo trivial");

                    System.out.println("Algoritmo trivial: t(n) ∈ Θ(n²)");
                    System.out.println("Divide y vencerás: D(n) = n log n + C(n) = n log n + n log n = 2 n log n ∈ Θ(n log n)");
                    System.out.println("Conclusión: Divide y vencerás es más eficiente que el algoritmo trivial para n grandes.");
                    break;

                case 15:
                    System.out.println("Ejercicio 15: Número de comparaciones para MAX_MIN recursivo");

                    System.out.print("Introduce tamaño vector: ");
                    n = scanner.nextInt();
                    int[] vector = new int[n];
                    System.out.println("Introduce elementos:");
                    for (int x = 0; x < n; x++) {
                        vector[x] = scanner.nextInt();
                    }

                    int comparacionesTotal = 0;
                    int max = vector[0];
                    int min = vector[0];

                    for (int x = 1; x < n; x++) {
                        comparacionesTotal++;
                        if (vector[x] > max) {
                            max = vector[x];
                        } else {
                            comparacionesTotal++;
                            if (vector[x] < min) {
                                min = vector[x];
                            }
                        }
                    }

                    System.out.println("Número de comparaciones en peor caso: " + comparacionesTotal);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }
}