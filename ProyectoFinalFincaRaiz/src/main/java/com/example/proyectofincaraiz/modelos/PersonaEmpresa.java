package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;

public class PersonaEmpresa extends Usuario {

    private String contrasenia;
    private String palabraSecreta;


    public PersonaEmpresa(String id, String nombre, String correo, String telefono, TipoUsuario tipoUsuario, String contrasenia, String palabraSecreta) {
        super(id, nombre, correo, telefono, tipoUsuario);
        this.contrasenia = contrasenia;
        this.palabraSecreta = palabraSecreta;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public void setPalabraSecreta(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public boolean validar(String contrasenia) {
        try {
            if (this.contrasenia.equalsIgnoreCase(contrasenia)) {
                //System.out.println("las contraseñas coinciden");
                return true;
            } else {
                //System.out.println("Las contraseñas no coinciden");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return false;
    }
}
