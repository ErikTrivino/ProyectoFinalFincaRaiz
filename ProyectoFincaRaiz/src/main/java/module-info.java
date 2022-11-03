module com.example.proyectofincaraiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyectofincaraiz to javafx.fxml;
    exports com.example.proyectofincaraiz;
}