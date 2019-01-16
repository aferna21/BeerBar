package controlador;

import bbdd.DAOUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.Usuario;

import java.util.ArrayList;

public class ControladorGestorDeUsuarios {
    private GestorDeUsuarios gestordeusuarios;

    public ControladorGestorDeUsuarios(){
        this.gestordeusuarios = GestorDeUsuarios.darInstancia();
    }

    public boolean autentificar(String nombre, String contrasena){
        return gestordeusuarios.autentificar(nombre, contrasena);
    }

    public boolean existe(String nombre){
        boolean b = false;
        if(gestordeusuarios.getUsuario(nombre) != null){
            b = true;
        }
        return b;
    }

    public boolean anadirUsuario(String nombre, String contrasena) throws BeerBarException {
        boolean b = false;
        if(gestordeusuarios.getUsuario(nombre) == null) {
            new DAOUsuarios().introduceUsuario(nombre, contrasena, false);
            gestordeusuarios.anadirUsuario(nombre, contrasena);
            b = true;
        }
        // Lo mismo que lo explicado abajo, cuando anades un usuario desde el admin, poder cerrar sesion y entrar
        // con el nuevo usuario creado sin tener que cerrar el programa para que se actualice la bbdd
        new ControladorInicio().actualizarInformacion();
        return b;
    }

    public boolean eliminarUsuario(String nombre) throws BeerBarException {
        boolean b = false;
        if(GestorDeUsuarios.darInstancia().getUsuario(nombre) != null){
            new DAOUsuarios().eliminarUsuario(nombre);
            gestordeusuarios.eliminarUsuario(nombre);
            b = true;
        }
        // Llamo al controlador de inicio para que vuelva a cargar la lista de usuarios una vez borrado porque si no
        // deja borrar el mismo usuario muchas veces aunque en realidad solo se borra una
        new ControladorInicio().actualizarInformacion();
        return b;
    }

    public boolean cambiarContrasena(String nombre, String nuevaContrasena) throws BeerBarException {
        boolean b = false;
        if(gestordeusuarios.getUsuario(nombre) != null){
            new DAOUsuarios().cambiarContrasena(nombre, nuevaContrasena);
            gestordeusuarios.setUsuarios(new DAOUsuarios().devuelveUsuarios());
            b = true;
        }
        // Lo mismo, actualizar
        new ControladorInicio().actualizarInformacion();
        GestorDeUsuarios.darInstancia().cambiarContrasena(nombre, nuevaContrasena);
        return b;
    }

    public ArrayList<Usuario> devuelveUsuarios() throws BeerBarException {
        new ControladorInicio().actualizarInformacion();
        ArrayList arr = new DAOUsuarios().devuelveUsuarios();
        return arr;
    }

    public boolean esAdmin(String nombre){
        return GestorDeUsuarios.darInstancia().esAdmin(nombre);
    }
}
