import java.util.Scanner;
public class TemperaturasDiarias {
    public static void main(String[] args) {

        final int DIAS_SEMANA = 7;
        double[] temperaturas = new double[DIAS_SEMANA];
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REGISTRO DE TEMPERATURAS SEMANALES ===");
        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.print("Ingrese la temperatura del Día " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
            double sumaTemperaturas = 0;
            double maxTemp = temperaturas[0];
            int diaMasCaliente = 1;
            double minTemp = temperaturas[0];
            int diaMasFrio = 1;

            for (int i1 = 0; i < DIAS_SEMANA; i++){
                sumaTemperaturas += temperaturas[i];

                if (temperaturas[i] > maxTemp){
                    maxTemp = temperaturas[i];
                    diaMasCaliente = i + 1;
                }

                if (temperaturas[i] < minTemp){
                    minTemp = temperaturas[i];
                    diaMasFrio = i + 1;
                }
            }

            double promedioSemanal = sumaTemperaturas / DIAS_SEMANA;

            int diasSobrePromedio = 0;
            for (double temp : temperaturas){
                if (temp > promedioSemanal){
                    diasSobrePromedio++;
                }
            }

            System.out.println("\n=====RESULTADOS DEL ANÁLISIS=====");
            System.out.printf("Promedio semanal de temperatura: %.2f °C\n", promedioSemanal);
            System.out.println("Día más caliente: Día " + diaMasCaliente + " con " + maxTemp + " °C");
            System.out.println("Día más frío: Día " + diaMasFrio + " con " + minTemp + " °C");
            System.out.println("Días con temperatura superior al promedio: " + diasSobrePromedio);

            scanner.close();
        }
    }
}
