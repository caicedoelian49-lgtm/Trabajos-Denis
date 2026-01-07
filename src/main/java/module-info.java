module com.mycompany.denis_trabajos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.denis_trabajos to javafx.fxml;
    exports com.mycompany.denis_trabajos;
}
