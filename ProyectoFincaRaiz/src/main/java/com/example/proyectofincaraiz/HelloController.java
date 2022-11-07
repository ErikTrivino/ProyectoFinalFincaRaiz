package com.example.proyectofincaraiz;

import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.login.Registro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtCedula;
    @FXML
    public TextField txtTelefono;
    @FXML
    public TextField txtCorreo;
    @FXML
    public TextField txtContrasenia;
    @FXML
    public TextField txtsecreta;


    @FXML
     TipoUsuario tipoUser(){
        return TipoUsuario.PROPIETARIO;
    }



    @FXML
    public void onHelloButtonClick(ActionEvent actionEvent) {
        String cedula=txtCedula.getText();
        String nombre=txtNombre.getText();
        String correo=txtCorreo.getText();
        String contrasenia= txtContrasenia.getText();
        String telefono=txtTelefono.getText();
        TipoUsuario tipo =tipoUser();
        String secreta = txtsecreta.getText();


        Usuario usuario1 =new Usuario(cedula,nombre,correo,contrasenia,telefono,tipo,secreta);

        Registro persona= new Registro();
        persona.guardarUsuario(usuario1);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicializando");


    }

}
