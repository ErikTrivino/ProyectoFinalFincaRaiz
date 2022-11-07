/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.proyectofincaraiz.modelos.login;

import com.example.proyectofincaraiz.modelos.Usuario;

import java.util.HashMap;

/**
 *
 * @author joseb
 */
public abstract class Verificador {

    //Puesto que el atributo login es la clave, el map se declara con String, no Integer
    //Podemos usar un HashMap, que no acepta duplicados, es decir, dos usuarios no podrán tener
    //el mismo login
    protected  HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
    //Los desafios, son datos String para token, Integer para respuesta
    protected HashMap<String, Integer> desafios = new HashMap<String, Integer>();

    public abstract String peticionDesafio(); //Devuelve una cadena con una pregunta

    public void nuevoUsuario(Usuario usuario)  {
        usuarios.put(usuario.getNombre(), usuario);
    }


  /*  public boolean borrarUsuario(Usuario usuario) {
        return usuarios.remove(usuario.getNombre(), usuario);
    }*/

    //public abstract String loginPaso1(String login, String password);
    public abstract boolean loginPaso1(String login, String password);

    //public static boolean loginPaso2(String token, Integer respuesta);
    //public static boolean loginPaso2(String nombre, String respuesta);

    public abstract boolean loginPaso2(String nombre, String respuesta);
}
