package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaUsuario extends JFrame{

    JPanel panelUsuario;

    public VentanaUsuario(){

        this.setTitle("Usuario");
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);

        panelUsuario = new JPanel();

        this.getContentPane().add(panelUsuario);

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
