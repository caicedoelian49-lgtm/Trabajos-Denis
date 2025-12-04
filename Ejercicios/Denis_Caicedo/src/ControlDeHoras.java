import java.util.Scanner;

public class ControlDeHoras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_DIAS = 14;
        double[] horasTrabajadas = new double[NUM_DIAS];

        System.out.println("===== REGISTRO DE HORAS TRABAJADAS (14 días) =====");

        for (int i = 0; i < NUM_DIAS; i++) {
            System.out.print("Ingrese las horas trabajadas del Día " + (i + 1) + ": ");
            horasTrabajadas[i] = scanner.nextDouble();
        }

        double totalHoras = 0;
        int diasConExtra = 0;

        double menorCarga = horasTrabajadas[0];
        int diaMenorCarga = 1;

        for (int i = 0; i < NUM_DIAS; i++) {
            totalHoras += horasTrabajadas[i];

            if (horasTrabajadas[i] > 8.0) {
                diasConExtra++;
            }

            if (horasTrabajadas[i] < menorCarga) {
                menorCarga = horasTrabajadas[i];
                diaMenorCarga = i + 1;
            }
        }

        System.out.println("\n===== INFORME LABORAL ======");
        System.out.printf("Total de horas trabajadas en 14 días: %.2f horas\n", totalHoras);
        System.out.println("Días que superaron las 8 horas: " + diasConExtra);
        System.out.printf("Día con la menor carga laboral: Día %d con %.2f horas\n", diaMenorCarga, menorCarga);
    }
}