package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;


public class Usuario {
    private Integer id;
    private String nombre;
    private String correo;
    private String contrasenia;
    private String telefono;
    private TipoUsuario tipoUsuario;

    private String palabraSecreta;

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public void setPalabraSecreta(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String correo, String contrasenia, String telefono, TipoUsuario tipoUsuario, String palabraSecreta) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.palabraSecreta = palabraSecreta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", palabraSecreta='" + palabraSecreta + '\'' +
                '}';
    }
}
