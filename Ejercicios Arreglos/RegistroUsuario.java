import java.util.ArrayList;
import java.util.Scanner;

public class RegistroUsuario {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void registrarUsuarios() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("---- Registro de usuario " + (i + 1) + " ----");
            System.out.print("Primer nombre: ");
            String pn = sc.nextLine();

            System.out.print("Segundo nombre: ");
            String sn = sc.nextLine();

            System.out.print("Primer apellido: ");
            String pa = sc.nextLine();

            System.out.print("Segundo apellido: ");
            String sa = sc.nextLine();

            System.out.print("Teléfono: ");
            int tel = Integer.parseInt(sc.nextLine());

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("RH: ");
            String rh = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            System.out.print("Ocupación: ");
            String ocupacion = sc.nextLine();

            usuarios.add(new Usuario(pn, sn, pa, sa, tel, edad, rh, correo, ocupacion));
        }
    }

    public static void mostrarUsuario(int index) {
        if (index >= 0 && index < usuarios.size()) {
            Usuario u = usuarios.get(index);
            System.out.println("Usuario " + (index + 1) + ": " + u);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void mostrarCampoDeTodos(String campo) {
        String campoNormalizado = campo.toLowerCase().replace(" ", "");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            switch (campoNormalizado) {
                case "nombre":
                case "primernombre":
                    System.out.println("Usuario " + (i + 1) + ": " + u.primerNombre);
                    break;
                case "segundonombre":
                    System.out.println("Usuario " + (i + 1) + ": " + u.segundoNombre);
                    break;
                case "primerapellido":
                    System.out.println("Usuario " + (i + 1) + ": " + u.primerApellido);
                    break;
                case "segundoapellido":
                    System.out.println("Usuario " + (i + 1) + ": " + u.segundoApellido);
                    break;
                case "telefono":
                    System.out.println("Usuario " + (i + 1) + ": " + u.telefono);
                    break;
                case "edad":
                    System.out.println("Usuario " + (i + 1) + ": " + u.edad);
                    break;
                case "rh":
                    System.out.println("Usuario " + (i + 1) + ": " + u.rh);
                    break;
                case "correo":
                    System.out.println("Usuario " + (i + 1) + ": " + u.correo);
                    break;
                case "ocupacion":
                    System.out.println("Usuario " + (i + 1) + ": " + u.ocupacion);
                    break;
                default:
                    System.out.println("Campo no reconocido.");
                    return;
            }
        }
    }

    public static void mostrarCampoDeUsuario(String campo, int index) {
        if (index >= 0 && index < usuarios.size()) {
            Usuario u = usuarios.get(index);
            String campoNormalizado = campo.toLowerCase().replace(" ", "");
            switch (campoNormalizado) {
                case "nombre":
                case "primernombre":
                    System.out.println("Primer nombre: " + u.primerNombre);
                    break;
                case "segundonombre":
                    System.out.println("Segundo nombre: " + u.segundoNombre);
                    break;
                case "primerapellido":
                    System.out.println("Primer apellido: " + u.primerApellido);
                    break;
                case "segundoapellido":
                    System.out.println("Segundo apellido: " + u.segundoApellido);
                    break;
                case "telefono":
                    System.out.println("Teléfono: " + u.telefono);
                    break;
                case "edad":
                    System.out.println("Edad: " + u.edad);
                    break;
                case "rh":
                    System.out.println("RH: " + u.rh);
                    break;
                case "correo":
                    System.out.println("Correo: " + u.correo);
                    break;
                case "ocupacion":
                    System.out.println("Ocupación: " + u.ocupacion);
                    break;
                default:
                    System.out.println("El campo no se reconocio.");
            }
        } else {
            System.out.println("Usuario no se encontro.");
        }
    }

    public static void mostrarCamposDisponibles() {
        System.out.println("Menu disponible:");
        System.out.println("- Ingrese el Primer nombre");
        System.out.println("- Ingrese el Segundo nombre");
        System.out.println("- Ingrese el Primer apellido");
        System.out.println("- Ingrese el Segundo apellido");
        System.out.println("- Ingrese el Teléfono");
        System.out.println("- Ingrese la Edad");
        System.out.println("- Ingrese el RH");
        System.out.println("- Ingrese el Correo");
        System.out.println("- Ingrese la Ocupación");

        
        
    }
}
