import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalisisDeNumeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("===== ANÁLISIS DE LISTA DE NÚMEROS =====");
        System.out.println("Ingrese números enteros (ingrese '0' para finalizar y procesar):");

        int entrada;
        while (true) {
            System.out.print("Número: ");
            if (scanner.hasNextInt()) {
                entrada = scanner.nextInt();
                if (entrada == 0) {
                    break;
                }
                numeros.add(entrada);
            } else {
                System.out.println("Entrada inválida. Ingrese solo números enteros.");
                scanner.next();
            }
        }

        if (numeros.isEmpty()) {
            System.out.println("No se ingresaron números para analizar.");
            return;
        }

        int N = numeros.size();
        int maximo = numeros.get(0);
        int minimo = numeros.get(0);
        int pares = 0;
        int impares = 0;
        long sumaAcumulada = 0;

        System.out.println("\n===== RESULTADOS DEL ANÁLISIS =====");
        System.out.print("Lista de números ingresados: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : numeros) {
            sumaAcumulada += num;

            if (num > maximo) {
                maximo = num;
            }
            if (num < minimo) {
                minimo = num;
            }

            if (num % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        double promedioGeneral = (double) sumaAcumulada / N;

        System.out.println("Número mayor: " + maximo);
        System.out.println("Número menor: " + minimo);
        System.out.println("Cantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
        System.out.println("Suma acumulada total: " + sumaAcumulada);
        System.out.printf("Promedio general: %.2f\n", promedioGeneral);
    }
}
