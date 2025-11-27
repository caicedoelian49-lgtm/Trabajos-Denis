import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int limite;
        int diaSemana;

        System.out.println("Ingrese el límite máximo de productos:");
        limite = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese el día de la semana:\n" +
                "1 = Lunes\n" +
                "2 = Martes\n" +
                "3 = Miércoles\n" +
                "4 = Jueves\n" +
                "5 = Viernes\n" +
                "6 = Sábado\n" +
                "7 = Domingo");
        diaSemana = input.nextInt();
        input.nextLine();

        boolean aplicaTCE = (diaSemana == 6 || diaSemana == 7);

        // ACUMULADORES
        float totalIVA = 0;
        float totalIMC = 0;
        float totalIRT = 0;
        float totalTCE = 0;
        float totalVentas = 0;


        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        // Producto más caro
        float mayorPrecio = -1;
        String productoMayor = "";

        int productosRegistrados = 0;


        while (productosRegistrados < limite) {

            System.out.println("\n Registro de producto.");

            String nombreProducto;
            float precioBase;
            int categoria;
            int riesgo;
            int stock;


            do {
                System.out.println("Ingrese el nombre del producto:");
                nombreProducto = input.nextLine();
            } while (nombreProducto.isEmpty());


            do {
                System.out.println("Ingrese el precio del producto (0.0):");
                precioBase = input.nextFloat();
                input.nextLine();
            } while (precioBase <= 0);


            do {
                System.out.println("Ingrese la categoría (1-4).:");
                System.out.println("Categorías:\n" +
                        "1=Electrónica personal, 2=Componentes de cómputo, 3=Accesorios (exentos de IVA), 4=Redes y telecomunicaciones");
                categoria = input.nextInt();
                input.nextLine();
            } while (categoria < 1 || categoria > 4);

            // --- Riesgo ---
            do {
                System.out.println("Tiene riesgo tecnológico? (1 = Sí, 0 = No):");
                riesgo = input.nextInt();
                input.nextLine();
            } while (riesgo != 0 && riesgo != 1);

            // --- Stock ---
            do {
                System.out.println("Ingrese stock (mínimo 1):");
                stock = input.nextInt();
                input.nextLine();
            } while (stock < 1);


            float iva;
            if (categoria == 3) {
                iva = 0;
            } else {
                iva = precioBase * 0.12f;
            }

            float imc = precioBase * 0.015f;
            float irt;
            if (riesgo == 1) {
                irt = precioBase * 0.037f;
            } else {
                irt = 0;
            }

            float tce = aplicaTCE ? precioBase * 0.02f : 0;

            float precioFinal = precioBase + iva + imc + irt + tce;


            totalIVA += iva * stock;
            totalIMC += imc * stock;
            totalIRT += irt * stock;
            totalTCE += tce * stock;
            totalVentas += precioFinal * stock;


            switch (categoria) {
                case 1: c1 += stock; break;
                case 2: c2 += stock; break;
                case 3: c3 += stock; break;
                case 4: c4 += stock; break;
            }


            if (precioFinal > mayorPrecio) {
                mayorPrecio = precioFinal;
                productoMayor = nombreProducto;
            }


            System.out.println("\n REPORTE DEL PRODUCTO ");
            System.out.println("Precio base: " + precioBase);
            System.out.println("IVA: " + iva);
            System.out.println("IMC: " + imc);
            System.out.println("IRT: " + irt);
            System.out.println("TCE: " + tce);
            System.out.println("Precio final: " + precioFinal);
            System.out.println("Stock ingresado: " + stock);

            productosRegistrados++;


            if (productosRegistrados < limite) {
                System.out.println("¿Desea ingresar otro producto? (S/N)");
                String op = input.nextLine().toUpperCase();
                if (op.equals("N")) break;
            }
        }


        System.out.println("\n=== REPORTE FINAL DEL DÍA ===");
        System.out.println("Productos registrados: " + productosRegistrados);
        System.out.println("Total IVA: " + totalIVA);
        System.out.println("Total IMC: " + totalIMC);
        System.out.println("Total IRT: " + totalIRT);
        System.out.println("Total TCE: " + totalTCE);
        System.out.println("Total ventas: " + totalVentas);


        String mayorCat = "Electrónica personal";
        int mayor = c1;

        if (c2 > mayor) { mayor = c2; mayorCat = "Componentes de cómputo"; }
        if (c3 > mayor) { mayor = c3; mayorCat = "Accesorios"; }
        if (c4 > mayor) { mayor = c4; mayorCat = "Redes y telecomunicaciones"; }

        System.out.println("Categoría con más productos: " + mayorCat);
        System.out.println("Producto más caro: " + productoMayor + " (Precio final: " + mayorPrecio + ")");

        System.out.println("Fin del sistema.");
    }
}