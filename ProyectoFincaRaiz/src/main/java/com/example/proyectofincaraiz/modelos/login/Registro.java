package com.example.proyectofincaraiz.modelos.login;

import com.example.proyectofincaraiz.herramienta.ConectorMySQL;
import com.example.proyectofincaraiz.modelos.Usuario;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registro extends Usuario {
    ConectorMySQL conec = new ConectorMySQL();

    //generar la conexion
    Connection conectar = conec.Conectar();

    public void guardarUsuario() {
        try {

            String SQL_INSERT = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstm = conectar.prepareStatement(SQL_INSERT);
            pstm.setInt(1, getId());
            pstm.setString(2, getNombre());
            pstm.setString(3, getContrasenia());
            pstm.setString(4, getCorreo());
            pstm.setString(5, getTelefono());
            pstm.setObject(6, getTipoUsuario());
            pstm.setString(7, getPalabraSecreta());

            pstm.executeUpdate();

            System.out.println("guardado");

        } catch (Exception e) {

            System.err.println("Error al guardar los datos en la BD" + e.getMessage());
        }
    }


}
