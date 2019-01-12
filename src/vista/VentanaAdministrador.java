package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAdministrador extends JFrame {

    JPanel panelAdministrador;
    JButton botonNotas, botonTransacciones, botonGestionUsuarios;

    public VentanaAdministrador(){

        this.setTitle("Administrador");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);

        panelAdministrador = new JPanel();
        panelAdministrador.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonTransacciones = new JButton("Transacciones");
        botonGestionUsuarios = new JButton("Gestion de usuarios");

        panelAdministrador.add(botonNotas);
        panelAdministrador.add(botonTransacciones);
        panelAdministrador.add(botonGestionUsuarios);

        this.getContentPane().add(panelAdministrador);

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
