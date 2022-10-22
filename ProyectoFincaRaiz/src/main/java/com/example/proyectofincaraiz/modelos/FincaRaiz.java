package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;
import com.example.proyectofincaraiz.modelos.propiedades.Lote;

import java.util.ArrayList;

public class FincaRaiz {
    private String nombre;
    private String nit;

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Propiedades> propiedades = new ArrayList<>();

    public FincaRaiz(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;

        usuarios.add(new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.ADMIN, "amarillo"));
        usuarios.add(new Usuario(1234, "ana", "ana@", "4321", "3042211", TipoUsuario.EMPLEADO, "eli"));

        propiedades.add(new Lote(1234, "Carrera 17A-Bogota", 1000000f, "Urbano", TipoEstado.HABILITADA, TipoVenta.VENTA, usuarios.get(0)));



    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /*******************************Metodos Propiedades************************************/

    //Metodo Agregar


    //Metodo Desabilitar Propiedad

    //Meotodo Cambiar tipó de venta

    







    /********************************Metodos Usuarios*********************************************/

    public void agregarUsuario(Integer id, String nombre, String correo, String contrasenia, String telefono, TipoUsuario tipoUsuario, String palabraSecreta){
        usuarios.add(new Usuario(id, nombre, correo, contrasenia, telefono, tipoUsuario, palabraSecreta));
        //Falta verificar datos

    }

    public boolean eliminarUsuario(Integer id){
        boolean flagEliminado = false;
        do {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getId() == id) {
                    usuarios.remove(i);
                    flagEliminado = true;

                }
            }
        } while (flagEliminado == false);
        return flagEliminado;
    }
    public void modificarUsuario(){}

    /*public Usuario obtenerUsuario(Integer id){
        int posicion = 0;
        boolean flagEncontrado = false;
        do {
            for(int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getId() == (id)) {
                    posicion = i;
                    flagEncontrado = true;
                }
            }
            if(flagEncontrado == false){
                posicion = -1;

            }

        }while(flagEncontrado == false);


        return usuarios.get(posicion);
    }
    */

    public Usuario obtenerUsuario(String id){
        int posicion = 0;
        boolean flagEncontrado = false;
        do {
            for(int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getNombre().equals(id)) {
                    posicion = i;
                    flagEncontrado = true;
                }
            }
            if(flagEncontrado == false){
                posicion = -1;

            }

        }while(flagEncontrado == false);


        return usuarios.get(posicion);
    }


}
