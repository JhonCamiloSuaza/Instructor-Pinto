import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
        String opcion;
        boolean salir = false;

        do {
            try {
                System.out.println("MENÚ DEL BANCO ");
                System.out.println("1. Registrar el banco");
                System.out.println("2. Registrar sucursales");
                System.out.println("3. Listar los productos");
                System.out.println("4. Reporte de sucursales, clientes y productos");
                System.out.println("5. Mostrar campañas por sucursal");
                System.out.println("6. Ver productos por sucursal");
                System.out.println("7. Ver estadísticas del banco");
                System.out.println("8. Salir");
                System.out.print("Opción: ");
                opcion = Teclado.nextLine();

                switch (opcion) {
                    case "1":
                        Banco.registrarBanco();
                        break;
                    case "2":
                        Banco.registrarSucursales();
                        break;
                    case "3":
                        Banco.listarProductos();
                        break;
                    case "4":
                        Banco.Reporte(Teclado);
                        break;
                    case "5":
                        Banco.seleccionSucursal();
                        break;
                    case "6":
                        Banco.verProductosPorSucursal();
                        break;
                    case "7":
                        Banco.mostrarEstadisticas();
                        break;
                    case "8":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error en el sistema. Reiniciando...\n");
            
            }

        } while (!salir);

        Teclado.close();
        System.out.println("Gracias por usar el sistema del Banco. ¡Hasta luego!...");
    }
}
