public class SumaSucesion {
    public static void main(String[] args) {
        int numElementos = 10;

        double suma= 0.0;
        for (int i = 0; i < numElementos; i++) {
            double termino = Math.pow(i, 2) / (Math.sqrt(i + 1));
            suma += termino;
            System.out.println("Término " + (i + 1) + ": " + termino);
        }
        System.out.println("\nLa suma total de los primeros " + numElementos + " términos es: " + suma);
    }
}