package com.example.proyectofincaraiz;

//import com.example.proyectofincaraiz.HelloController;
import com.example.proyectofincaraiz.herramienta.ConectorMySQL;
import com.example.proyectofincaraiz.modelos.Usuario;
import com.example.proyectofincaraiz.modelos.enums.TipoUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class RegistroPropietarios implements Initializable {

    //Generamos la conexion
    ConectorMySQL conec = new ConectorMySQL();
    Connection conectar = conec.Conectar();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicializando");

    }
    @FXML
    public TextField txtCedulaBusqueda;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtCedula;
    @FXML
    public TextField txtTelefono;
    @FXML
    public TextField txtCorreo;
    @FXML
    public TextField txtContrasenia;
    @FXML
    public TextField txtsecreta;

    @FXML
    TipoUsuario tipoUser(){
        return TipoUsuario.PROPIETARIO;
    }
    @FXML
    public void botonRegistrar(ActionEvent actionEvent) {
        String cedula=txtCedula.getText();
        String nombre=txtNombre.getText();
        String correo=txtCorreo.getText();
        String contrasenia= txtContrasenia.getText();
        String telefono=txtTelefono.getText();
        TipoUsuario tipo =tipoUser();
        String secreta = txtsecreta.getText();

        Usuario usuario1 =new Usuario(cedula,nombre,correo,contrasenia,telefono,tipo,secreta);

        RegistroPropietarios persona= new RegistroPropietarios();
        boolean x = persona.guardarUsuario(usuario1);

        //Parametros despues que es exitoso bool ,Limpie el menu , y muestre el mesaje de registro completo
        if (x==true){
            System.out.println("Guardado"); // Sea una ventana emergente

            txtCedula.setText("");
            txtNombre.setText("");
            txtContrasenia.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
            txtsecreta.setText("");
        }else {
            System.out.println("Error compruebe los campos"); //Sea ventana emergente
        }
    }


    public boolean guardarUsuario(Usuario usuario1) {
        try {

            String SQL_INSERT = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstm = conectar.prepareStatement(SQL_INSERT);
            pstm.setString(1, usuario1.getId().trim());
            pstm.setString(2, usuario1.getNombre().trim());
            pstm.setString(3, usuario1.getContrasenia().trim());
            pstm.setString(4, usuario1.getCorreo().trim());
            pstm.setString(5, usuario1.getTelefono());
            pstm.setString(6, String.valueOf(usuario1.getTipoUsuario()));
            pstm.setString(7, usuario1.getPalabraSecreta());

            pstm.executeUpdate();

            return true;
        } catch (Exception e) {

            System.err.println("Error al guardar los datos en la BD" + e.getMessage());
            return false;
        }
    }

    public void botonBuscarUsuario(ActionEvent actionEvent) {
        try {
        String SQL_SEARCH = "select * from usuarios where ID =?";

        PreparedStatement pstm = conectar.prepareStatement(SQL_SEARCH);
        pstm.setString(1,txtCedulaBusqueda.getText().trim());

            //Permite saber si se enctraron los datos
            ResultSet rs =pstm.executeQuery();

            if(rs.next()){
                txtNombre.setText(rs.getString("NombreUsuario"));
                txtCedula.setText(rs.getString("ID"));
                txtCorreo.setText(rs.getString("Correo"));
                txtTelefono.setText(rs.getString("Telefono"));
                txtContrasenia.setText("**********");

            }else{
                System.out.println("No se encontro la ID");
            }

        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }

    }
}
