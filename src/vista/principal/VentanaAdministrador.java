package vista.principal;

import modelo.BeerBarException;
import vista.complementos.JOptionPaneAyuda;
import vista.complementos.VentanaElegirJornada;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame {

    JPanel panelAdministrador;
    JButton botonNotas, botonTransacciones, botonGestionUsuarios;
    JMenuBar barraMenu;
    JMenu ayuda, menu, copiaSeguridad;
    JMenuItem opcionAyuda, opcionCerrarsesion, opcionGuardar, opcionCargar;
    JFrame frameAdministrador;

    public VentanaAdministrador(String nombreUsuario){

        frameAdministrador = this;

        this.setTitle("Administrador");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        ayuda = new JMenu("Ayuda");
        menu = new JMenu("Menu");
        copiaSeguridad = new JMenu("Copia de seguridad");
        opcionAyuda = new JMenuItem("Ayuda");
        opcionCerrarsesion = new JMenuItem("Cerrar sesion");
        opcionGuardar = new JMenuItem("Guardar una copia de seguridad");
        opcionCargar = new JMenuItem("Cargar una copiad de seguridad");
        ayuda.add(opcionAyuda);
        menu.add(opcionCerrarsesion);
        copiaSeguridad.add(opcionGuardar);
        copiaSeguridad.add(opcionCargar);
        barraMenu.add(menu);
        barraMenu.add(ayuda);
        barraMenu.add(copiaSeguridad);
        this.setJMenuBar(barraMenu);

        panelAdministrador = new JPanel();
        panelAdministrador.setBackground(new Color(128, 128, 128));
        panelAdministrador.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonNotas.setBackground(new Color(0, 38, 77));
        botonNotas.setForeground(Color.WHITE);
        botonNotas.setOpaque(true);
        botonNotas.setBorderPainted(false);
        botonNotas.setPreferredSize(new Dimension(160, 60));

        botonTransacciones = new JButton("Transacciones");
        botonTransacciones.setBackground(new Color(0, 38, 77));
        botonTransacciones.setForeground(Color.WHITE);
        botonTransacciones.setOpaque(true);
        botonTransacciones.setBorderPainted(false);
        botonTransacciones.setPreferredSize(new Dimension(160, 60));

        botonGestionUsuarios = new JButton("Gestion de usuarios");
        botonGestionUsuarios.setBackground(new Color(0, 38, 77));
        botonGestionUsuarios.setForeground(Color.WHITE);
        botonGestionUsuarios.setOpaque(true);
        botonGestionUsuarios.setBorderPainted(false);
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
                new VentanaElegirJornada(nombreUsuario);
            }
        });

        botonGestionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaGestionUsuarios();
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
            }
        });

        opcionCerrarsesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameAdministrador.dispose();
                new VentanaIniciarSesion();
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
