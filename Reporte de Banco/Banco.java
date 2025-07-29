import java.util.Random;
import java.util.Scanner;

public class Banco {
    static Scanner Teclado = new Scanner(System.in);
    static Random random = new Random();

    static int sucursales = 0;
    static int[] clientesSucursal = new int[5];
    static String[][] productosSucursal = new String[5][3];
    static String[] ciudadesSucursal = new String[5];
    static String nombreBanco = "";

    public static void registrarBanco() {
        System.out.print("Ingrese el nombre del banco: ");
        nombreBanco = Teclado.nextLine();
        if (nombreBanco.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre del banco vacío");
        }
        System.out.println("Banco se registró correctamente.");
    }

    public static void registrarSucursales() {
        System.out.print("Ingrese el número de sucursales (Máximo 5): ");
        sucursales = Teclado.nextInt();
        Teclado.nextLine();

        if (sucursales < 1 || sucursales > 5) {
            throw new IllegalArgumentException("Cantidad de sucursales no válida");
        }

        String[] productosBanco = {
            "Cuenta de ahorros", "Cuenta corriente", "Tarjeta de crédito", "Tarjeta débito", "Seguro de vida",
            "Crédito hipotecario", "Crédito de libre inversión", "CDT", "Crédito educativo", "Seguro para vehículo"
        };

        for (int i = 0; i < sucursales; i++) {
            System.out.print("Ingrese la ciudad de la sucursal " + (i + 1) + ": ");
            String ciudad = Teclado.nextLine();
            if (ciudad.trim().isEmpty()) {
                throw new IllegalArgumentException("Ciudad vacía para sucursal");
            }
            ciudadesSucursal[i] = ciudad;

            int cliente = random.nextInt(15) + 1;
            clientesSucursal[i] = cliente;

            int cantidadProductos = random.nextInt(3) + 1;
            for (int j = 0; j < cantidadProductos; j++) {
                productosSucursal[i][j] = productosBanco[random.nextInt(productosBanco.length)];
            }

            // Mostrar lo registrado
            System.out.print("Sucursal " + (i + 1) + " - Ciudad: " + ciudad + " - Clientes: " + cliente + " - Productos: ");
            for (int j = 0; j < productosSucursal[i].length; j++) {
                if (productosSucursal[i][j] != null) {
                    System.out.print(productosSucursal[i][j]);
                    if (j < productosSucursal[i].length - 1 && productosSucursal[i][j + 1] != null) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void listarProductos() {
        String[] productosBanco = {
            "Cuenta de ahorros", "Cuenta corriente", "Tarjeta de crédito", "Tarjeta débito", "Seguro de vida",
            "Crédito hipotecario", "Crédito de libre inversión", "CDT", "Crédito educativo", "Seguro para vehículo"
        };

        System.out.println("Lista de productos disponibles:");
        for (int i = 0; i < productosBanco.length; i++) {
            System.out.println((i + 1) + ". " + productosBanco[i]);
        }
    }

    public static void Reporte(Scanner Teclado) {
        if (sucursales == 0) {
            System.out.println("No hay sucursales registradas.");
            return;
        }

        System.out.println("¿Qué desea ver?");
        System.out.println("1. Solo nombres de sucursales");
        System.out.println("2. Solo clientes por sucursal");
        System.out.println("3. Solo productos por sucursal");
        System.out.println("4. Todo el reporte general");
        System.out.print("Seleccione una opción: ");
        String opcion = Teclado.nextLine();

        switch (opcion) {
            case "1":
                for (int i = 0; i < sucursales; i++) {
                    System.out.println("Sucursal " + (i + 1) + " - Ciudad: " + ciudadesSucursal[i]);
                }
                break;
            case "2":
                for (int i = 0; i < sucursales; i++) {
                    System.out.println("Sucursal " + (i + 1) + " - Ciudad: " + ciudadesSucursal[i] + " - Clientes: " + clientesSucursal[i]);
                }
                break;
            case "3":
                for (int i = 0; i < sucursales; i++) {
                    System.out.print("Sucursal " + (i + 1) + " - Ciudad: " + ciudadesSucursal[i] + " - Productos: ");
                    for (int j = 0; j < productosSucursal[i].length; j++) {
                        if (productosSucursal[i][j] != null) {
                            System.out.print(productosSucursal[i][j]);
                            if (j < productosSucursal[i].length - 1 && productosSucursal[i][j + 1] != null) {
                                System.out.print(", ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;
            case "4":
                System.out.println("Nombre del banco: " + nombreBanco);
                System.out.println("Total de sucursales: " + sucursales);
                for (int i = 0; i < sucursales; i++) {
                    System.out.print("Sucursal " + (i + 1) + " - Ciudad: " + ciudadesSucursal[i] + " - Clientes: " + clientesSucursal[i] + " - Productos: ");
                    for (int j = 0; j < productosSucursal[i].length; j++) {
                        if (productosSucursal[i][j] != null) {
                            System.out.print(productosSucursal[i][j]);
                            if (j < productosSucursal[i].length - 1 && productosSucursal[i][j + 1] != null) {
                                System.out.print(", ");
                            }
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public static void seleccionSucursal() {
        String[] campañaBanco = {
            "Apertura de cuenta de ahorros con bono de bienvenida",
            "Cuenta corriente sin cuota de manejo por 6 meses",
            "Tarjeta de crédito con 0% interés por 3 meses",
            "Tarjeta débito con cashback del 5% en supermercados",
            "Seguro de vida con cobertura ampliada sin costo adicional",
            "Crédito hipotecario con tasa fija del 11%",
            "Crédito de libre inversión aprobado en 24 horas",
            "CDT con tasa preferencial del 12%",
            "Crédito educativo sin interés durante el primer año",
            "Seguro para vehículo con descuento del 15% en SOAT"
        };

        for (int i = 0; i < sucursales; i++) {
            System.out.println("Sucursal " + (i + 1) + " - Ciudad: " + ciudadesSucursal[i]);
            for (int j = 0; j < productosSucursal[i].length; j++) {
                if (productosSucursal[i][j] != null) {
                    int camp = random.nextInt(campañaBanco.length);
                    System.out.println("- Producto: " + productosSucursal[i][j] + " | Campaña: " + campañaBanco[camp]);
                }
            }
            System.out.println();
        }
    }

    public static void verProductosPorSucursal() {
        if (sucursales == 0) {
            System.out.println("No hay sucursales registradas.");
            return;
        }

        System.out.print("Ingrese el número de la sucursal (1 a " + sucursales + "): ");
        int numSucursal = Teclado.nextInt();
            Teclado.nextLine();

        if (numSucursal < 1 || numSucursal > sucursales) {
            throw new IllegalArgumentException("Número de sucursal fuera de rango.");
        }

        System.out.println("Sucursal " + numSucursal + " - Ciudad: " + ciudadesSucursal[numSucursal - 1] + " - Productos:");
        for (int j = 0; j < productosSucursal[numSucursal - 1].length; j++) {
            if (productosSucursal[numSucursal - 1][j] != null) {
                System.out.println("- " + productosSucursal[numSucursal - 1][j]);
            }
        }
    }

    public static void mostrarEstadisticas() {
        if (sucursales == 0) {
            System.out.println("No hay datos para mostrar estadísticas.");
            return;
        }

        System.out.println("Cantidad de sucursales por ciudad:");
        for (int i = 0; i < sucursales; i++) {
            String ciudadActual = ciudadesSucursal[i];
            boolean yaContada = false;

            for (int j = 0; j < i; j++) {
                if (ciudadesSucursal[j].equalsIgnoreCase(ciudadActual)) {
                    yaContada = true;
                    break;
                }
            }

            if (!yaContada) {
                int contador = 0;
                for (int j = 0; j < sucursales; j++) {
                    if (ciudadesSucursal[j].equalsIgnoreCase(ciudadActual)) {
                        contador++;
                    }
                }
                System.out.println("- " + ciudadActual + ": " + contador + " sucursal(es)");
            }
        }

        String[] todosProductos = {
            "Cuenta de ahorros", "Cuenta corriente", "Tarjeta de crédito", "Tarjeta débito", "Seguro de vida",
            "Crédito hipotecario", "Crédito de libre inversión", "CDT", "Crédito educativo", "Seguro para vehículo"
        };

        System.out.println("\nCantidad de veces que aparece cada producto en total y por sucursal:");
        for (String producto : todosProductos) {
            int total = 0;
            String detalle = "";

            for (int i = 0; i < sucursales; i++) {
                int porSucursal = 0;
                for (int j = 0; j < productosSucursal[i].length; j++) {
                    if (producto.equalsIgnoreCase(productosSucursal[i][j])) {
                        total++;
                        porSucursal++;
                    }
                }
                if (porSucursal > 0) {
                    detalle += " | Sucursal " + (i + 1) + " (" + ciudadesSucursal[i] + "): " + porSucursal;
                }
            }

            System.out.println("- " + producto + ": " + total + " vez/veces" + detalle);
        }

        System.out.println();
    }
}
