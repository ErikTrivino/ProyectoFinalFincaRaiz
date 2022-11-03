package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.exceptions.ElementoExisteException;
import com.example.proyectofincaraiz.exceptions.ElementoNoExisteException;
import com.example.proyectofincaraiz.exceptions.ValorRequeridoException;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;
import com.example.proyectofincaraiz.modelos.propiedades.Lote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FincaRaiz {
    private String nombre;
    private String nit;

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Propiedad> propiedades = new ArrayList<>();

    private ArrayList<Venta> ventas = new ArrayList<>();

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

    /*Todos los metodos q estan hechos solo es pura logica de CRUD, pero toca verifica todo con exceptions o ya se solo verificar que si sean o esten los datos*/

    /*******************************Metodos Propiedades************************************/

    //Metodo Agregar
    public void agregarPropiedad(Propiedad propiedad) throws ElementoExisteException, ValorRequeridoException {
        //verificar Datos
        if(buscarPropiedadByNumeroIdentificacion(propiedad.getId()).isPresent()){
            throw new ElementoExisteException();
        }
        if(propiedad.getUsuario() == null){
            throw new ValorRequeridoException("Propietario");
        }
        
        propiedades.add(propiedad);
    }

    public Optional<Propiedad> buscarPropiedadByNumeroIdentificacion(Integer numeriIdentificacion) {
        return propiedades.stream()
                .filter(propiedad -> propiedad.getId() == numeriIdentificacion)
                .findFirst();
    }



    //Metodo Desabilitar Propiedad

    public void desabilitarPropiedad(Propiedad propiedad){

        int pos = obtenerPosicionPropiedad(propiedad.getId());

        Propiedad propiedadCambio = propiedades.get(pos);

        propiedadCambio.setEstado(TipoEstado.DESABILITADA);

        propiedades.set(pos, propiedadCambio);



    }

    //Meotodo Cambiar tipó de venta

    public void cambiarTipoVenta(Propiedad propiedad, TipoVenta tipoVenta){
        int pos = obtenerPosicionPropiedad(propiedad.getId());

        Propiedad propiedadCambio = propiedades.get(pos);

        propiedadCambio.setTipoVenta(tipoVenta);

        propiedades.set(pos, propiedadCambio);

    }

    //nose si dejarlo
    public void modificarPropiedad(Propiedad propiedad){
        int pos = obtenerPosicionPropiedad(propiedad.getId());

        propiedades.set(pos,propiedad);
    }



    //Puede recibir el id o  la propiedad
    //Se coloca boolean por si no existe la propiedad


    //Se manda solo el ID??
    public void eliminarPropiedad(Propiedad propiedad) throws ElementoNoExisteException {
        Optional<Propiedad> propiedadCambio = buscarPropiedadByNumeroIdentificacion(propiedad.getId());
        if( propiedadCambio.isEmpty() ){
            throw new ElementoNoExisteException();
        }
        propiedades.remove(propiedadCambio.get());




/*
        boolean flagEliminado = false;
        do {
            for (int i = 0; i < propiedades.size(); i++) {
                if (propiedades.get(i).getId()== propiedad.getId()) {
                    propiedades.remove(i);
                    flagEliminado = true;

                }
            }
        } while (flagEliminado == false);

        return flagEliminado;*/

    }



    public int obtenerPosicionPropiedad(int id){
        int pos = 0;
        boolean flagEncontrado = false;
        do {
            for(int i = 0; i < propiedades.size(); i++){
                if (propiedades.get(i).getId() == id) {
                    pos = i;
                    flagEncontrado = true;
                }
            }
            if(flagEncontrado == false){
                pos = -1;

            }
        }while(flagEncontrado == false && pos == 0);
        return pos;
    }
    


    /********************************Metodos Usuarios*********************************************/

    public void agregarUsuario(Usuario usuario) throws ElementoExisteException{

        if(buscarUsuarioByNumeroIdentificacion(usuario.getId()).isPresent()){
            throw new ElementoExisteException();
        }
        usuarios.add(usuario);

        //Falta verificar datos

    }

    public Optional<Usuario> buscarUsuarioByNumeroIdentificacion(Integer numeriIdentificacion) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == numeriIdentificacion)
                .findFirst();
    }

    public Optional<Usuario> buscarUsuarioByNombre(String nombre) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNombre().equals(nombre))
                .findFirst();
    }


    /*public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
        //Falta verificar datos

    }*/

    public void eliminarUsuario(Usuario usuario) throws  ElementoNoExisteException{
        Optional<Usuario> usuarioCambio = buscarUsuarioByNumeroIdentificacion(usuario.getId());
        if( usuarioCambio.isEmpty() ){
            throw new ElementoNoExisteException();
        }
        propiedades.remove(usuarioCambio.get());
    }


    //Cambio nose :v
    public void modificarUsuario(Usuario usuario){
        //Usuario u1 = usuario;
        int pos = obtenerPosicionUsuario(usuario.getId());
        usuarios.set(pos, usuario);

    }

    public int obtenerPosicionUsuario(Integer id){
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


        return posicion;
    }


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

    /***********************************Metodos  Venta *****************************************/

    public void agregarVenta(Venta venta) throws ElementoExisteException{

        if(buscarVentaByCodigoFactura(venta.getCodigoFactura()).isPresent()){
            throw new ElementoExisteException();
        }
        ventas.add(venta);

    }

    public Optional<Venta> buscarVentaByCodigoFactura(Integer numeriIdentificacion) {
        return ventas.stream()
                .filter(usuario -> usuario.getCodigoFactura() == numeriIdentificacion)
                .findFirst();
    }

    public ArrayList<Venta> buscarVentaPorFecha(LocalDate dateIncio, LocalDate dateFinal){
       return (ArrayList<Venta>) ventas.stream()
               .filter(x -> x.getFechaFactura().isAfter(dateIncio))
                .filter(x -> x.getFechaFactura().isBefore(dateFinal))
               .sorted(Comparator.comparing(Venta::getFechaFactura))
              // .map(venta -> (Venta) venta)
                .collect(Collectors.toList());



    }

    ////////////////////METODO PAAR OBETNER DIFERENTES TIPOS DE USUARIOS ///////////////
    /*
    * Con el fin de buscar propiestarios para poder crear el objeto propiedad
    * */

    public ArrayList<Usuario> buscarUsuariosPorParametro(TipoUsuario tipoUsuario){

       return (ArrayList<Usuario>) usuarios.stream()
                .filter(x -> x.getTipoUsuario() == tipoUsuario)
                .collect(Collectors.toList());
    }

    public boolean verificarUsuario(String usuario){
        if(usuario != null){
            return true;
        }
        return false;
    }
    public Usuario existeUsuario(String usuario){
        List<Usuario> usuarios1 = usuarios;
        Usuario usuarioEncontrado = null;
        for(Usuario nombre : usuarios){
            if(nombre.getNombre().equals(usuario))
                usuarioEncontrado = (Usuario) usuarios1;
        }
        return usuarioEncontrado;
    }
    public boolean validarPassword(String userName, String password){
        boolean acceso = false;
        Usuario usuarioValido = existeUsuario(userName);
        if(usuarioValido.getContrasenia().equals(password)){
            acceso = true;
        }
        return acceso;
    }
    public boolean validarPalabraSecreta(String userName, String palabraSecreta){
        boolean acceso = false;
        Usuario usuarioValido = existeUsuario(userName);
        if(usuarioValido.getPalabraSecreta().equals(palabraSecreta)){
            acceso = true;
        }
        return acceso;
    }
}
