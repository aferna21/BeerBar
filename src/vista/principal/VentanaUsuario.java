package vista.principal;

import vista.complementos.JOptionPaneAyuda;
import vista.complementos.VentanaElegirJornada;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuario extends JFrame{

    JPanel panelUsuario;
    JButton botonNotas, botonTransacciones;
    JMenuBar barraMenu;
    JMenu ayuda, menu;
    JMenuItem opcionAyuda, opcionCerrarSesion;
    JFrame frameUsuario;
    String nombreUsuario;

    public VentanaUsuario(String nombreUsuario){

        frameUsuario = this;
        this.nombreUsuario = nombreUsuario;

        this.setTitle("Pantalla de " + this.nombreUsuario);
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        ayuda = new JMenu("Ayuda");
        menu = new JMenu("Menu");
        opcionAyuda = new JMenuItem("Ayuda");
        opcionCerrarSesion = new JMenuItem("Cerrar sesion");
        ayuda.add(opcionAyuda);
        menu.add(opcionCerrarSesion);
        barraMenu.add(menu);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelUsuario = new JPanel();
        panelUsuario.setBackground(new Color(128, 128, 128));
        panelUsuario.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonNotas.setBackground(new Color(0, 38, 77));
        botonNotas.setForeground(Color.WHITE);
        botonNotas.setOpaque(true);
        botonNotas.setBorderPainted(false);
        botonNotas.setPreferredSize(new Dimension(140, 80));

        botonTransacciones = new JButton("Transacciones");
        botonTransacciones.setBackground(new Color(0, 38, 77));
        botonTransacciones.setForeground(Color.WHITE);
        botonTransacciones.setOpaque(true);
        botonTransacciones.setBorderPainted(false);
        botonTransacciones.setPreferredSize(new Dimension(140, 80));

        panelUsuario.setBorder(new EmptyBorder(new Insets(50, 10, 10, 10)));
        panelUsuario.add(botonNotas);
        panelUsuario.add(botonTransacciones);

        this.getContentPane().add(panelUsuario);

        botonNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaNotasUsuario(nombreUsuario);
            }
        });

        botonTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaElegirJornada();
            }
        });

        opcionCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameUsuario.dispose();
                new VentanaIniciarSesion();
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameUsuario.getContentPane());
                ayuda.muestraAyudaUsuario();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
