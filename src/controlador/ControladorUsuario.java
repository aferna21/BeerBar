package controlador;

import modelo.GestorDeUsuarios;
import modelo.Usuario;
import modelo.BeerBarException;
import vista.*;

import javax.swing.*;

public class ControladorUsuario {
    private Usuario modelo;
    private JFrame ventana;

    public ControladorUsuario(){

    }

    public void setVentana(JFrame ventana){
        this.ventana = ventana;
    }

    public void enviarNotaA(Usuario usuario, String texto) throws BeerBarException {

        modelo.escribirNotaA(usuario, texto);
    }
}
