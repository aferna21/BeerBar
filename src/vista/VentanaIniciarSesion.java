package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaIniciarSesion extends JFrame {

    JPanel panelIniciarSesion;
    JLabel textoUsuario, textoContrasena;
    JTextField campoTextoUsuario, campoTextoContrasena;
    JButton botonIniciarSesion;
    JFrame frameIniciarSesion;

    public VentanaIniciarSesion(){

        frameIniciarSesion = this;

        this.setTitle("Iniciar Sesion");
        this.setSize(new Dimension(600, 400));
        //Poner la ventana en medio de la pantalla
        this.setLocationRelativeTo(null);

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
