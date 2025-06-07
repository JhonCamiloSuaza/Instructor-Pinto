import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistroUsuario.registrarUsuarios();

        while (true) {
            System.out.println("\n¿Qué desea hacer...?");
            System.out.println("1. Ver datos de un usuario por índice");
            System.out.println("2. Ver un campo de todos los usuarios");
            System.out.println("3. Ver un campo específico de un usuario");
            System.out.println("0. Salir");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese índice del usuario (1-10): ");
                    int index = Integer.parseInt(sc.nextLine()) - 1;
                    RegistroUsuario.mostrarUsuario(index);
                    break;

               case "2":
                    RegistroUsuario.mostrarCamposDisponibles();
                    System.out.print("Ingrese el campo a consultar: ");
                    String campoTodos = sc.nextLine();
                    RegistroUsuario.mostrarCampoDeTodos(campoTodos);
                    break;


                case "3":
                    RegistroUsuario.mostrarCamposDisponibles();
                    System.out.print("Ingrese el campo a consultar: ");
                    String campoUsuario = sc.nextLine();
                    System.out.print("Ingrese el índice del usuario (1-10): ");
                    int userIndex = Integer.parseInt(sc.nextLine()) - 1;
                    RegistroUsuario.mostrarCampoDeUsuario(campoUsuario, userIndex);
                    break;

                case "0":
                
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Error, Opción inválida.");

                    sc.close();
            }
        }
    }
}
