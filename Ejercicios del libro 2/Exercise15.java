import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.####");

        int opcion;
        int n = 0, m = 0;
        long comparaciones = 0;
        long operacionesTrivial = 0;
        long operacionesDivideYVenceras = 0;
        int tiempoOriginal, nuevoTiempo, tamanioOriginal;
        double entradaLineal, entradaCuadratica, entradaExponencial;

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

            switch (opcion) {
                case 1:
                    System.out.println("Ejercicio 1: Orden de f(n) - g(n)");
                    System.out.println();
                    System.out.println("Dado que:");
                    System.out.println("f(n) ∈ Θ(h(n)) ⇒ ∃ c1, c2 > 0, ∃ n1 tal que:");
                    System.out.println("    c1·h(n) ≤ f(n) ≤ c2·h(n), ∀ n ≥ n1");
                    System.out.println();
                    System.out.println("g(n) ∈ Θ(h(n)) ⇒ ∃ c3, c4 > 0, ∃ n2 tal que:");
                    System.out.println("    c3·h(n) ≤ g(n) ≤ c4·h(n), ∀ n ≥ n2");
                    System.out.println();
                    System.out.println("Entonces, ∀ n ≥ max(n1, n2):");
                    System.out.println("    f(n) - g(n) ≤ (c2 - c3)·h(n)");
                    System.out.println("    f(n) - g(n) ≥ (c1 - c4)·h(n)");
                    System.out.println();
                    System.out.println("⇒ Si (c1 > c4) y (c2 > c3), entonces:");
                    System.out.println("    f(n) - g(n) ∈ Θ(h(n))");
                    System.out.println();
                    System.out.println("Por tanto, la resta de dos funciones en Θ(h(n)) también está en Θ(h(n)).");
                    break;

                case 2:
                    System.out.println("Ejercicio 2: Demostración de logaritmos");
                    System.out.print("Ingrese el valor de la base a (por ejemplo, 2): ");
                    double baseA = scanner.nextDouble();
                    System.out.print("Ingrese el valor de la base b (por ejemplo, 3): ");
                    double baseB = scanner.nextDouble();
                    System.out.print("Ingrese el valor de n: ");
                    int valorN = scanner.nextInt();
                    double logBaseA = Math.log(valorN) / Math.log(baseA);
                    double logBaseB = Math.log(valorN) / Math.log(baseB);
                    System.out.printf("logₐ(%d): %.2f\n", valorN, logBaseA);
                    System.out.printf("log_b(%d): %.2f\n", valorN, logBaseB);
                    System.out.println("Ambas funciones están en Θ(log n), pero si a ≠ b, entonces 2·logₐ n ∉ Θ(2·log_b n)");
                    break;

                case 3:
                    System.out.println("Ejercicio 3: Justificación de afirmaciones");
                    System.out.println("(a) VERDADERO: O(f(n)) = O(h(n)) ⇒ O(log f(n)) = O(log h(n))");
                    System.out.println("(b) FALSO: O(log f(n)) = O(log h(n)) no implica O(f(n)) = O(h(n))");
                    break;

                case 4:
                    System.out.println("Ejercicio 4: Procedimiento G(n)");
                    System.out.print("Ingrese el valor de n para el procedimiento G(n): ");
                    int entradaG = scanner.nextInt();
                    long lineas = (entradaG * (entradaG + 1)) / 2;
                    System.out.printf("Líneas del bucle anidado: %d\n", lineas);
                    System.out.println("El orden total considerando recursión es: O(n log n)");
                    break;

                case 5:
                    System.out.println("Ejercicio 5: Números Triangulares");
                    System.out.print("Ingrese un número entero ≥ 1: ");
                    n = scanner.nextInt();
                    int suma = 0, contador = 1;
                    while (suma < n) suma += contador++;
                    System.out.println((suma == n) ? n + " es triangular." : n + " NO es triangular.");
                    break;

                case 6:
                    System.out.println("Ejercicio 6: Tamaño de entrada con más tiempo");
                    System.out.print("Ingrese el tiempo original (horas): ");
                    tiempoOriginal = scanner.nextInt();
                    System.out.print("Ingrese el nuevo tiempo (horas): ");
                    nuevoTiempo = scanner.nextInt();
                    System.out.print("Ingrese el tamaño original de entrada: ");
                    tamanioOriginal = scanner.nextInt();

                    entradaLineal = (double) tamanioOriginal * nuevoTiempo / tiempoOriginal;
                    entradaCuadratica = Math.sqrt(entradaLineal);
                    entradaExponencial = Math.log10((double) nuevoTiempo / tiempoOriginal) + Math.log10(tamanioOriginal);

                    System.out.printf("Lineal: %.0f\n", entradaLineal);
                    System.out.printf("Cuadrática: %.0f\n", entradaCuadratica);
                    System.out.printf("Exponencial: %.2f\n", entradaExponencial);
                    break;

                case 7:
                    System.out.println("Ejercicio 7: Máquina más rápida");
                    System.out.print("Ingrese el tiempo original (horas): ");
                    tiempoOriginal = scanner.nextInt();
                    System.out.print("Ingrese el factor de mejora: ");
                    int mejora = scanner.nextInt();
                    System.out.print("Ingrese el tamaño original de entrada: ");
                    tamanioOriginal = scanner.nextInt();

                    nuevoTiempo = tiempoOriginal * mejora;
                    entradaLineal = (double) tamanioOriginal * nuevoTiempo / tiempoOriginal;
                    entradaCuadratica = Math.sqrt(entradaLineal);
                    entradaExponencial = Math.log10((double) nuevoTiempo / tiempoOriginal) + Math.log10(tamanioOriginal);

                    System.out.printf("Lineal: %.0f\n", entradaLineal);
                    System.out.printf("Cuadrática: %.0f\n", entradaCuadratica);
                    System.out.printf("Exponencial: %.2f\n", entradaExponencial);
                    break;

                case 8:
                    System.out.println("Ejercicio 8: Máximo y mínimo");
                    System.out.print("Ingrese el tamaño del vector: ");
                    n = scanner.nextInt();
                    int[] vector = new int[n];
                    System.out.println("Ingrese los elementos:");
                    for (int i = 0; i < n; i++) vector[i] = scanner.nextInt();

                    int min, max;
                    if (n == 1) {
                        min = max = vector[0];
                    } else {
                        if (vector[0] < vector[1]) {
                            min = vector[0];
                            max = vector[1];
                        } else {
                            min = vector[1];
                            max = vector[0];
                        }

                        for (int i = 2; i + 1 < n; i += 2) {
                            int menor = Math.min(vector[i], vector[i + 1]);
                            int mayor = Math.max(vector[i], vector[i + 1]);
                            if (menor < min) min = menor;
                            if (mayor > max) max = mayor;
                        }

                        if (n % 2 != 0) {
                            if (vector[n - 1] < min) min = vector[n - 1];
                            if (vector[n - 1] > max) max = vector[n - 1];
                        }
                    }

                    System.out.println("Mínimo: " + min);
                    System.out.println("Máximo: " + max);
                    System.out.println("Comparaciones ≈ 3n/2");
                    break;

                case 9:
                    System.out.println("Ejercicio 9: Ecuación de recurrencia");
                    System.out.print("Ingrese n > 1: ");
                    n = scanner.nextInt();
                    if (n <= 1) {
                        System.out.println("n debe ser mayor que 1.");
                    } else {
                        long T = n;
                        for (int i = 1; i <= 5; i++) {
                            long resultado = 2 * T + (long) (Math.log(T) / Math.log(2));
                            System.out.printf("Iteración %d: T(n) = %d, Resultado = %d\n", i, T, resultado);
                            T /= 4;
                            if (T == 0 && i < 5) T = 1;
                        }
                        System.out.println("Orden estimado: Θ(n)");
                    }
                    break;

                case 10:
                    System.out.println("Ejercicio 10: Análisis de funciones recursivas");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    long parcial = (long) Math.pow(2, n);
                    long total = n * n;
                    System.out.printf("parcial(n-1) = 2^%d = %d\n", n, parcial);
                    System.out.printf("total ≈ Θ(n^2) = %d\n", total);
                    break;

                case 11:
                    System.out.println("Ejercicio 11: StringSearch comparaciones");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    System.out.print("Ingrese el valor de m: ");
                    m = scanner.nextInt();
                    comparaciones = (n - m + 1);
                    System.out.printf("Comparaciones en peor caso: %d\n", comparaciones);
                    break;

                case 12:
                    System.out.println("Ejercicio 12: Mergesort");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    long division = (long) (n * (Math.log(n) / Math.log(2)));
                    long mezcla = division;
                    long totalOperaciones = division + mezcla;
                    System.out.printf("División: %d\n", division);
                    System.out.printf("Mezcla: %d\n", mezcla);
                    System.out.printf("Total: %d -> Orden 0 (n log n)\n", totalOperaciones);
                    break;

                case 13:
                    System.out.println("Ejercicio 13: Palíndromo");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    System.out.printf("Comparaciones en peor caso (palíndromo): %d\n", n / 2);
                    break;

                case 14:
                    System.out.println("Ejercicio 14: Divide y Vencerás vs Trivial");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    operacionesDivideYVenceras = (long) (n * (Math.log(n) / Math.log(2)));
                    operacionesTrivial = n * n;
                    System.out.printf("Divide y vencerás (n log n): %d\n", operacionesDivideYVenceras);
                    System.out.printf("Trivial (n²): %d\n", operacionesTrivial);
                    System.out.println((operacionesDivideYVenceras < operacionesTrivial)
                            ? "→ Divide y vencerás es más eficiente."
                            : "→ Trivial es más eficiente.");
                    break;

                case 15:
                    System.out.println("Ejercicio 15: Comparaciones en MAX_MIN");
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    comparaciones = (3 * n / 2) - 2;
                    System.out.printf("Comparaciones en peor caso: %d\n", comparaciones);
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

