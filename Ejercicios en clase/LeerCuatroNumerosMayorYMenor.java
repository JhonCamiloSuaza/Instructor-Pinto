import java.util.Scanner;

    public class LeerCuatroNumerosMayorYMenor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=0, num2=0, num3=0, num4=0, mayor=0, menor=0;

        System.out.println("Ingresa 4 numeros separados por espacios:");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        num4 = sc.nextInt();

        mayor = Math.max(Math.max(num1, num2), Math.max(num3, num4));
        menor = Math.min(Math.min(num1, num2), Math.min(num3, num4));

        System.out.println("Mayor: " + mayor + " Menor: " + menor);

        sc.close();
    }
}
