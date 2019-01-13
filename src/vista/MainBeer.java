package vista;

import bbdd.DAOUsuarios;
import controlador.*;


public class MainBeer {


    public static ControladorUsuario controladorUsuario = new ControladorUsuario();

    public static void main(String[] args) {


        new VentanaBienvenida();

    }
}
