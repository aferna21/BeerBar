package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        botonNotas.setPreferredSize(new Dimension(140, 80));
        botonTransacciones.setPreferredSize(new Dimension(140, 80));

        panelUsuario.setBorder(new EmptyBorder(new Insets(50, 10, 10, 10)));

        panelUsuario.add(botonNotas);
        panelUsuario.add(botonTransacciones);

        this.getContentPane().add(panelUsuario);

        botonNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaNotasUsuario();
            }
        });

        botonTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaTransaccionesUsuario();
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
