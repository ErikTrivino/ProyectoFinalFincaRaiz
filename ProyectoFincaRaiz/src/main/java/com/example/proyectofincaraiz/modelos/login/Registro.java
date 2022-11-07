package com.example.proyectofincaraiz.modelos.login;

import com.example.proyectofincaraiz.herramienta.ConectorMySQL;
import com.example.proyectofincaraiz.modelos.Usuario;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Registro{
    ConectorMySQL conec = new ConectorMySQL();

    //generar la conexion
    Connection conectar = conec.Conectar();



    public void guardarUsuario(Usuario usuario1) {
        try {

            String SQL_INSERT = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";
            System.out.println(usuario1.getTipoUsuario());

            PreparedStatement pstm = conectar.prepareStatement(SQL_INSERT);
            pstm.setString(1, usuario1.getId().trim());
            pstm.setString(2, usuario1.getNombre().trim());
            pstm.setString(3, usuario1.getContrasenia().trim());
            pstm.setString(4, usuario1.getCorreo().trim());
            pstm.setString(5, usuario1.getTelefono());
            pstm.setString(6, String.valueOf(usuario1.getTipoUsuario()));
            pstm.setString(7, usuario1.getPalabraSecreta());

            pstm.executeUpdate();

            System.out.println("guardado");

        } catch (Exception e) {

            System.err.println("Error al guardar los datos en la BD" + e.getMessage());
        }
    }


}
