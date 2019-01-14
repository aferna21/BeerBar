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

        if (this.modelo == null || this.ventana == null){
            modelo.escribirNotaA(usuario, texto);
        }else{
            throw new BeerBarException("No ha sido posible enviar la nota.\n");
        }
    }
}
