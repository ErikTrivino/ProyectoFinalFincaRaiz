import com.example.proyectofincaraiz.exceptions.ElementoExisteException;
import com.example.proyectofincaraiz.exceptions.ValorRequeridoException;
import com.example.proyectofincaraiz.modelos.FincaRaiz;
import com.example.proyectofincaraiz.modelos.Propiedad;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.Venta;
import com.example.proyectofincaraiz.modelos.enums.TipoEstado;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import com.example.proyectofincaraiz.modelos.enums.TipoVenta;
import com.example.proyectofincaraiz.modelos.propiedades.Lote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;


public class FincaRaizTest {
    FincaRaizTest(){
    }

 /*   @Test
        void verificarUsuario() throws ElementoExisteException, ValorRequeridoException {

        String nombre = "erik";
        String pass = "1234";
        String palabraSecreta = "amarillo";



        FincaRaiz fincaRaiz = new FincaRaiz("gods", "1234");


        try {
            Assertions.assertEquals(false, fincaRaiz.existeUsuario("erik"));
        } catch (Exception var7) {
            Assertions.fail("Error en el dato null " + var7.getMessage());
            var7.printStackTrace();
        }

        try {
            Assertions.assertEquals(true,fincaRaiz.validarPassword(nombre, pass) );
        }catch (Exception e){
            Assertions.fail("Error en la verificacionde password " + e.getMessage());
            e.printStackTrace();
        }

        try{
            Assertions.assertEquals(true,fincaRaiz.validarPalabraSecreta(nombre, palabraSecreta) );
        }catch (Exception e){
            Assertions.fail("Error en la verificacionde password " + e.getMessage());
            e.printStackTrace();
        }
        Usuario usuarioIngresado = null;

        if(fincaRaiz.validarPassword(nombre, pass)){
            usuarioIngresado = fincaRaiz.buscarUsuarioByNombre(nombre).get();
        }
        if(usuarioIngresado.getTipoEstado() == TipoEstado.DESABILITADA){
            System.out.println("Su cuenta es desabilitada para cualquier accion");
        }else{
            switch (usuarioIngresado.getTipoUsuario()){

                case ADMIN:

                    //metodosAdmin(usuarioIngresado, fincaRaiz);
                    //Mostrar una vista del admin
                    break;


                case EMPLEADO:

                    //metodosEmpleado(usuarioIngresado, fincaRaiz);
                    //Mostrar una vista para el empleado
                    break;


                case CLIENTE:

                    //metodosCliente(usuarioIngresado, fincaRaiz);
                    //Mostrar vista para el cliente

                    break;

                case PROPIETARIO:

                    //metodosPropietario(usuarioIngresado, fincaRaiz);
                    //Mostrar vista del propietario

                    break;
            }

        }

    }
    @Test
    void metodosAdmin() throws ElementoExisteException {
        Usuario usuario = new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.ADMIN, "amarillo");
        FincaRaiz fincaRaiz = new FincaRaiz("gods", "1234");

        //Registrar empleados

        Usuario usuarioPruebaFallo =new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.ADMIN, "amarillo");
        Usuario usuarioPrueba =new Usuario(12345, "diego", "diego@", "1234", "3104433", TipoUsuario.EMPLEADO, "amarillo");
        Usuario usuarioPruebaModificado =new Usuario(12345, "Diego", "diego@", "54321", "312743", TipoUsuario.EMPLEADO, "amarillo");
        try {
            fincaRaiz.agregarUsuario(usuarioPruebaFallo);
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        try{
            fincaRaiz.agregarUsuario(usuarioPrueba);
            Assertions.assertEquals(usuarioPrueba, fincaRaiz.buscarUsuarioByNumeroIdentificacion(usuarioPrueba.getId()).get() );
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        //Actualizacion de datos
        try{

            fincaRaiz.modificarUsuario(usuarioPruebaModificado);
            Assertions.assertEquals(usuarioPruebaModificado, fincaRaiz.buscarUsuarioByNumeroIdentificacion(usuarioPruebaModificado.getId()).get());

        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        //Bloqueo de cuentas

        try{
            usuarioPruebaModificado.setTipoEstado(TipoEstado.DESABILITADA);
            fincaRaiz.modificarUsuario(usuarioPruebaModificado);
            Assertions.assertEquals(usuarioPruebaModificado, fincaRaiz.buscarUsuarioByNumeroIdentificacion(usuarioPruebaModificado.getId()).get());


        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }


        //Vista reportes
        ArrayList<Venta> ventas = fincaRaiz.buscarVentaPorFecha(LocalDate.of(11, 01, 01), LocalDate.of(11, 11, 01));

    }

    @Test
    void metodosEmpleado() throws ElementoExisteException, ValorRequeridoException {
        Usuario usuario = new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.EMPLEADO, "amarillo");;
        FincaRaiz fincaRaiz = new FincaRaiz("gods", "1234");
        //Registro Propietario
        //Registro cliente
        //Registro propiedades

        //Traer Usuarios tipo Propietario
        //Sirve para poder crear propiedad
        ArrayList<Usuario> usuariosPorParametro=  fincaRaiz.buscarUsuariosPorParametro(TipoUsuario.PROPIETARIO);

        //Alquiler y venta (Crear venta)



        Usuario usuarioPruebaCliente =new Usuario(12345, "diego", "diego@", "1234", "3104433", TipoUsuario.EMPLEADO, "amarillo");
        try{
            fincaRaiz.agregarUsuario(usuarioPruebaCliente);
            Assertions.assertEquals(usuarioPruebaCliente, fincaRaiz.buscarPropiedadByNumeroIdentificacion(usuarioPruebaCliente.getId()).get());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        Usuario usuarioPropietario =new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.EMPLEADO, "amarillo");
        try{
            fincaRaiz.agregarUsuario(usuarioPropietario);
            Assertions.assertEquals(usuarioPropietario, fincaRaiz.buscarPropiedadByNumeroIdentificacion(usuarioPropietario.getId()).get());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        Lote propiedad = new Lote(123456, "Via tebaida", 123.00f, "Urbano", TipoEstado.HABILITADA, TipoVenta.VENTA, usuarioPropietario);
        try{
            fincaRaiz.agregarPropiedad(propiedad);
            Assertions.assertEquals(propiedad, fincaRaiz.buscarPropiedadByNumeroIdentificacion(propiedad.getId()).get());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        Venta venta = new Venta(1234, LocalDate.now(), usuarioPruebaCliente, usuario, propiedad, TipoVenta.VENTA, propiedad.getValorVenta().doubleValue());
        try {
            fincaRaiz.agregarVenta(venta);
            Assertions.assertEquals(venta, fincaRaiz.buscarPropiedadByNumeroIdentificacion(venta.getCodigoFactura()).get());
        }catch (Exception e){
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        //Retirar propiedad

        try{
            fincaRaiz.eliminarPropiedad(propiedad);
           // Propiedad propiedadBorrada =  fincaRaiz.buscarPropiedadByNumeroIdentificacion(propiedad.getId()).get();
            Assertions.assertEquals(null,fincaRaiz.buscarPropiedadByNumeroIdentificacion(propiedad.getId()).get()) ;


        }catch (Exception e){
            Assertions.fail("Error al borrar propiedad" +e.getMessage());
            e.printStackTrace();
        }

    }

    @Test
    public void metodosCliente(){
        Usuario usuario = new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.CLIENTE, "amarillo");
        FincaRaiz fincaRaiz = new FincaRaiz("gods", "1234");

    }

    @Test
    public void metodosPropietario(){
        Usuario usuario = new Usuario(1234, "erik", "erik@", "1234", "3104433", TipoUsuario.PROPIETARIO, "amarillo");
        FincaRaiz fincaRaiz = new FincaRaiz("gods", "1234");
        //Ver propiedades propias
        ArrayList<Propiedad> propiedadesPropietario = fincaRaiz.obtenerPropiedadesPropietario(usuario);

    }

*/

}

