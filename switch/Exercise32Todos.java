import java.util.Scanner;

public class Exercise32Todos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int A, B, C, D, E, R=0 , opcion, cds, estado = 0;
        double a, b, c, L, gb, Mb;       
        String letra;
        String mes;
        

        do {
            System.out.println("Seleccione un Ejercicio:");
            System.out.println("1. (Calcular Distancia");
            System.out.println("2. (Calcular Promedio");
            System.out.println("3. (Puntaje Examen");
            System.out.println("4. (Puntaje Fútbol");
            System.out.println("5. (Pago Mensual");
            System.out.println("6. Área de un Triángulo");
            System.out.println("7. (calcular el Número de CDs )");
            System.out.println("8. (La Distancia)");
            System.out.println("9. (Sacra el CUIL)");
            System.out.println("10. (La Edad de 2 hermanos)");
            System.out.println("11. (Promedio de Produccion Lunes a Viernes)");
            System.out.println("12. (Leer 3 Numeros)");
            System.out.println("13. (Tipo de Triangulo)");
            System.out.println("14. (Numero Romanos)");
            System.out.println("15. (Monto y Bonificcion del Vendedor)");
            System.out.println("16. (Numero con Vocal)");
            System.out.println("17. (Numero de Unidades)");
            System.out.println("18. (Numero Entero e Indicar si es Par)");
            System.out.println("19. (Numero de 1 al 10)");
            System.out.println("20. (Sueldo Promedio)");
            System.out.println("21. (La Edad de 200 Personas)");
            System.out.println("22. (2 Numero de Sumas Sucesivas)");
            System.out.println("23. (10 Numero Entero Exepcto los Pares)");
            System.out.println("24. (Terminos Menores a 100)");
            System.out.println("25. (Letra hasta Vocal)");
            System.out.println("26. (Numero de Fibnacci Menores a 100000)");
            System.out.println("27. (2 Numeros y Operador Aritmetico)");
            System.out.println("28. (Letra, Vocal Y Consonates)");
            System.out.println("29. (Ganador por Mayoria)");
            System.out.println("30. (Solicitar 2 Numeros)");
            System.out.println("31. (Numero y Mes Correspondiente)");
            System.out.println("32. (Numero diferente a 0, Mostrando sus Divisores)");
    
            
            
            System.out.println("0. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Digite a: ");
                    A = scanner.nextInt();
                    System.out.println("Digite b: ");
                    B = scanner.nextInt();
                    System.out.println("Resultado: " + (A * B));
                    break;
                }

                case 2: {
                    System.out.println("Ingrese la primera nota: ");
                    A = scanner.nextInt();
                    System.out.println("Ingrese la segunda nota: ");
                    B = scanner.nextInt();
                    System.out.println("Ingrese la tercera nota: ");
                    C = scanner.nextInt();
                    System.out.println("El promedio final es: " + ((A + B + C) / 3.0));
                    break;
                }

                case 3: {
                    System.out.println("Número de respuestas correctas: ");
                    A = scanner.nextInt();
                    System.out.println("Número de respuestas incorrectas: ");
                    B = scanner.nextInt();
                    System.out.println("Número de respuestas en blanco: ");
                    C = scanner.nextInt();
                    System.out.println("Puntaje final: " + ((A * 4) - (B * 1))); // Corrigido: restar incorrectas
                    break;
                }

                case 4: {
                    System.out.print("Ingrese la cantidad de partidos ganados: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de partidos empatados: ");
                    B = scanner.nextInt();
                    System.out.print("Ingrese la cantidad de partidos perdidos: ");
                    C = scanner.nextInt();
                    System.out.println("El puntaje total es: " + ((A * 3) + (B * 1)));
                    break;
                }

                case 5: {
                    System.out.print("Ingrese las horas laboradas en el mes: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese la tarifa por hora: ");
                    B = scanner.nextInt();
                    System.out.println("El total a pagar es: " + (A * B));
                    break;
                }

                case 6: {
                    System.out.print("Ingrese lado uno: ");
                    a = scanner.nextDouble();
                    System.out.print("Ingrese lado dos: ");
                    b = scanner.nextDouble();
                    System.out.print("Ingrese lado tres: ");
                    c = scanner.nextDouble();
                    L = (a + b + c) / 2;
                     System.out.println("el area del triangulo es  " + Math.sqrt(L * (L - a) * (L - b) * (L - c))  );
                    
                    break;
                }
                case 7: {
                    System.out.print("Ingrese el tamaño del disco duro en GB: ");
                    gb = scanner.nextDouble();

                    System.out.println("Número de CDs necesarios: " + (int)Math.ceil((gb * 1024) / 700));
                    
                    break;
                }

                case 8:{     
                    System.out.print("Ingrese la abscisa del punto A: ");
                    a = scanner.nextDouble();
                    System.out.print("Ingrese la abscisa del punto B: ");
                    b = scanner.nextDouble();
                    System.out.print("Ingrese la ordenada del punto A: ");
                    c = scanner.nextDouble();
                    System.out.print("Ingrese la ordenada del punto B: ");
                    L = scanner.nextDouble();

                    System.out.println("La distancia entre los puntos A y B es: " +
                    Math.sqrt(Math.pow((b - a), 2) + Math.pow((L - c), 2)));

                    break;
                }

                case 9:{ 
                    System.out.print("Ingrese el año de nacimiento: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese el año actual: ");
                    B = scanner.nextInt();

                    C = B - A;

                    if (C > 17) {
                    System.out.println("Debe solicitar su CUIL");
                    } else {
                    System.out.println("No debe solicitar su CUIL por el momento");
                    }
                    break;
                }

                case 10:{ 
                    System.out.print("Ingrese la edad del primer hermano: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese la edad del segundo hermano: ");
                    B = scanner.nextInt();

                    if (A > B) {
                    C = A - B;
                    System.out.println("El primer hermano es el mayor por " + C + " años.");
                    } else if (B > A) {
                    C = B - A;
                    System.out.println("El segundo hermano es el mayor por " + C + " años.");
                    } else {
                    System.out.println("Ambos hermanos tienen la misma edad.");
                    }
                    break;
                }
                
                case 11:{ 
                    System.out.print("Producción del día Lunes: ");
                    A = scanner.nextInt();
                    System.out.print("Producción del día Martes: ");
                    B = scanner.nextInt();
                    System.out.print("Producción del día Miércoles: ");
                    C = scanner.nextInt();
                    System.out.print("Producción del día Jueves: ");
                    cds = scanner.nextInt(); 
                    System.out.print("Producción del día Viernes: ");
                    estado = scanner.nextInt(); 
                    System.out.print("Producción del día Sábado: ");
                    opcion = scanner.nextInt(); 

                    
                    A = A + B + C + cds + estado + opcion; 
                    L = A / 6.0; 

                    if (L >= 100) {
                    System.out.println("Recibirá Incentivos");
                    } else {
                    System.out.println("No Recibirá Incentivos");
                    }  

                    break;
                }

                case 12:{  
                    System.out.print("Ingrese el primer número entero: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese el segundo número entero: ");
                    B = scanner.nextInt();
                    System.out.print("Ingrese el tercer número entero: ");
                    C = scanner.nextInt();

                    if (A > B && A > C) {
                    cds = A;
                    } else if (B > C) {
                    cds = B;
                    } else {
                    cds = C;
                    }

                    System.out.println("El número mayor es: " + cds);

                    break;
                }

                case 13:{ 
                    System.out.print("Ingrese el primer lado del triángulo: ");
                    A = scanner.nextInt();
                    System.out.print("Ingrese el segundo lado del triángulo: ");
                    B = scanner.nextInt();
                    System.out.print("Ingrese el tercer lado del triángulo: ");
                    C = scanner.nextInt();

                    if (A != B && B != C && C != A) {
                    System.out.println("El triángulo es: Escaleno");
                    } else if (A == B && B == C) {
                    System.out.println("El triángulo es: Equilátero");
                    } else {
                    System.out.println("El triángulo es: Isósceles");
                    }
                    
                    break;
                }

                case 14:{     
                    System.out.print("Ingrese un número entero entre 1 y 10: ");
                    A = scanner.nextInt();

                    if (A == 1) {
                    System.out.println("Equivalente en romano: I");
                    } else if (A == 2) {
                    System.out.println("Equivalente en romano: II");
                    } else if (A == 3) {
                    System.out.println("Equivalente en romano: III");
                    } else if (A == 4) {
                    System.out.println("Equivalente en romano: IV");
                    } else if (A == 5) {
                    System.out.println("Equivalente en romano: V");
                    } else if (A == 6) {
                    System.out.println("Equivalente en romano: VI");
                    } else if (A == 7) {
                    System.out.println("Equivalente en romano: VII");
                    } else if (A == 8) {
                    System.out.println("Equivalente en romano: VIII");
                    } else if (A == 9) {
                    System.out.println("Equivalente en romano: IX");
                    } else if (A == 10) {
                    System.out.println("Equivalente en romano: X");
                    } else {
                    System.out.println("Número fuera de rango (debe ser entre 1 y 10)");
                    }

                    break;
                }

                case 15:{  
                    System.out.print("Ingrese el monto de venta mensual: ");
                    a = scanner.nextDouble();

                    if (a >= 0 && a < 1000) {
                    b = 0;
                    } else if (a >= 1000 && a < 5000) {
                    b = (3 * a) / 100;
                    } else if (a >= 5000 && a < 20000) {
                    b = (5 * a) / 100;
                    } else if (a >= 20000) {
                    b = (8 * a) / 100;
                    } else {
                    b = 0;
                    System.out.println("Monto inválido. Debe ser mayor o igual a 0.");
                    }

                    if (a >= 0) {
                    System.out.println("La bonificación correspondiente es: $" + b);
                    }

                    break;
                }

                case 16:{ 
                    System.out.print("Ingrese un número entero del 1 al 5: ");
                    A = scanner.nextInt();

                    if (A == 1) {
                    System.out.println("Vocal : A");
                    } else if (A == 2) {
                    System.out.println("Vocal : E");
                    } else if (A == 3) {
                    System.out.println("Vocal : I");
                    } else if (A == 4) {
                    System.out.println("Vocal : O");
                    } else if (A == 5) {
                    System.out.println("Vocal : U");
                    } else {
                    System.out.println("Vocal : Valor Incorrecto");
                    }

                    break;
                }

                case 17:{    
                    System.out.print("Ingrese un número entero de dos cifras (entre 10 y 99): ");
                    A = scanner.nextInt();

                    if (A >= 10 && A <= 99) {
                    B = A / 10;       
                    C = A % 10;       

                    System.out.println("Decenas: " + B);
                    System.out.println("Unidades: " + C);
                    } else {
                    System.out.println("Número inválido. Debe tener exactamente dos cifras.");
                    }
                    break;
                }

                case 18:{  
                    System.out.print("Ingrese un número entero distinto de cero: ");
                    A = scanner.nextInt();

                    if (A != 0) {
                    B = A / 2;
                    C = A - (B * 2);

                    if (C == 0) {
                    System.out.println("Es Par");
                    } else {
                    System.out.println("Es Impar");
                    }
                    } else {
                    System.out.println("El número no puede ser cero.");
                    }
                    break;
                }

                case 19:{ 
                    System.out.println("Números pares del 1 al 10:");

                    A = 2; 
                    System.out.println(A);

                    for (B = 1; B <= 4; B++) {
                    A = A + 2;
                    System.out.println(A);
                    }
                    break;
                }

                case 20:{ 
                    System.out.print("Ingrese el número de empleados: ");
                    D = scanner.nextInt();  

                    if (D <= 0) {
                    System.out.println("El número de empleados debe ser mayor que cero.");
                    } else {
                    b = 0; 

                    for (E = 1; E <= D; E++) {
                    System.out.print("Ingrese el sueldo del empleado " + E + ": ");
                    a = scanner.nextDouble(); 
                    b += a;  
                }

                    c = b / D;  

                    System.out.printf("El sueldo promedio es: %.2f%n", c);
                }
                    break;
                }

                case 21:{ 
                    A = 0;  
                    B = 0;  

                    for (C = 1; C <= 200; C++) {
                    System.out.print("Ingrese la edad de la persona " + C + ": ");
                    D = scanner.nextInt(); 

                    if (D < 18) {
                    B++;
                    } else {
                    A++;
                    }
                    }

                    System.out.println("Cantidad de personas mayores de edad: " + A);
                    System.out.println("Cantidad de personas menores de edad: " + B);

                    break;
                }

                case 22:{  
                        System.out.print("Ingrese el primer número: ");
                        A = scanner.nextInt();  

                        System.out.print("Ingrese el segundo número: ");
                        B = scanner.nextInt(); 

                        C = 0;  
                        for (D = 1; D <= B; D++) {
                        C += A;  
                        }

                        System.out.println("El producto por sumas sucesivas es: " + C);
                        break;
                }

                    case 23:{      
                    A = 1;  
                    B = 0;  

                    while (B < 10) {
                    C = A / 2;
                   D = A - (C * 2); 
                    if (D != 0) {
                    System.out.println(A);  
                    B++;  
                    }

                A++;  
    }
                    break;
                }

                    case 24:{        
                        A = 1;  

                        System.out.println("Términos de la serie menores a 1000:");

                        while (A < 1000) {
                        System.out.println(A);
                         A = (A * A) + 1;
                        }
            
                        break;
                
                }


                    case 25:{          
                        scanner.nextLine(); 
                        

                        while (true) {
                        System.out.print("Ingrese una letra: ");
                        letra = scanner.nextLine();

                        if (letra.equalsIgnoreCase("a") ||
                        letra.equalsIgnoreCase("e") ||
                        letra.equalsIgnoreCase("i") ||
                        letra.equalsIgnoreCase("o") ||
                        letra.equalsIgnoreCase("u")) {
                        break;
                        } else {
                        System.out.println("No es una vocal, intente nuevamente.");
                        }
                        }

            System.out.println("Ingresó una vocal. Fin del programa.");
            break; }


                case 26:{   
                    A = 0;
                    B = 1;
                    C = A + B;

                    System.out.println("Serie Fibonacci menor a 100000:");
                    System.out.println(A);
                    System.out.println(B);

                    while (C < 100000) {
                    System.out.println(C);
                    A = B;
                    B = C;
                    C = A + B;
                    }

                    break;
                    }
            

                    case 27:{
                        System.out.print("Ingrese el primer número: ");
                        A = scanner.nextInt();

                        System.out.print("Ingrese el segundo número: ");
                        B = scanner.nextInt();

                        System.out.print("Ingrese el operador (+, -, *, ^): ");
                        String OP = scanner.next(); 

   
                       estado = 1;


                        if (OP.equals("+")) {
                        R = A + B;
                        } else if (OP.equals("-")) {
                        R = A - B;
                        } else if (OP.equals("*")) {
                        R = A * B;
                        } else if (OP.equals("^")) {
                        R = (int) Math.pow(A, B); 
                        } else {
                        System.out.println("Operador no válido.");
                       estado = 0;
                        }

    
                        if (estado ==1){
                        System.out.println("Resultado: " + R);
                        }

                    
                    break;
                }


                    case 28:{
                        scanner.nextLine(); 
                        A = 0; 
                        B = 0; 

                        for (int K = 1; K <= 10; K++) {
                        System.out.print("Ingrese la letra número " + K + ": ");
                        letra = scanner.nextLine().toLowerCase();

                        if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                        System.out.println("Entrada inválida. Debe ingresar solo una letra.");
                        K--;
                        continue;
                        }

                        if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")) {
                        A++;
                        } else {
                        B++;
                        }
                        }

                        System.out.println("Cantidad de vocales ingresadas: " + A);
                        System.out.println("Cantidad de consonantes ingresadas: " + B);
                    
                        break;
                        }


                    case 29:{  
                        A = 0; 
                        B = 0; 
                        C = 0; 
                        D = 0; 

                        for (int K = 1; K <= 160; K++) {
                        System.out.print("Ingrese el voto #" + K + " (1, 2, 3 o cualquier otro para nulo/blanco): ");
                        E = scanner.nextInt();

                        if (E == 1) A++;
                        else if (E == 2) B++;
                        else if (E == 3) C++;
                        else D++;
                        }

                        System.out.println("\nRESULTADOS FINALES:");
                        System.out.println("Candidato 1: " + A + " votos");
                        System.out.println("Candidato 2: " + B + " votos");
                        System.out.println("Candidato 3: " + C + " votos");
                        System.out.println("Votos nulos/blancos: " + D);

                        if (A > B && A > C && A > D) {
                        System.out.println("Ganador: Candidato 1 con " + A + " votos.");
                        } else if (B > C && B > D) {
                        System.out.println("Ganador: Candidato 2 con " + B + " votos.");
                        } else if (C > D) {
                        System.out.println("Ganador: Candidato 3 con " + C + " votos.");
                        } else {
                        System.out.println("Los votos nulos/blancos ganaron con " + D + " votos.");
                        }
                    break;
                }


                    case 30:{
                    System.out.print("Ingrese el primer número: ");
                    a = scanner.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    b = scanner.nextDouble();

                    L = (a + b) / 2;
                    System.out.println("El promedio es: " + L);
                    
                    break;
                }


                    case 31:{ 
                    System.out.print("Ingrese un número del 1 al 12: ");
                    A = scanner.nextInt();

                    if (A == 1) mes = "Enero";
                    else if (A == 2) mes = "Febrero";
                    else if (A == 3) mes = "Marzo";
                    else if (A == 4) mes = "Abril";
                    else if (A == 5) mes = "Mayo";
                    else if (A == 6) mes = "Junio";
                    else if (A == 7) mes = "Julio";
                    else if (A == 8) mes = "Agosto";
                    else if (A == 9) mes = "Septiembre";
                    else if (A == 10) mes = "Octubre";
                    else if (A == 11) mes = "Noviembre";
                    else if (A == 12) mes = "Diciembre";
                    else mes = "Error";

                    System.out.println("Mes correspondiente: " + mes);
            
                    break;
                }

                    case 32:{
                    System.out.print("Ingrese un número entero distinto de cero: ");
                    A = scanner.nextInt();

                    if (A != 0) {
                    System.out.println("Los divisores de " + A + " son:");

                    for (B = 1; B <= Math.abs(A); B++) {
                    C = A / B;
                    D = C * B;
                    R = A - D;

                    if (R == 0) {
                    System.out.println(B);
                    }
                    }
                    } else {
                    System.out.println("El número no puede ser cero.");
    }   
                    break;
                }


                

                case 0: {
                    System.out.println("¡Hasta pronto, See you soon!");
                    estado = 1;
                    break;
                }

                default: {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
                }
            }

        } while (estado == 0);

        scanner.close();
    }
}
