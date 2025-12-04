import java.util.Scanner;
public class ControlDeInventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== CONTROL DE INVENTARIO =====");

        System.out.print("Ingrese el número de productos a registrar: ");
        int P = scanner.nextInt();

        String[] nombresProductos = new String[P];
        int[] cantidades = new int[P];
        long totalUnidades = 0;

        int mayorStock = -1;
        String productoMayorStock = "";
        int menorStock = Integer.MAX_VALUE;
        String productoMenorStock = "";

        scanner.nextLine();

        for (int i = 0; i < P; i++) {
            System.out.print("\nProducto " + (i + 1) + " - Nombre: ");
            nombresProductos[i] = scanner.nextLine();

            System.out.print("Producto " + (i + 1) + " - Cantidad: ");
            cantidades[i] = scanner.nextInt();

            totalUnidades += cantidades[i];

            if (cantidades[i] > mayorStock) {
                mayorStock = cantidades[i];
                productoMayorStock = nombresProductos[i];
            }

            if (cantidades[i] < menorStock) {
                menorStock = cantidades[i];
                productoMenorStock = nombresProductos[i];
            }

            scanner.nextLine();
        }

        System.out.println("\n===== INFORME DE INVENTARIO =====");
        System.out.println("Total de unidades en inventario: " + totalUnidades);
        System.out.println("Producto con mayor stock: " + productoMayorStock + " (" + mayorStock + " unidades)");
        System.out.println("Producto con menor stock: " + productoMenorStock + " (" + menorStock + " unidades)");

        System.out.println("\n===== ALERTA DE STOCK CRÍTICO (< 10 UNIDADES) =====");
        boolean hayStockCritico = false;
        final int LIMITE_CRITICO = 10;

        for (int i = 0; i < P; i++) {
            if (cantidades[i] < LIMITE_CRITICO) {
                System.out.println(" CRÍTICO: " + nombresProductos[i] + " tiene solo " + cantidades[i] + " unidades.");
                hayStockCritico = true;
            }
        }

        if (!hayStockCritico) {
            System.out.println("No hay productos con stock crítico (menor a " + LIMITE_CRITICO + " unidades).");
        }
    }
}



