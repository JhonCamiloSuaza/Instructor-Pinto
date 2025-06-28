import java.util.ArrayList;

public class CentroDespacho {
    public static Clinica[] clinicas = {
        new Clinica("Clínica 1", 55),
        new Clinica("Clínica 2", 35),
        new Clinica("Clínica 3", 45)
    };

    public static ArrayList<String> pacientesNoTransportados = new ArrayList<>();

    public static void ejecutarDespachos(Conductor[] conductores, Paciente[][] pacientes, Ambulancia[] ambulancias) {
        if (conductores.length != ambulancias.length || conductores.length != 10) {
            System.out.println("Error: Se esperaban exactamente 10 conductores y 10 ambulancias.");
            return;
        }

        //  pacientes vivos por clínica
        ArrayList<String>[] clinicaPacientes = new ArrayList[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        ArrayList<String> muertos = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Paciente p = pacientes[i][j];
                String data = p.nombre + "," + i + "," + j;
                if (p.estaMuerto) {
                    muertos.add(data);
                } else {
                    if (count < 33) clinicaPacientes[0].add(data);
                    else if (count < 66) clinicaPacientes[1].add(data);
                    else clinicaPacientes[2].add(data);
                    count++;
                }
            }
        }

        for (int i = 0; i < conductores.length; i++) {
            Conductor c = conductores[i];
            Ambulancia a = ambulancias[i];
            int viajes = 0;
            int kmRestantes = 400;
            System.out.println("\n  - Despacho Conductor " + (i + 1) + ": " + c.nombre + " " + c.apellido + " ----------");

            while (viajes < 8) {
                boolean recogio = false;
                // muertos
                if (!muertos.isEmpty() && kmRestantes >= 15) {
                    String[] datos = muertos.remove(0).split(",");
                    int fi = Integer.parseInt(datos[1]);
                    int co = Integer.parseInt(datos[2]);
                    Paciente p = pacientes[fi][co];

                    kmRestantes -= 15;
                    System.out.println("Viaje " + (viajes + 1) + ": Recogió MUERTO: " + p.nombre + " - Funeraria (15 km)");
                    viajes++;
                    recogio = true;
                } 
                // vivos por clínica
                else {
                    boolean encontrado = false;
                    for (int j = 0; j < clinicas.length; j++) {
                        if (!clinicaPacientes[j].isEmpty() && kmRestantes >= clinicas[j].distanciaKm) {
                            String[] datos = clinicaPacientes[j].remove(0).split(",");
                            int fi = Integer.parseInt(datos[1]);
                            int co = Integer.parseInt(datos[2]);
                            Paciente p = pacientes[fi][co];

                            kmRestantes -= clinicas[j].distanciaKm;
                            System.out.println("Viaje " + (viajes + 1) + ": Recogió VIVO: " + p.nombre + " - " + clinicas[j].nombre + " (" + clinicas[j].distanciaKm + " km)");
                            viajes++;
                            recogio = true;
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) break; // No hay más pacientes que se pueda recoger
                }

                if (!recogio) break; // No recogió nadie.
            }

            int kmUsados = 400 - kmRestantes;
            System.out.println("Total km usados por " + c.nombre + ": " + kmUsados + " km");
            System.out.println("Km sobrantes: " + kmRestantes + " km\n");
        }

        // Guardar los que no fueron recogidos
        for (String m : muertos) {
            String[] datos = m.split(",");
            int fi = Integer.parseInt(datos[1]);
            int co = Integer.parseInt(datos[2]);
            Paciente p = pacientes[fi][co];
            pacientesNoTransportados.add("NO RECOGIDO: " + p.nombre + " - FALLECIDO - Requiere 15 km - Destino: Funeraria");
        }

        for (int j = 0; j < clinicas.length; j++) {
            for (String s : clinicaPacientes[j]) {
                String[] datos = s.split(",");
                int fi = Integer.parseInt(datos[1]);
                int co = Integer.parseInt(datos[2]);
                Paciente p = pacientes[fi][co];
                pacientesNoTransportados.add("NO RECOGIDO: " + p.nombre + " - VIVO - Requiere " + clinicas[j].distanciaKm + " km - Destino: " + clinicas[j].nombre);
            }
        }

        // Mostrar los que no se recogieron
        System.out.println("\n- PACIENTES NO RECOGIDOS -");
        if (pacientesNoTransportados.isEmpty()) {
            System.out.println("Todos los pacientes fueron recogidos correctamente.");
        } else {
            for (String r : pacientesNoTransportados) {
                System.out.println(r);
            }
        }
    }
}
