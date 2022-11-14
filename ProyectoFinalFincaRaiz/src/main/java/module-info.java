module com.example.proyectofincaraiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectofincaraiz to javafx.fxml;
    exports com.example.proyectofincaraiz;
    exports com.example.proyectofincaraiz.modelos;
    opens com.example.proyectofincaraiz.modelos to javafx.fxml;
}