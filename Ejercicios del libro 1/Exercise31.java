import java.util.Scanner;

public class Exercise31 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese un número del 1 al 12: ");
        int N = teclado.nextInt();

        String mes;

        if (N == 1) {
            mes = "Enero";
        } else if (N == 2) {
            mes = "Febrero";
        } else if (N == 3) {
            mes = "Marzo";
        } else if (N == 4) {
            mes = "Abril";
        } else if (N == 5) {
            mes = "Mayo";
        } else if (N == 6) {
            mes = "Junio";
        } else if (N == 7) {
            mes = "Julio";
        } else if (N == 8) {
            mes = "Agosto";
        } else if (N == 9) {
            mes = "Septiembre";
        } else if (N == 10) {
            mes = "Octubre";
        } else if (N == 11) {
            mes = "Noviembre";
        } else if (N == 12) {
            mes = "Diciembre";
        } else {
            mes = "Error";
        }

        System.out.println("Mes correspondiente: " + mes);
        teclado.close();
    }
}