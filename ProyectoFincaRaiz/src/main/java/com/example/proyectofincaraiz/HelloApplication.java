package com.example.proyectofincaraiz;

import com.example.proyectofincaraiz.modelos.FincaRaiz;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.login.PalabraSecreta;
import com.example.proyectofincaraiz.modelos.login.Registro;
import com.example.proyectofincaraiz.modelos.login.Verificador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //@Override
  public void start(Stage stage) throws Exception {
      TextArea textArea = new TextArea();
      Parent root =FXMLLoader.load(getClass().getResource("hellow-view.fxml"));
      //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hellow-view.fxml"));
      stage.setScene(new Scene(root,600,400));
      stage.show();

  }
      public static void main(String[] args){
          launch(args);
      }


      /*  FincaRaiz empresa = new FincaRaiz("Gods", "431113");




        String pass = "1234";
        String usu = "erik";

        Verificador ver = new PalabraSecreta(3);
        for(int i = 0; i < empresa.getUsuarios().size(); i++){
            ver.nuevoUsuario(empresa.getUsuarios().get(i));
        }




        if(ver.loginPaso1(usu,pass)){
            System.out.println("hola" + empresa.obtenerUsuario(usu).toString());
            System.out.println("Acceso concedido");


        }else{
            System.out.println("Ingrese su palaabra secreta");
            String palabraSe = "amarillo";
            if(ver.loginPaso2("erik", palabraSe)){
                System.out.println("Accesoo concedido");

        }


        }*/


      }
