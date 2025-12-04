import java.util.Scanner;

public class RegistroDeClientes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== REGISTRO DE CLIENTES =====");

        System.out.print("Ingrese el número total de clientes (N): ");
        int N = scanner.nextInt();

        String[] nombres = new String[N];
        int[] edades = new int[N];
        String[] ciudades = new String[N];

        int sumaEdades = 0;

        int edadMinima = Integer.MAX_VALUE;
        String clienteMasJoven = "";
        int edadMaxima = -1;
        String clienteMayorEdad = "";

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.print("\nCliente " + (i + 1) + " - Nombre: ");
            nombres[i] = scanner.nextLine();

            System.out.print("Cliente " + (i + 1) + " - Edad: ");
            edades[i] = scanner.nextInt();
            sumaEdades += edades[i];

            scanner.nextLine();

            System.out.print("Cliente " + (i + 1) + " - Ciudad: ");
            ciudades[i] = scanner.nextLine();

            if (edades[i] < edadMinima) {
                edadMinima = edades[i];
                clienteMasJoven = nombres[i];
            }

            if (edades[i] > edadMaxima) {
                edadMaxima = edades[i];
                clienteMayorEdad = nombres[i];
            }
        }

        double promedioEdades = (N > 0) ? (double) sumaEdades / N : 0;

        System.out.print("\nIngrese la ciudad para filtrar el listado: ");
        String ciudadFiltro = scanner.nextLine();

        System.out.println("\n--- INFORME DE CLIENTES ---");
        System.out.printf("Promedio de edades de los clientes: %.2f años\n", promedioEdades);
        System.out.println("Cliente más joven: " + clienteMasJoven + " (" + edadMinima + " años)");
        System.out.println("Cliente de mayor edad: " + clienteMayorEdad + " (" + edadMaxima + " años)");

        System.out.println("\n--- LISTADO DE CLIENTES EN " + ciudadFiltro.toUpperCase() + " ---");
        boolean hayClientesEnCiudad = false;

        for (int i = 0; i < N; i++) {
            if (ciudades[i].equalsIgnoreCase(ciudadFiltro)) {
                System.out.println("- " + nombres[i] + " (" + edades[i] + " años)");
                hayClientesEnCiudad = true;
            }
        }

        if (!hayClientesEnCiudad) {
            System.out.println("No se encontraron clientes que vivan en " + ciudadFiltro + ".");
        }

        scanner.close();
    }
}