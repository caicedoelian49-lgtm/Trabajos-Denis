import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SumaNumeros extends Application {

    @Override
    public void start(Stage stage) {

        // Labels
        Label lblTitulo = new Label("Suma de dos números");
        Label lblResultado = new Label("Resultado:");

        // TextFields (equivalente a JTextField en Swing)
        TextField txtNumero1 = new TextField();
        txtNumero1.setPromptText("Ingrese el primer número");

        TextField txtNumero2 = new TextField();
        txtNumero2.setPromptText("Ingrese el segundo número");

        // Botón
        Button btnSumar = new Button("Sumar");

        // Evento del botón
        btnSumar.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(txtNumero1.getText());
                double num2 = Double.parseDouble(txtNumero2.getText());
                double suma = num1 + num2;

                lblResultado.setText("Resultado: " + suma);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese solo números");
            }
        });

        // Contenedor
        VBox contenedor = new VBox(10);
        contenedor.setStyle("-fx-padding: 20;");
        contenedor.getChildren().addAll(
                lblTitulo,
                txtNumero1,
                txtNumero2,
                btnSumar,
                lblResultado
        );

        // Scene
        Scene scene = new Scene(contenedor, 320, 250);

        // Stage
        stage.setTitle("Ejercicio JavaFX - Suma");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}