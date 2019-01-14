package controlador;

import bbdd.DAOUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;

public class ControladorGestorDeUsuarios {


    public boolean autentificar(String nombre, String contrasena){
        Boolean b = GestorDeUsuarios.darInstancia().autentificar(nombre, contrasena);
        return b;
    }

    public boolean anadirUsuario(String nombre, String contrasena) throws BeerBarException {
        boolean b = false;
        if(GestorDeUsuarios.darInstancia().getUsuario(nombre) == null) {
            new DAOUsuarios().introduceUsuario(nombre, contrasena, false);
            b = true;
        }
        return b;
    }
}
