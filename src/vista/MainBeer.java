package vista;

import bbdd.Conexion;
import controlador.*;

import java.sql.SQLException;


public class MainBeer {


    public static ControladorUsuario controladorUsuario = new ControladorUsuario();

    public static void main(String[] args) {


        new VentanaBienvenida();
        Conexion c = new Conexion();
        c.abrirConexion();
    }
}
