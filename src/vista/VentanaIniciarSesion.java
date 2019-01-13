package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class VentanaIniciarSesion extends JFrame {

    JPanel panelIniciarSesion, panelUsuarioContrasena;
    JLabel textoUsuario, textoContrasena;
    JTextField campoTextoUsuario;
    JPasswordField campoTextoContrasena;
    JButton botonIniciarSesion;
    JFrame frameIniciarSesion;
    JMenuBar barraMenu;
    JMenu ayuda;
    JMenuItem opcionAyuda;

    public VentanaIniciarSesion(){

        frameIniciarSesion = this;

        this.setTitle("Iniciar Sesion");
        this.setSize(new Dimension(600, 400));
        //Poner la ventana en medio de la pantalla
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        ayuda = new JMenu("Ayuda");
        opcionAyuda = new JMenuItem("Ayuda");
        ayuda.add(opcionAyuda);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelIniciarSesion = new JPanel();
        panelIniciarSesion.setLayout(new BorderLayout());
        panelIniciarSesion.setSize(new Dimension(600, 400));
        panelIniciarSesion.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        textoUsuario = new JLabel("Usuario: ");
        textoContrasena = new JLabel("Contrasena: ");
        campoTextoUsuario = new JTextField();
        campoTextoContrasena = new JPasswordField();

        panelUsuarioContrasena = new JPanel();
        panelUsuarioContrasena.setLayout(new BoxLayout(panelUsuarioContrasena, BoxLayout.PAGE_AXIS));
        panelUsuarioContrasena.add(textoUsuario);
        panelUsuarioContrasena.add(campoTextoUsuario);
        panelUsuarioContrasena.add(textoContrasena);
        panelUsuarioContrasena.add(campoTextoContrasena);
        panelIniciarSesion.add(panelUsuarioContrasena, BorderLayout.NORTH);

        botonIniciarSesion = new JButton("Iniciar sesion");
        panelIniciarSesion.add(botonIniciarSesion, BorderLayout.SOUTH);

        this.getContentPane().add(panelIniciarSesion);

        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoTextoUsuario.getText();
                String contrasena = String.valueOf(campoTextoContrasena.getPassword());
                if(usuario.equals("admin") && contrasena.equals("admin")){
                    new VentanaAdministrador();
                }
                else {
                    new VentanaUsuario(campoTextoUsuario.getText());
                }
                frameIniciarSesion.dispatchEvent(new WindowEvent(frameIniciarSesion, WindowEvent.WINDOW_CLOSING));
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameIniciarSesion.getContentPane());
                ayuda.muestraAyudaInicioSesion();
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
