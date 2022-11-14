package com.example.proyectofincaraiz.modelos;

import com.example.proyectofincaraiz.exceptions.CredencialNoValida;
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

        usuarios.add(new PersonaEmpresa("1234", "Erik", "erikp@", "31238833", TipoUsuario.ADMIN, "Amarillo123", "Hola mundo"));


        propiedades.add(new Lote("1234", "Carrera 17A-Bogota", 1000000f, "Urbano", TipoEstado.HABILITADA, TipoVenta.VENTA, usuarios.get(0)));

    }


    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
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
    public void agregarPropiedad(Propiedad propiedad, Usuario operario) throws ElementoExisteException, ValorRequeridoException, CredencialNoValida {
        //verificar Datos
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO){
            if(buscarPropiedadByNumeroIdentificacion(propiedad.getId()).isPresent()){
                throw new ElementoExisteException();
            }
            if(propiedad.getUsuario() == null){
                throw new ValorRequeridoException("Propietario");
            }

            propiedades.add(propiedad);
        }else {
            throw new CredencialNoValida();
        }

    }

    public Optional<Propiedad> buscarPropiedadByNumeroIdentificacion(String numeriIdentificacion) {
        return propiedades.stream()
                .filter(propiedad -> propiedad.getId().equals(numeriIdentificacion))
                .findFirst();
    }



    //Metodo Desabilitar Propiedad
    public void desabilitarPropiedad(Propiedad propiedad, Usuario operario) throws CredencialNoValida {

        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO){
            int pos = obtenerPosicionPropiedad(propiedad.getId());

            Propiedad propiedadCambio = propiedades.get(pos);

            propiedadCambio.setEstado(TipoEstado.DESABILITADA);

            propiedades.set(pos, propiedadCambio);

        }else {
            throw new CredencialNoValida();
        }



    }

    //Meotodo Cambiar tipó de venta

    public void cambiarTipoVenta(Propiedad propiedad, TipoVenta tipoVenta, Usuario operario) throws CredencialNoValida {
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            int pos = obtenerPosicionPropiedad(propiedad.getId());


            Propiedad propiedadCambio = propiedades.get(pos);

            propiedadCambio.setTipoVenta(tipoVenta);

            propiedades.set(pos, propiedadCambio);
        }else {
            throw new CredencialNoValida();
        }
    }

    //nose si dejarlo
    public void modificarPropiedad(Propiedad propiedad, Usuario operario) throws CredencialNoValida {
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            int pos = obtenerPosicionPropiedad(propiedad.getId());

            propiedades.set(pos, propiedad);
        }else {
            throw new CredencialNoValida();
        }
    }



    //Puede recibir el id o  la propiedad

    public void eliminarPropiedad(Propiedad propiedad, Usuario operario) throws ElementoNoExisteException, CredencialNoValida {
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            Optional<Propiedad> propiedadCambio = buscarPropiedadByNumeroIdentificacion(propiedad.getId());
            if (propiedadCambio.isEmpty()) {
                throw new ElementoNoExisteException();
            }
            propiedades.remove(propiedadCambio.get());
        }else {
            throw new CredencialNoValida();
        }


    }



    public int obtenerPosicionPropiedad(String id){
        int pos = 0;
        boolean flagEncontrado = false;
        do {
            for(int i = 0; i < propiedades.size(); i++){
                if (propiedades.get(i).getId().equals(id)){
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

    public void agregarUsuario(Usuario usuario,Usuario operario) throws ElementoExisteException, CredencialNoValida {

        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            if (buscarUsuarioByNumeroIdentificacion(usuario.getId()).isPresent()) {
                throw new ElementoExisteException();
            }
            usuarios.add(usuario);
        }else {
            throw new CredencialNoValida();
        }


    }

    public Optional<Usuario> buscarUsuarioByNumeroIdentificacion(String numeriIdentificacion) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(numeriIdentificacion))
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

    public void eliminarUsuario(Usuario usuarioEliminar, Usuario operario) throws ElementoNoExisteException, CredencialNoValida {
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            Optional<Usuario> usuarioCambio = buscarUsuarioByNumeroIdentificacion(usuarioEliminar.getId());
            if (usuarioCambio.isEmpty()) {
                throw new ElementoNoExisteException();
            }
            propiedades.remove(usuarioCambio.get());
        }else {
            throw new CredencialNoValida();
        }
    }


    //Cambio nose :v
    public void modificarUsuario(Usuario usuario, Usuario operario) throws CredencialNoValida {
        //Usuario u1 = usuario;
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {
            int pos = obtenerPosicionUsuario(usuario.getId());
            usuarios.set(pos, usuario);
        }else {
            throw new CredencialNoValida();
        }

    }

    public int obtenerPosicionUsuario(String id){
        int posicion = 0;
        boolean flagEncontrado = false;
        do {
            for(int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getId().equals(id)) {
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



    /***********************************Metodos  Venta *****************************************/

    public void agregarVenta(Venta venta, Usuario operario) throws ElementoExisteException, CredencialNoValida {
        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {

            if (buscarVentaByCodigoFactura(venta.getCodigoFactura()).isPresent()) {
                throw new ElementoExisteException();
            }
            ventas.add(venta);
        }else {
            throw new CredencialNoValida();
        }

    }

    public Optional<Venta> buscarVentaByCodigoFactura(Integer numeriIdentificacion) {
        return ventas.stream()
                .filter(usuario -> usuario.getCodigoFactura() == numeriIdentificacion)
                .findFirst();
    }

    public ArrayList<Venta> buscarVentaPorFecha(LocalDate dateIncio, LocalDate dateFinal, Usuario operario) throws CredencialNoValida {

        if(operario.getTipoUsuario() == TipoUsuario.ADMIN || operario.getTipoUsuario() == TipoUsuario.EMPLEADO) {

            return (ArrayList<Venta>) ventas.stream()
                    .filter(x -> x.getFechaFactura().isAfter(dateIncio))
                    .filter(x -> x.getFechaFactura().isBefore(dateFinal))
                    .sorted(Comparator.comparing(Venta::getFechaFactura))
                    // .map(venta -> (Venta) venta)
                    .collect(Collectors.toList());
        }else{
            throw new CredencialNoValida();
        }





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



    /////////////////////////////lOGIN////////////////////////////////////
    public boolean verificarUsuario(String nombre){
        if(nombre != null){
            return true;
        }
        return false;
    }


    //cambiar por el metoedo stream
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
        PersonaEmpresa usuarioValido = (PersonaEmpresa) buscarUsuarioByNombre(userName).get();

        //Usuario usuarioValido = existeUsuario(userName);

        if(usuarioValido.getContrasenia().equals(password)){
            acceso = true;
        }
        return acceso;
    }
    public boolean validarPalabraSecreta(String userName, String palabraSecreta){
        boolean acceso = false;
        PersonaEmpresa usuarioValido = (PersonaEmpresa) buscarUsuarioByNombre(userName).get();
        if(usuarioValido.getPalabraSecreta().equals(palabraSecreta)){
            acceso = true;
        }
        return acceso;
    }
}
