public class leerDato {

    public static todos Todos = new todos();


    public static void Scanneruno(){
        System.out.println("Ingrese el valor:");
        todos.numero1=todos.teclado.nextInt();   
    }
    public static void ScannerDos(){
        System.out.println("Ingrese el primer valor:");
        todos.numero1=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero2=todos.teclado.nextInt();
    }
    public static void ScannerTres(){
        System.out.println("Ingrese el primer valor:");
        todos.numero1=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero2=todos.teclado.nextInt();
        System.out.println("Ingrese el tercer valor:");
        todos.numero3=todos.teclado.nextInt();
    }
    public static void ScannerCinco(){
        System.out.println("Ingrese el primer valor:");
        todos.numero1=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero2=todos.teclado.nextInt();
        System.out.println("Ingrese el tercer valor:");
        todos.numero3=todos.teclado.nextInt();
        System.out.println("Ingrese el cuarto valor:");
        todos.numero4=todos.teclado.nextInt();
        System.out.println("Ingrese el quinto valor:");
        todos.numero5=todos.teclado.nextInt();
    }
    public static void ScannerSeis(){
        System.out.println("Ingrese el primer valor:");
        todos.numero1=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero2=todos.teclado.nextInt();
        System.out.println("Ingrese el tercer valor:");
        todos.numero3=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero4=todos.teclado.nextInt();
        System.out.println("Ingrese el cuarto valor:");
        todos.numero5=todos.teclado.nextInt();
        System.out.println("Ingrese el quinto valor:");
        todos.numero5=todos.teclado.nextInt();
    }
   
    public static void ScannerunoD(){
        System.out.println("Ingrese el valor:");
        todos.numero1D=todos.teclado.nextDouble();   
    }
    public static void ScannerTresD(){
        System.out.println("Ingrese el valor:");
        todos.numero1D=todos.teclado.nextDouble(); 
        System.out.println("Ingrese el valor:");
        todos.numero2D=todos.teclado.nextDouble(); 
        System.out.println("Ingrese el valor:");
        todos.numero3D=todos.teclado.nextDouble();   
    }
    public static void ScannerCuatroD(){
        System.out.println("Ingrese el primer valor:");
        todos.numero1D=todos.teclado.nextInt();
        System.out.println("Ingrese el segundo valor:");
        todos.numero2D=todos.teclado.nextInt();
        System.out.println("Ingrese el tercer valor:");
        todos.numero3D=todos.teclado.nextInt();
        System.out.println("Ingrese el cuarto valor:");
        todos.numero4D=todos.teclado.nextInt();
    }
 
    public static void ScannerChar(){ 
        System.out.print("Ingrese una letra: ");
        todos.letra = todos.teclado.next().charAt(0);
    }
}
