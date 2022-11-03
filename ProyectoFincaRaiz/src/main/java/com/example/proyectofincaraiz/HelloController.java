package com.example.proyectofincaraiz;

import com.example.proyectofincaraiz.modelos.login.Registro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HelloController {



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
    private TextArea txt_tipouser;

    @FXML
    private TextArea txt_nombre;

    @FXML
    public void onHelloButtonClick(ActionEvent actionEvent) {
        Registro persona=new Registro();
        persona.guardarUsuario();
    }

    }
