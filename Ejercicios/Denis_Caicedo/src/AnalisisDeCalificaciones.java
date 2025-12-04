import java.util.Arrays;
import java.util.Scanner;

public class AnalisisDeCalificaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_ESTUDIANTES = 10;
        double[] calificaciones = new double[NUM_ESTUDIANTES];

        System.out.println("===== REGISTRO Y ANÁLISIS DE CALIFICACIONES (10 estudiantes) =====");

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese la calificación del estudiante " + (i + 1) + " (0.0 a 5.0): ");
            calificaciones[i] = scanner.nextDouble();
        }

        Arrays.sort(calificaciones);

        double mediana;
        int medio1 = NUM_ESTUDIANTES / 2 - 1;
        int medio2 = NUM_ESTUDIANTES / 2;
        mediana = (calificaciones[medio1] + calificaciones[medio2]) / 2.0;

        double moda = calificaciones[0];
        int maxFrecuencia = 0;

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            int frecuenciaActual = 0;
            for (int j = 0; j < NUM_ESTUDIANTES; j++) {
                if (calificaciones[i] == calificaciones[j]) {
                    frecuenciaActual++;
                }
            }

            if (frecuenciaActual > maxFrecuencia) {
                maxFrecuencia = frecuenciaActual;
                moda = calificaciones[i];
            }
        }

        int aprobados = 0;
        for (double nota : calificaciones) {
            if (nota >= 3.0) {
                aprobados++;
            }
        }

        int reprobados = NUM_ESTUDIANTES - aprobados;
        double porcentajeAprobados = (double) aprobados / NUM_ESTUDIANTES * 100;
        double porcentajeReprobados = (double) reprobados / NUM_ESTUDIANTES * 100;

        System.out.println("\n===== RESULTADOS ESTADÍSTICOS =====");
        System.out.printf("Mediana de las notas: %.2f\n", mediana);
        System.out.printf("Moda de las notas (valor más frecuente): %.2f\n", moda);
        System.out.printf("Porcentaje de Aprobados (>= 3.0): %.2f%%\n", porcentajeAprobados);
        System.out.printf("Porcentaje de Reprobados (< 3.0): %.2f%%\n", porcentajeReprobados);

        System.out.println("\n===== HISTOGRAMA TEXTUAL DE CALIFICACIONES =====");
        int[] conteoPorNota = new int[6];
        for (double nota : calificaciones) {
            int notaEntera = (int) Math.round(nota);
            if (notaEntera >= 0 && notaEntera <= 5) {
                conteoPorNota[notaEntera]++;
            }
        }

        for (int i = 0; i < conteoPorNota.length; i++) {
            System.out.printf("Nota %d: ", i);
            for (int j = 0; j < conteoPorNota[i]; j++) {
                System.out.print("*");
            }
            System.out.println(" (" + conteoPorNota[i] + ")");
        }
    }
}