package com.example.proyectofincaraiz.herramienta;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorMySQL {
    public Connection Conectar() {
        Connection conect=null;
        try{
            conect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_fincr","root","abc");

        }catch (Exception e){

        }
        return conect;
    }
}
