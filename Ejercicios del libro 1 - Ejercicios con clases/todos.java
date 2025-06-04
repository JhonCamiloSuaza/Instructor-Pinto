
import java.util.Scanner;
public class todos {
    public static   todos Todos = new todos();
    public static   Scanner teclado = new Scanner(System.in);  
    public static   int opcion,numero1,numero2,numero3,numero4,contador,numero5,numero6,estado=0,calcularInt,calcularInt2,calcularInt3;
    public static   double CalcularDouble,CalcularDouble2,numero1D,numero2D,numero3D,numero4D;
    public static   char letra,SEMAF;

    public static void main(String[] args) {        
    do {
            System.out.println("Seleccione un Ejercicio:");
            System.out.println("1. (Calcular Distancia)");
            System.out.println("2. (Calcular Promedio)");
            System.out.println("3. (Puntaje Examen)");
            System.out.println("4. (Puntaje Fútbol)");
            System.out.println("5. (Pago Mensual)");
            System.out.println("6. Área de un Triángulo)");
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
            System.out.println("Seleccione 0 para salir del programa ...");
            System.out.print("Ingrese su opcion: ");
            teclado = new Scanner(System.in);

            opcion=teclado.nextInt();
        
            switch (opcion) { 
                case 1:{
                    System.out.println("1.Calcular la distancia recorrida ");
                    leerDato.ScannerDos();
                    exercise1.distancia();
                    break;
                }
                case 2:{
                    System.out.println("2.Calcular el promedio de tres notas");
                    leerDato.ScannerTres();
                    exercise2.promedio();
                    break;
                }
                case 3:{
                    System.out.println("3.Calcular respustas correctas, inconrrectas y en blanco:");
                    leerDato.ScannerTres();
                    exercise3.respuestas();
                    break;        
                }
                case 4:{
                    System.out.println("4.hacer el calculo de puntos en torneo ");
                    System.out.println("Ingresar primero los partidos ganaos, luego los empatados y por ultimo los perdidos ");
                    leerDato.ScannerTres();
                    exercise4.partidos();

                    break;
                }
                case 5:{
                    System.out.println("5.Calcular la planilla de un trabajador: ");
                    leerDato.ScannerDos();
                    exercise5.Planilla();
                    break;
                }
                case 6:{
                    System.out.println("6.Hacer el calculo de los 3 lados de un triangulo: ");
                    leerDato.ScannerTresD();
                    exercise6.areaTriangulo();
                    break;
                }
                case 7:{
                    System.out.println("7.Calcular el numeros de CDs necesesarios para hacer una copia de seguridad : ");
                    leerDato.ScannerunoD();
                    exercise7.cds();
                    break;
                }
                case 8:{
                    System.out.println("8.Obtener la distancia entre el punto A y B  ");
                    leerDato.ScannerCuatroD();
                    exercise8.puntos();
                    break;
                }
                case 9:{

                    System.out.println("9.Saber si una persona debe sacar su CUIL  ");
                    System.out.println("Primero tienes que ingresar la fecha actual y luego la fecha de nacimiento  ");
                    leerDato.ScannerDos();
                    exercise9.Cuil();
                    break;
                }
                case 10:{
                    System.out.println("10.Calcular la edad de dos hermanos y decir la diferencia de edad y quien de los dos es mayor  ");
                    leerDato.ScannerDos();
                    exercise10.Edad_mayor();
                    break;
                }
                case 11:{
                    System.out.println("11.Calculo de la produccion promedio de una empresa  ");
                    leerDato.ScannerSeis();
                    exercise11.promedio();
                    break;
                }
                case 12:{
                    System.out.println("12.Leer tres numeros enteros diferentes y determinar el numero mayor ");
                    leerDato.ScannerTres();
                    exercise12.numeroMayor();
                    break;
                }
                case 13:{
                    System.out.println("13.Reconocer el tipo de triangulo por sus lados ");
                    leerDato.ScannerTres();
                    exercise13.triangulo();
                    break;
                }
                case 14:{
                    System.out.println("14.Ingresar los numeros del 1 al 10 y mostrar su equivalente en numeros romanos ");
                    leerDato.Scanneruno();
                    exercise14.romanos();
                    break;
                }
                case 15:{
                    System.out.println("15.calcular si las ventas realizadas durante un mes por un vendedor merecer tener bonificacion");
                    leerDato.Scanneruno();
                    exercise15.ventas();
        
                    break;
                }
                case 16:{
                    System.out.println("14.Ingresar los numeros del 1 al 5  y mostrar su vocal equivalente  ");
                    leerDato.Scanneruno();
                    exercise16.mensaje();
                    break;
                }
                case 17:{
                    System.out.println("17.Se desea leer un numero entero de dos cifras y que muestre el numero de decenas y centenas que lo componen");
                    leerDato.Scanneruno();
                    exercise17.decenas();
                    break;

                }
                case 18:{
                    System.out.println("18.Se desea leer un numero entero si es diferente a cero es par ");
                    leerDato.Scanneruno();
                    exercise18.entero();
                    break;
                }
                case 19:{
                    System.out.println("19.contener los primeros diez numeros pares");
                    exercise19.diezPares();
                    break;
                }
                case 20:{
                    System.out.println("20.calcular el sueldo promedio de un grupo de personas");
                    leerDato.ScannerDos();
                    exercise20.sueldo();
                    break;
                }
                case 21:{
                    System.out.println("21.solicitar la edad de 200 personas y mostrar cuantos mayores y menores de edad hay");
                    exercise21.docientos();
                    break;
                }
                case 22:{
                    System.out.println("22.Realizar sumas sucesivas con dos numeros enteros y mostrar su producto");
                    leerDato.ScannerDos();
                    exercise22.suma();
                    break;
                }
                case 23:{
                    System.out.println("23Mostrar los 10 primeros numero enteros execto los pares");
                    leerDato.Scanneruno();
                    exercise23.menores();
                    break;
                }
                case 24:{
                    System.out.println("24.Mostrar los terminos de la serie que sean menores a 1000");
                    exercise24.sarie();
                    break;
                }
                case 25:{
                    System.out.println("25.Solicitar ingresar letras hasta que entre una vocal");
                    leerDato.ScannerChar();
                    exercise25.vocal();
                    break;

                }
                case 26:{
                    System.out.println("26.Terminos de la serie fibonacci menores a 100000");
                    exercise26.fibonacci(); numero1=0;
                    break;
                }
                case 27:{
                    System.out.println("27.Solicitar dos numeros enteros y un operador arimetrico y mostrar el resultado de la operacion");
                    leerDato.ScannerDos();
                    leerDato.ScannerChar();
                    exercise27.operador();
                    break;
                }
                case 28:
                {
                    System.out.println("28.Solicitar 10 letras cualquieras e indicar cuantas vocales y consonantes se ingresaron");
                    leerDato.ScannerChar();  
                    exercise28.consonantes();    
                
                    break;
                
                } 
                case 29:{
                    System.out.println("29.Resultado de unas elecciones");
                    leerDato.ScannerTres();
                    exercise29.votos();
                    break;
                }
                case 30:{
                    System.out.println("30.Solicitar dos numeros e imprimir su promedio ");
                    leerDato.ScannerDos();
                    exercise30.Promedio_two();
                    break;
                }
                case 0:{
                    System.out.println("0.Saliendo del programa... :");
                    estado=1;
                }
            }

        }while(estado==0);

        teclado.close();
    }

}
