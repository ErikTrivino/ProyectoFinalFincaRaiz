package com.example.proyectofincaraiz;

import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.login.Registro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextArea txt_nombre;

    @FXML
    private TextArea txt_correo;

    @FXML
    private TextArea txt_palabraSecreta;

    @FXML
    private TextArea txt_telefono;

    @FXML
    private TextArea txt_pw;

    @FXML
    private TextArea txt_id;



    @FXML
     TipoUsuario tipoUser(){
        TipoUsuario usuario = TipoUsuario.PROPIETARIO;
        return usuario;
    }



    @FXML
    public void onHelloButtonClick(ActionEvent actionEvent) {
        TextArea textArea = new TextArea();

        Registro persona= new Registro();



        persona.guardarUsuario();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicializando");



    }

}
