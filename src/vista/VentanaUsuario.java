package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuario extends JFrame{

    JPanel panelUsuario;
    JButton botonNotas, botonTransacciones;

    public VentanaUsuario(){

        this.setTitle("Usuario");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);

        panelUsuario = new JPanel();
        panelUsuario.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonTransacciones = new JButton("Transacciones");

        panelUsuario.add(botonNotas);
        panelUsuario.add(botonTransacciones);

        this.getContentPane().add(panelUsuario);

        botonNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaNotasUsuario();
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
