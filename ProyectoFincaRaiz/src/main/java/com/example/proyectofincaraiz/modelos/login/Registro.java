package com.example.proyectofincaraiz.modelos.login;

import com.example.proyectofincaraiz.herramienta.ConectorMySQL;
import com.example.proyectofincaraiz.modelos.Usuario;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registro {
    ConectorMySQL conec = new ConectorMySQL();

    //generar la conexion
    Connection conectar = conec.Conectar();

    public void guardarUsuario() {
        try {

            String SQL_INSERT = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstm = conectar.prepareStatement(SQL_INSERT);
            pstm.setString(1, "5343232121");
            pstm.setString(2, "raul");
            pstm.setString(3, "12314123");
            pstm.setString(4, "blasdasd");
            pstm.setString(5, "31231432");
            pstm.setString(6, "ADMIN");
            pstm.setString(7, "gato");

            pstm.executeUpdate();

            System.out.println("guardado");

        } catch (Exception e) {

            System.err.println("Error al guardar los datos en la BD" + e.getMessage());
        }
    }


}
