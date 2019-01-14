package controlador;

import bbdd.DAOUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.Usuario;

import java.util.ArrayList;

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
        // Lo mismo que lo explicado abajo, cuando anades un usuario desde el admin, poder cerrar sesion y entrar
        // con el nuevo usuario creado sin tener que cerrar el programa para que se actualice la bbdd
        new ControladorInicio().actualizarUsuarios();
        return b;
    }

    public boolean eliminarUsuario(String nombre) throws BeerBarException {
        boolean b = false;
        if(GestorDeUsuarios.darInstancia().getUsuario(nombre) != null){
            new DAOUsuarios().eliminarUsuario(nombre);
            b = true;
        }
        // Llamo al controlador de inicio para que vuelva a cargar la lista de usuarios una vez borrado porque si no
        // deja borrar el mismo usuario muchas veces aunque en realidad solo se borra una
        new ControladorInicio().actualizarUsuarios();
        return b;
    }

    public boolean cambiarContrasena(String nombre, String nuevaContrasena) throws BeerBarException {
        boolean b = false;
        if(GestorDeUsuarios.darInstancia().getUsuario(nombre) != null){
            new DAOUsuarios().cambiarContrasena(nombre, nuevaContrasena);
            b = true;
        }
        // Lo mismo, actualizar
        new ControladorInicio().actualizarUsuarios();
        return b;
    }

    public ArrayList<Usuario> devuelveUsuarios(){
        new ControladorInicio().actualizarUsuarios();
        ArrayList arr = new DAOUsuarios().devuelveUsuarios();
        return arr;
    }
}
