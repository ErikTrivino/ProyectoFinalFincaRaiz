package com.example.proyectofincaraiz.modelos.login;

public class PalabraSecreta extends  Verificador{

    /*Incompleto forma de medir los intentos que se realicen*/
    private int maxIntentos;

    public PalabraSecreta(int intentos) {
        maxIntentos = intentos;
    }

    @Override
    public String peticionDesafio() {
        return "Introduzca su Palabra Secreta: ";
    }




    public boolean loginPaso1(String nombre, String password) {
        if (!usuarios.containsKey(nombre))
            return false;
        else if (!usuarios.get(nombre).validar(password))
            return false;
        else {

            return true;

        }
    }

    @Override
    public boolean loginPaso2(String nombre, String respuesta) {
        if(!usuarios.containsKey(nombre))
            return false;
        else if (!usuarios.get(nombre).getPalabraSecreta().equals(respuesta) ) {
            return false;
        }

        return true;
    }
}
