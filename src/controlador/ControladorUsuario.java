package controlador;

import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.Usuario;

public class ControladorUsuario {
    private Usuario usuario;

    public ControladorUsuario(String nombre){
        this.usuario = GestorDeUsuarios.darInstancia().getUsuario(nombre);
    }

    public Usuario devuelveUsuario(){
        return usuario;
    }

}
