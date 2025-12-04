import java.util.Scanner;
public class GestionDeEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== GESTIÓN DE NOTAS DE ESTUDIANTES =====");

        System.out.print("Ingrese el número total de estudiantes (N): ");
        int N = scanner.nextInt();

        String[] nombres = new String[N];
        double[] notas = new double[N];
        double sumaNotas = 0;

        double mejorNota = -1;
        String mejorEstudiante = "";

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            System.out.print("Ingrese la nota de " + nombres[i] + ": ");
            notas[i] = scanner.nextDouble();
            sumaNotas += notas[i];

            if (notas[i] > mejorNota) {
                mejorNota = notas[i];
                mejorEstudiante = nombres[i];
            }

            scanner.nextLine();
        }

        double promedioGeneral = (N > 0) ? sumaNotas / N : 0;

        System.out.println("\n===== RESULTADOS DEL CURSO =====");
        System.out.printf("Promedio general del curso: %.2f\n", promedioGeneral);
        System.out.println("Estudiante con mejor rendimiento: " + mejorEstudiante + " con nota: " + mejorNota);

        System.out.println("\n--- LISTA DE ESTUDIANTES REPROBADOS (Nota < 3.0) ---");
        boolean hayReprobados = false;
        for (int i = 0; i < N; i++) {
            if (notas[i] < 3.0) {
                System.out.println("- " + nombres[i] + " (" + notas[i] + ")");
                hayReprobados = true;
            }
        }

        if (!hayReprobados) {
            System.out.println("No hay estudiantes con nota inferior a 3.0.");
        }

    }
}
