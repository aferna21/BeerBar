package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame {

    JPanel panelAdministrador;
    JButton botonNotas, botonTransacciones, botonGestionUsuarios;
    JMenuBar barraMenu;
    JMenu menu;
    JMenuItem opcionAyuda;
    JFrame frameAdministrador;

    public VentanaAdministrador(){

        frameAdministrador = this;

        this.setTitle("Administrador");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        opcionAyuda = new JMenuItem("Ayuda");
        menu.add(opcionAyuda);
        barraMenu.add(menu);
        this.setJMenuBar(barraMenu);

        panelAdministrador = new JPanel();
        panelAdministrador.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonTransacciones = new JButton("Transacciones");
        botonGestionUsuarios = new JButton("Gestion de usuarios");

        botonNotas.setPreferredSize(new Dimension(160, 60));
        botonTransacciones.setPreferredSize(new Dimension(160, 60));
        botonGestionUsuarios.setPreferredSize(new Dimension(200, 60));

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

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameAdministrador.getContentPane());
                ayuda.muestraAyudaAdministrador();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
