import javax.swing.JOptionPane;

public class PuntajesJuego {
    public static void main(String[] args) {

        int cantidad;

        do {
            cantidad = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese la cantidad de puntajes (5 a 15):")
            );
        } while (cantidad < 5 || cantidad > 15);

        int[] puntajes = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int nota;
            do {
                nota = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese puntaje #" + (i + 1) + " (0 a 100):")
                );
            } while (nota < 0 || nota > 100);
            puntajes[i] = nota;
        }

        int max = puntajes[0];
        int min = puntajes[0];
        int suma = 0;
        int mayores90 = 0;

        for (int i = 0; i < cantidad; i++) {
            if (puntajes[i] > max) max = puntajes[i];
            if (puntajes[i] < min) min = puntajes[i];
            if (puntajes[i] >= 90) mayores90++;
            suma += puntajes[i];
        }

        double promedio = (double) suma / cantidad;

        JOptionPane.showMessageDialog(null,
                "Puntaje máximo: " + max +
                        "\nPuntaje mínimo: " + min +
                        "\nPromedio: " + promedio +
                        "\nPuntajes >= 90: " + mayores90
        );

        int opcion;
        do {
            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "MENÚ\n" +
                                    "1. Ver todos los puntajes\n" +
                                    "2. Ver puntajes aprobados (>= 60)\n" +
                                    "3. Ver puntajes reprobados (< 60)\n" +
                                    "4. Salir"
                    )
            );

            String resultado = "";

            switch (opcion) {
                case 1:
                    for (int p : puntajes) resultado += p + "\n";
                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 2:
                    for (int p : puntajes)
                        if (p >= 60) resultado += p + "\n";
                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 3:
                    for (int p : puntajes)
                        if (p < 60) resultado += p + "\n";
                    JOptionPane.showMessageDialog(null, resultado);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 4);
    }
}