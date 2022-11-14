package com.example.proyectofincaraiz.exceptions;


public class ElementoExisteException extends Exception{

    public ElementoExisteException() {
        super("El elemento ya esta existe");
    }

}
