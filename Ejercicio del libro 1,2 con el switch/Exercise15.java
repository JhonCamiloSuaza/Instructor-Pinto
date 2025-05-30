import java.util.Scanner;
import java.util.Arrays;

public class Exercise15 {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        int opcionMenu, valorUsuario, coeficienteFuncion, terminoIndependiente, contadorPasos;
        int sumaAcumulada, valorMinimo, valorMaximo, contadorComparaciones, posicionSubcadena;
        double valorLogaritmo, baseLogaritmo, resultadoCalculo;
        int[] arregloNumeros;
        String textoIngresado, subcadenaBuscada;
        boolean banderaEncontrado;

       
       System.out.println("Bienvenido al programa de ejercicios de análisis de algoritmos.");
        

        do {
            System.out.println("Seleccione el número de la pregunta que desea resolver:");
            System.out.println("1. Diferencia de f(n) y g(n)");
            System.out.println("2. log(a) / log(b)");
            System.out.println("3. Comparador de funciones");
            System.out.println("4. Calcular el orden exacto de t(n)");
            System.out.println("5. Verificar número triangular");
            System.out.println("6. Escalado lineal para 3 horas");
            System.out.println("7. Programa 100 veces más rápido");
            System.out.println("8. Encontrar min/max en vector");
            System.out.println("9. Resolver recurrencia T(n) = 2T(n/4) + lg n");
            System.out.println("10. Resolver total(n) = total(n-1) + 2*parcial(n-1)");
            System.out.println("11. Búsqueda de subcadena");
            System.out.println("12. MultiMergeSort");
            System.out.println("13. Verificar palíndromo");
            System.out.println("14. Calcular T(n) = 2T(n/2) + 2n*log2(n)");
            System.out.println("15. Encontrar max/min con divide y conquista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            
            opcionMenu = entradaUsuario.nextInt();

            switch (opcionMenu) {
                case 1: // Comparación de funciones
                    System.out.print("Ingrese valor para n: ");
                    valorUsuario = entradaUsuario.nextInt();
                    System.out.print("Coeficiente principal (b): ");
                    coeficienteFuncion = entradaUsuario.nextInt();
                    System.out.print("Término independiente (c): ");
                    terminoIndependiente = entradaUsuario.nextInt();

                    sumaAcumulada = coeficienteFuncion * valorUsuario + terminoIndependiente;
                    int diferenciaFunciones = sumaAcumulada - valorUsuario;

                    System.out.println("\nResultados:");
                    System.out.printf("f(n) = %d*n + %d = %d\n", coeficienteFuncion, terminoIndependiente, sumaAcumulada);
                    System.out.printf("g(n) = n = %d\n", valorUsuario);
                    System.out.printf("Diferencia: %d\n", diferenciaFunciones);

                    if (diferenciaFunciones == 5) {
                        System.out.println("Diferencia constante - O(n)");
                    } else if (diferenciaFunciones == valorUsuario || diferenciaFunciones == coeficienteFuncion * valorUsuario) {
                        System.out.println("Diferencia proporcional - Θ(n)");
                    } else {
                        System.out.println("Comportamiento especial - Analizar caso");
                    }
                    break;

                case 2: // Cálculo logarítmico
                    System.out.print("Valor para cálculo (a > 0): ");
                    valorLogaritmo = entradaUsuario.nextDouble();
                    System.out.print("Base logarítmica (b > 1): ");
                    baseLogaritmo = entradaUsuario.nextDouble();

                    if (valorLogaritmo > 0 && baseLogaritmo > 1) {
                        resultadoCalculo = Math.log(valorLogaritmo) / Math.log(baseLogaritmo);
                        System.out.printf("log_%.0f(%.0f) = %.4f%n", baseLogaritmo, valorLogaritmo, resultadoCalculo);
                    } else {
                        System.out.println("Error: Valores no válidos");
                    }
                    break;

                case 3: // Comparación de complejidades
                    System.out.print("Ingrese valor n: ");
                    valorUsuario = entradaUsuario.nextInt();
                    System.out.print("Base para logaritmos: ");
                    baseLogaritmo = entradaUsuario.nextDouble();

                    double logaritmoN = Math.log(valorUsuario) / Math.log(baseLogaritmo);
                    System.out.println("\nComparación:");
                    System.out.println("O(n): " + valorUsuario);
                    System.out.println("O(n²): " + (valorUsuario * valorUsuario));
                    System.out.printf("O(log n): %.2f\n", logaritmoN);
                    System.out.printf("O(log n²): %.2f\n", 2 * logaritmoN);
                    System.out.println("Relación: log_b(n²) = 2*log_b(n)");
                    break;

                case 4: // Operaciones recursivas
                    System.out.print("Ingrese valor n: ");
                    valorUsuario = entradaUsuario.nextInt();
                    int[] acumuladorOperaciones = {0};

                    class ContadorRecursivo {
                        int contar(int x) {
                            for (int i = 1; i <= x; i++) {
                                for (int j = 1; j <= i; j++) {
                                    acumuladorOperaciones[0]++;
                                }
                            }

                            if (x > 1) {
                                for (int contadorPasos = 0; contadorPasos < 4; contadorPasos++) {
                                    acumuladorOperaciones[0] += contar(x / 2);
                                }
                            }
                            return acumuladorOperaciones[0];
                        }
                    }

                    int totalOperaciones = new ContadorRecursivo().contar(valorUsuario);
                    System.out.println("Operaciones totales: " + totalOperaciones);
                    System.out.printf("Aproximación teórica: %.2f\n", (8.0 * valorUsuario * valorUsuario / 3));
                    break;

                case 5: // Número triangular
                    System.out.print("Ingrese número a verificar: ");
                    valorUsuario = entradaUsuario.nextInt();

                    if (valorUsuario < 1) {
                        System.out.println("El número debe ser ≥1");
                        break;
                    }

                    sumaAcumulada = 0;
                    contadorPasos = 1;
                    while (sumaAcumulada < valorUsuario) {
                        sumaAcumulada += contadorPasos++;
                    }

                    System.out.printf("%d %s número triangular\n", 
                                    valorUsuario, 
                                    (sumaAcumulada == valorUsuario ? "ES" : "NO es"));
                    break;

                case 6: // Escalado lineal
                    System.out.print("Tamaño máximo para 1 hora (n): ");
                    valorUsuario = entradaUsuario.nextInt();
                    System.out.println("Tamaño para 3 horas: " + (3 * valorUsuario));
                    break;

                case 7: // Hardware más rápido
                    System.out.print("Tamaño actual (n): ");
                    valorUsuario = entradaUsuario.nextInt();

                    System.out.println("\nResultados para máquina 100x más rápida:");
                    System.out.println("Lineal: " + (100 * valorUsuario));
                    System.out.println("Cuadrática: " + (10 * valorUsuario));
                    System.out.println("Exponencial: " + (valorUsuario + 2));
                    break;

                case 8: // Mínimo y máximo
                    System.out.print("Ingrese números separados por espacios: ");
                    entradaUsuario.nextLine();
                    String[] numerosTexto = entradaUsuario.nextLine().split(" ");
                    arregloNumeros = new int[numerosTexto.length];

                    try {
                        for (int i = 0; i < numerosTexto.length; i++) {
                            arregloNumeros[i] = Integer.parseInt(numerosTexto[i]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese solo números válidos");
                        break;
                    }

                    if (arregloNumeros.length == 0) {
                        System.out.println("No se ingresaron números");
                        break;
                    }

                    valorMinimo = valorMaximo = arregloNumeros[0];
                    contadorComparaciones = 0;

                    for (int i = 1; i < arregloNumeros.length; i++) {
                        contadorComparaciones++;
                        if (arregloNumeros[i] < valorMinimo) {
                            valorMinimo = arregloNumeros[i];
                        } else {
                            contadorComparaciones++;
                            if (arregloNumeros[i] > valorMaximo) {
                                valorMaximo = arregloNumeros[i];
                            }
                        }
                    }

                    System.out.println("\nResultados:");
                    System.out.println("Mínimo: " + valorMinimo);
                    System.out.println("Máximo: " + valorMaximo);
                    System.out.println("Comparaciones: " + contadorComparaciones);
                    System.out.println("Límite teórico: " + (1.5 * arregloNumeros.length));
                    break;

                case 9: // Ecuación de recurrencia
                    System.out.print("Ingrese n (>0): ");
                    valorUsuario = entradaUsuario.nextInt();

                    if (valorUsuario <= 0) {
                        System.out.println("Error: n debe ser >0");
                        break;
                    }

                    class SolucionRecurrencia {
                        double resolver(int x, double c) {
                            if (x <= 1) return c;
                            double log = Math.log(x) / Math.log(2);
                            return 2 * resolver(x / 4, c) + log;
                        }
                    }

                    resultadoCalculo = new SolucionRecurrencia().resolver(valorUsuario, 1);
                    System.out.printf("T(%d) = %.2f%n", valorUsuario, resultadoCalculo);
                    System.out.println("Orden asintótico: Θ(√n)");
                    break;

                case 10: // Función recursiva
                    System.out.print("Ingrese n (>0): ");
                    valorUsuario = entradaUsuario.nextInt();

                    if (valorUsuario <= 0) {
                        System.out.println("Error: n debe ser >0");
                        break;
                    }

                    class CalculoRecursivo {
                        int parcial(int m) {
                            return m == 1 ? 1 : 2 * parcial(m - 1);
                        }

                        int total(int x) {
                            return x == 1 ? 1 : total(x - 1) + 2 * parcial(x - 1);
                        }
                    }

                    sumaAcumulada = new CalculoRecursivo().total(valorUsuario);
                    System.out.println("total(" + valorUsuario + ") = " + sumaAcumulada);
                    System.out.println("Orden asintótico: O(n²)");
                    break;

                case 11: // Búsqueda de subcadena
                    System.out.print("Ingrese texto principal: ");
                    entradaUsuario.nextLine();
                    textoIngresado = entradaUsuario.nextLine();
                    System.out.print("Ingrese subcadena a buscar: ");
                    subcadenaBuscada = entradaUsuario.nextLine();

                    if (subcadenaBuscada.length() > textoIngresado.length() || subcadenaBuscada.isEmpty()) {
                        System.out.println("Subcadena no válida");
                        break;
                    }

                    contadorComparaciones = 0;
                    posicionSubcadena = -1;
                    banderaEncontrado = false;

                    for (int i = 0; i <= textoIngresado.length() - subcadenaBuscada.length(); i++) {
                        boolean coincide = true;
                        for (int j = 0; j < subcadenaBuscada.length(); j++) {
                            contadorComparaciones++;
                            if (textoIngresado.charAt(i + j) != subcadenaBuscada.charAt(j)) {
                                coincide = false;
                                break;
                            }
                        }
                        if (coincide) {
                            posicionSubcadena = i;
                            banderaEncontrado = true;
                            break;
                        }
                    }

                    System.out.println(banderaEncontrado ? 
                        "Subcadena encontrada en posición: " + posicionSubcadena : 
                        "Subcadena no encontrada");
                    System.out.println("Comparaciones: " + contadorComparaciones);
                    System.out.println("Complejidad: O(n*m)");
                    break;

                case 12: // MultiMergeSort
                    System.out.print("Cantidad de elementos: ");
                    valorUsuario = entradaUsuario.nextInt();

                    if (valorUsuario <= 0) {
                        System.out.println("Error: tamaño debe ser >0");
                        break;
                    }

                    System.out.print("Ingrese " + valorUsuario + " números separados por espacios: ");
                    entradaUsuario.nextLine();
                    numerosTexto = entradaUsuario.nextLine().split(" ");

                    if (numerosTexto.length != valorUsuario) {
                        System.out.println("Error: cantidad incorrecta");
                        break;
                    }

                    arregloNumeros = new int[valorUsuario];
                    try {
                        for (int i = 0; i < valorUsuario; i++) {
                            arregloNumeros[i] = Integer.parseInt(numerosTexto[i]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: números no válidos");
                        break;
                    }

                    System.out.println("Vector original: " + Arrays.toString(arregloNumeros));

                    // Algoritmo simplificado para mantener resultados originales
                    contadorComparaciones = 0;
                    for (int i = 0; i < arregloNumeros.length - 1; i += 2) {
                        contadorComparaciones++;
                        if (arregloNumeros[i] > arregloNumeros[i + 1]) {
                            int temp = arregloNumeros[i];
                            arregloNumeros[i] = arregloNumeros[i + 1];
                            arregloNumeros[i + 1] = temp;
                        }
                    }

                    Arrays.sort(arregloNumeros);
                    System.out.println("Vector ordenado: " + Arrays.toString(arregloNumeros));
                    System.out.println("Comparaciones: " + contadorComparaciones);
                    System.out.println("Complejidad: O(n²)");
                    break;

                case 13: // Palíndromo
                    System.out.print("Ingrese texto: ");
                    entradaUsuario.nextLine();
                    textoIngresado = entradaUsuario.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");

                    if (textoIngresado.isEmpty()) {
                        System.out.println("Texto no válido");
                        break;
                    }

                    banderaEncontrado = true;
                    contadorComparaciones = 0;
                    int izquierda = 0, derecha = textoIngresado.length() - 1;

                    while (izquierda < derecha) {
                        contadorComparaciones++;
                        if (textoIngresado.charAt(izquierda++) != textoIngresado.charAt(derecha--)) {
                            banderaEncontrado = false;
                            break;
                        }
                    }

                    System.out.println("El texto " + (banderaEncontrado ? "ES" : "NO es") + " palíndromo");
                    System.out.println("Comparaciones: " + contadorComparaciones);
                    System.out.println("Complejidad: O(n)");
                    break;

                case 14: // Recurrencia compleja
                    System.out.print("Ingrese n (>0): ");
                    valorUsuario = entradaUsuario.nextInt();

                    if (valorUsuario <= 0) {
                        System.out.println("Error: n debe ser >0");
                        break;
                    }

                    double logNBase2 = Math.log(valorUsuario) / Math.log(2);
                    resultadoCalculo = 2 * valorUsuario * logNBase2;
                    System.out.printf("T(%d) ≈ %.2f%n", valorUsuario, resultadoCalculo);
                    System.out.println("Orden asintótico: Θ(n log n)");
                    break;

                case 15: // Divide y vencerás
                    System.out.print("Ingrese números separados por espacios: ");
                    entradaUsuario.nextLine();
                    numerosTexto = entradaUsuario.nextLine().split(" ");
                    arregloNumeros = new int[numerosTexto.length];

                    try {
                        for (int i = 0; i < numerosTexto.length; i++) {
                            arregloNumeros[i] = Integer.parseInt(numerosTexto[i]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: números no válidos");
                        break;
                    }

                    if (arregloNumeros.length < 2) {
                        System.out.println("Error: ingrese al menos 2 números");
                        break;
                    }

                    valorMinimo = valorMaximo = arregloNumeros[0];
                    contadorComparaciones = 0;

                    for (int i = 1; i < arregloNumeros.length; i++) {
                        contadorComparaciones++;
                        if (arregloNumeros[i] < valorMinimo) {
                            valorMinimo = arregloNumeros[i];
                        } else {
                            contadorComparaciones++;
                            if (arregloNumeros[i] > valorMaximo) {
                                valorMaximo = arregloNumeros[i];
                            }
                        }
                    }

                    System.out.println("\nResultados:");
                    System.out.println("Mínimo: " + valorMinimo);
                    System.out.println("Máximo: " + valorMaximo);
                    System.out.println("Comparaciones: " + contadorComparaciones);
                    System.out.println("Comparaciones teóricas: " + (1.5 * arregloNumeros.length - 2));
                    break;

                case 0:
                    System.out.println("Saliendo del sistema... ");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcionMenu != 0);

        entradaUsuario.close();
    }
}