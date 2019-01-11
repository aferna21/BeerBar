package controlador;

import modelo.BeerBarException;
import modelo.GestorDeUsuarios;

public class ControladorGestorDeUsuarios {
    private GestorDeUsuarios usuarios;


    public ControladorGestorDeUsuarios() throws BeerBarException {
        usuarios = GestorDeUsuarios.darInstancia();
        usuarios.anadirUsuario("Adri", "123");
    }

    public boolean autenticar(String nombre, String contrasena){
        return usuarios.autentificar(nombre, contrasena);
    }
}
