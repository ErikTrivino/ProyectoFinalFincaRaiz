module com.example.proyectofinzaraiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectofinzaraiz to javafx.fxml;
    exports com.example.proyectofinzaraiz;
}