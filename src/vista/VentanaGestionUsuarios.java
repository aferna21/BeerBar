package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionUsuarios extends JFrame {

    JPanel panelUsuarios, panelAnadir, panelEliminar, panelVer;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionAnadir, opcionEliminar, opcionVer, opcionAyuda;
    JFrame frameVentanaUsuarios;

    public VentanaGestionUsuarios(){

        frameVentanaUsuarios = this;

        this.setTitle("Gestion de usuarios");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Menu");
        ayuda = new JMenu("Ayuda");
        opcionAnadir = new JMenuItem("Anadir a un usuario");
        opcionEliminar = new JMenuItem("Eliminar a un usuario");
        opcionVer = new JMenuItem("Ver los usuarios del sistema");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionAnadir);
        acciones.add(opcionEliminar);
        acciones.add(opcionVer);
        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelUsuarios = new JPanel();
        panelUsuarios.setLayout(new BorderLayout());
        JLabel textoGestor = new JLabel("Ventana de gestion de usuarios");
        panelUsuarios.add(textoGestor, BorderLayout.CENTER);
        panelUsuarios.setBorder(new EmptyBorder(new Insets(0, 260, 0, 0)));
        this.getContentPane().add(panelUsuarios);


        //ANADIR USUARIO
        panelAnadir = new JPanel();
        panelAnadir.setSize(new Dimension(800, 600));
        panelAnadir.setLayout(new BorderLayout());
        JPanel panelNuevoUsuario = new JPanel();
        panelNuevoUsuario.setLayout(new BoxLayout(panelNuevoUsuario, BoxLayout.PAGE_AXIS));
        panelAnadir.add(panelNuevoUsuario);
        JLabel textoNombreNuevo = new JLabel("Nombre: ");
        JTextField campoTextoNombreNuevo = new JTextField();
        JLabel textoContrasenaNuevo = new JLabel("Contrasena: ");
        JTextField campoTextoContrasenaNuevo = new JTextField();
        panelNuevoUsuario.add(textoNombreNuevo);
        panelNuevoUsuario.add(campoTextoNombreNuevo);
        panelNuevoUsuario.add(textoContrasenaNuevo);
        panelNuevoUsuario.add(campoTextoContrasenaNuevo);
        panelAnadir.add(panelNuevoUsuario, BorderLayout.NORTH);
        JButton botonAnadir = new JButton("Anadir nuevo usuario");
        panelAnadir.add(botonAnadir, BorderLayout.SOUTH);
        panelAnadir.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));


        //ELIMINAR USUARIO
        panelEliminar = new JPanel();
        panelEliminar.setSize(new Dimension(800, 600));
        panelEliminar.setLayout(new BorderLayout());
        JPanel panelEliminarUsuario = new JPanel();
        panelEliminarUsuario.setLayout(new BoxLayout(panelEliminarUsuario, BoxLayout.PAGE_AXIS));
        panelEliminar.add(panelEliminarUsuario);
        JLabel textoNombreEliminar = new JLabel("Nombre: ");
        JTextField campoTextoNombreEliminar = new JTextField();
        JLabel textoContrasenaEliminar = new JLabel("Contrasena: ");
        JTextField campoTextoContrasenaEliminar = new JTextField();
        panelEliminarUsuario.add(textoNombreEliminar);
        panelEliminarUsuario.add(campoTextoNombreEliminar);
        panelEliminarUsuario.add(textoContrasenaEliminar);
        panelEliminarUsuario.add(campoTextoContrasenaEliminar);
        panelEliminar.add(panelEliminarUsuario, BorderLayout.NORTH);
        JButton botonEliminar = new JButton("Eliminar usuario");
        panelEliminar.add(botonEliminar, BorderLayout.SOUTH);
        panelEliminar.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));


        //VER USUARIOS
        panelVer = new JPanel();
        panelVer.setSize(new Dimension(800, 600));
        panelVer.setLayout(new BorderLayout());
        JPanel panelDentroScrollUsuarios = new JPanel();
        panelDentroScrollUsuarios.setLayout(new BoxLayout(panelDentroScrollUsuarios, BoxLayout.PAGE_AXIS));
        panelDentroScrollUsuarios.setBorder(new EmptyBorder(new Insets(10, 10, 10,10)));
        JScrollPane panelScrollUsuarios = new JScrollPane(panelDentroScrollUsuarios);
        panelScrollUsuarios.getVerticalScrollBar().setUnitIncrement(40);
        panelVer.add(panelScrollUsuarios, BorderLayout.CENTER);
        panelDentroScrollUsuarios.setBackground(Color.BLACK);

        panelDentroScrollUsuarios.add(new JTextAreaUsuarios("Felipe", "Tortilluca32"));
        panelDentroScrollUsuarios.add(new JTextAreaUsuarios("Adri Rastas", "Cafetito54"));
        panelDentroScrollUsuarios.add(new JTextAreaUsuarios("Adri Delegado", "Evaristo87"));


        opcionAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaUsuarios.getContentPane().removeAll();
                frameVentanaUsuarios.getContentPane().repaint();
                frameVentanaUsuarios.getContentPane().revalidate();
                frameVentanaUsuarios.getContentPane().add(panelAnadir);
                frameVentanaUsuarios.setVisible(true);
            }
        });

        opcionEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaUsuarios.getContentPane().removeAll();
                frameVentanaUsuarios.getContentPane().repaint();
                frameVentanaUsuarios.getContentPane().revalidate();
                frameVentanaUsuarios.getContentPane().add(panelEliminar);
                frameVentanaUsuarios.setVisible(true);
            }
        });

        opcionVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaUsuarios.getContentPane().removeAll();
                frameVentanaUsuarios.getContentPane().repaint();
                frameVentanaUsuarios.getContentPane().revalidate();
                frameVentanaUsuarios.getContentPane().add(panelVer);
                frameVentanaUsuarios.setVisible(true);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaUsuarios.getContentPane());
                ayuda.muestraAyudaGestorUsuarios();
            }
        });

        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
