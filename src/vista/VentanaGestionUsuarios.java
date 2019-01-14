package vista;

import controlador.ControladorGestorDeUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionUsuarios extends JFrame {

    JPanel panelUsuarios, panelAnadir, panelEliminar, panelModificar, panelVer;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionAnadir, opcionEliminar, opcionVer, opcionModificar, opcionAyuda;
    JFrame frameVentanaUsuarios;
    ControladorGestorDeUsuarios controladorGestorDeUsuarios = new ControladorGestorDeUsuarios();

    public VentanaGestionUsuarios(){

        frameVentanaUsuarios = this;

        this.setTitle("Gestion de usuarios");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Menu");
        ayuda = new JMenu("Ayuda");
        opcionAnadir = new JMenuItem("Anadir a un usuario");
        opcionEliminar = new JMenuItem("Eliminar a un usuario");
        opcionModificar = new JMenuItem("Modificar un usuario");
        opcionVer = new JMenuItem("Ver los usuarios del sistema");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionAnadir);
        acciones.add(opcionEliminar);
        acciones.add(opcionModificar);
        acciones.add(opcionVer);
        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelUsuarios = new JPanel();
        panelUsuarios.setBackground(new Color(128, 128, 128));
        panelUsuarios.setLayout(new BorderLayout());
        JLabel textoGestor = new JLabel("Ventana de gestion de usuarios");
        panelUsuarios.add(textoGestor, BorderLayout.CENTER);
        panelUsuarios.setBorder(new EmptyBorder(new Insets(0, 260, 0, 0)));
        this.getContentPane().add(panelUsuarios);


        //ANADIR USUARIO
        panelAnadir = new JPanel();
        panelAnadir.setBackground(new Color(128, 128, 128));
        panelAnadir.setSize(new Dimension(800, 600));
        panelAnadir.setLayout(new BorderLayout());
        JPanel panelNuevoUsuario = new JPanel();
        panelNuevoUsuario.setBackground(new Color(128, 128, 128));
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
        botonAnadir.setBackground(new Color(0, 38, 77));
        botonAnadir.setForeground(Color.WHITE);
        botonAnadir.setOpaque(true);
        botonAnadir.setBorderPainted(false);
        botonAnadir.setPreferredSize(new Dimension(10, 40));
        panelAnadir.add(botonAnadir, BorderLayout.SOUTH);
        panelAnadir.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;
                try {
                    b = controladorGestorDeUsuarios.anadirUsuario(campoTextoNombreNuevo.getText(), campoTextoContrasenaNuevo.getText());
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                if(b) {
                    frameVentanaUsuarios.getContentPane().removeAll();
                    frameVentanaUsuarios.getContentPane().repaint();
                    frameVentanaUsuarios.getContentPane().revalidate();
                    frameVentanaUsuarios.getContentPane().add(panelUsuarios);
                    frameVentanaUsuarios.setVisible(true);

                    JOptionPane usuarioAnadido = new JOptionPane();
                    usuarioAnadido.showMessageDialog(frameVentanaUsuarios.getContentPane(), "Usuario anadido correctamente");
                }
                else{
                    JOptionPane usuarioAnadido = new JOptionPane();
                    usuarioAnadido.showMessageDialog(frameVentanaUsuarios.getContentPane(), "No se ha podido anadir el usuario porque ya esta en la base de datos.");
                }
            }
        });


        //ELIMINAR USUARIO
        panelEliminar = new JPanel();
        panelEliminar.setBackground(new Color(128, 128, 128));
        panelEliminar.setSize(new Dimension(800, 600));
        panelEliminar.setLayout(new BorderLayout());
        JPanel panelEliminarUsuario = new JPanel();
        panelEliminarUsuario.setBackground(new Color(128, 128, 128));
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
        botonEliminar.setBackground(new Color(0, 38, 77));
        botonEliminar.setForeground(Color.WHITE);
        botonEliminar.setOpaque(true);
        botonEliminar.setBorderPainted(false);
        botonEliminar.setPreferredSize(new Dimension(10, 40));
        panelEliminar.add(botonEliminar, BorderLayout.SOUTH);
        panelEliminar.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));


        //MODIFICAR USUARIO
        panelModificar = new JPanel();
        panelModificar.setBackground(new Color(128, 128, 128));
        panelModificar.setSize(new Dimension(800, 600));
        panelModificar.setLayout(new BorderLayout());
        JPanel panelModificarUsuario = new JPanel();
        panelModificarUsuario.setBackground(new Color(128, 128, 128));
        panelModificarUsuario.setLayout(new BoxLayout(panelModificarUsuario, BoxLayout.PAGE_AXIS));
        panelModificar.add(panelModificarUsuario);
        JLabel textoNombreAnterior = new JLabel("Nombre usuario: ");
        JTextField campoTextoNombreAnterior = new JTextField();
        JLabel textoNombreModificar = new JLabel("Nuevo nombre: ");
        JTextField campoTextoNombreModificar = new JTextField();
        JLabel textoContrasenaModificar = new JLabel("Nueva contrasena: ");
        JTextField campoTextoContrasenaModificar = new JTextField();
        panelModificarUsuario.add(textoNombreAnterior);
        panelModificarUsuario.add(campoTextoNombreAnterior);
        panelModificarUsuario.add(textoNombreModificar);
        panelModificarUsuario.add(campoTextoNombreModificar);
        panelModificarUsuario.add(textoContrasenaModificar);
        panelModificarUsuario.add(campoTextoContrasenaModificar);
        panelModificar.add(panelModificarUsuario, BorderLayout.NORTH);
        JButton botonModificar = new JButton("Modificar usuario");
        botonModificar.setBackground(new Color(0, 38, 77));
        botonModificar.setForeground(Color.WHITE);
        botonModificar.setOpaque(true);
        botonModificar.setBorderPainted(false);
        botonModificar.setPreferredSize(new Dimension(10, 40));
        panelModificar.add(botonModificar, BorderLayout.SOUTH);
        panelModificar.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));


        //VER USUARIOS
        panelVer = new JPanel();
        panelVer.setBackground(new Color(128, 128, 128));
        panelVer.setSize(new Dimension(800, 600));
        panelVer.setLayout(new BorderLayout());
        JPanel panelDentroScrollUsuarios = new JPanel();
        panelDentroScrollUsuarios.setLayout(new BoxLayout(panelDentroScrollUsuarios, BoxLayout.PAGE_AXIS));
        panelDentroScrollUsuarios.setBorder(new EmptyBorder(new Insets(10, 10, 10,10)));
        JScrollPane panelScrollUsuarios = new JScrollPane(panelDentroScrollUsuarios);
        panelScrollUsuarios.getVerticalScrollBar().setUnitIncrement(40);
        panelVer.add(panelScrollUsuarios, BorderLayout.CENTER);
        panelDentroScrollUsuarios.setBackground(new Color(128, 128, 128));

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

        opcionModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaUsuarios.getContentPane().removeAll();
                frameVentanaUsuarios.getContentPane().repaint();
                frameVentanaUsuarios.getContentPane().revalidate();
                frameVentanaUsuarios.getContentPane().add(panelModificar);
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
