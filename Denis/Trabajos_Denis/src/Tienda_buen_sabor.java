public class Tienda_buen_sabor {
  public static void main(String[] args) {

      // PARA LA FACTURA NOMBRE, PRECIO, IVA, IMC, PRECIO FINAL
System.out.println();

      String nombre = "Leche";
      double precio = 5.5;
      double iva = 0.15;
      double imc = 0.15;



      double precioConIVA = precio*iva;
      double precioConIMC = precio*imc;


      System.out.println("nombre = " + nombre);
      System.out.println("precio = " + precio);
      System.out.println("precioConIMC = " + precioConIMC);
      System.out.println("precioConIVA = " + precioConIVA);
  }
}