package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        botonNotas.setPreferredSize(new Dimension(160, 80));
        botonTransacciones.setPreferredSize(new Dimension(160, 80));
        botonGestionUsuarios.setPreferredSize(new Dimension(200, 80));

        panelAdministrador.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        panelAdministrador.add(botonNotas);
        panelAdministrador.add(botonTransacciones);
        panelAdministrador.add(botonGestionUsuarios);

        this.getContentPane().add(panelAdministrador);

        botonNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaNotasAdministrador();
            }
        });

        botonTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaTransaccionesAdministrador();
            }
        });

        botonGestionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaGestionUsuarios();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
