import java.util.Scanner;
public class RegistroDeVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_DIAS = 31;
        double[] ventas = new double[MAX_DIAS];
        int diasRegistrados = 0;

        System.out.println("===== REGISTRO DE VENTAS MENSUALES =====");
        System.out.print("Ingrese el número de días del mes (máximo 31): ");
        int n = scanner.nextInt();

        if (n <= 0 || n > MAX_DIAS) {
            System.out.println("Número de días inválido. Usaremos 31 días por defecto.");
            n = MAX_DIAS;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese las ventas del Día " + (i + 1) + ": $");
            ventas[i] = scanner.nextDouble();
            diasRegistrados++;
        }

        double totalVentas = 0;
        double maxVentas = ventas[0];
        int diaConMaxVentas = 1;

        for (int i = 0; i < diasRegistrados; i++) {
            totalVentas += ventas[i];

            if (ventas[i] > maxVentas) {
                maxVentas = ventas[i];
                diaConMaxVentas = i + 1;
            }
        }

        double sumaFinSemana = 0;
        int countFinSemana = 0;
        double sumaLaboral = 0;
        int countLaboral = 0;

        for (int i = 0; i < diasRegistrados; i++) {
            int diaDeSemana = (i + 1) % 7;

            if (diaDeSemana == 6 || diaDeSemana == 0) {
                sumaFinSemana += ventas[i];
                countFinSemana++;
            } else {
                sumaLaboral += ventas[i];
                countLaboral++;
            }
        }

        double promedioFinSemana = (countFinSemana > 0) ? sumaFinSemana / countFinSemana : 0;
        double promedioLaboral = (countLaboral > 0) ? sumaLaboral / countLaboral : 0;

        System.out.println("\n===== ANÁLISIS DE VENTAS =====");
        System.out.printf("Total de ventas del mes: $%.2f\n", totalVentas);
        System.out.println("Día con mayores ventas: Día " + diaConMaxVentas + " con $" + maxVentas);
        System.out.printf("Promedio de ventas en días laborales: $%.2f\n", promedioLaboral);
        System.out.printf("Promedio de ventas en fines de semana: $%.2f\n", promedioFinSemana);

        scanner.close();
    }
}

