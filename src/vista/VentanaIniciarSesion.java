package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class VentanaIniciarSesion extends JFrame {

    JPanel panelIniciarSesion, panelTextos, panelCampos;
    JLabel textoUsuario, textoContrasena;
    JTextField campoTextoUsuario;
    JPasswordField campoTextoContrasena;
    JButton botonIniciarSesion;
    JFrame frameIniciarSesion;

    public VentanaIniciarSesion(){

        frameIniciarSesion = this;

        this.setTitle("Iniciar Sesion");
        this.setSize(new Dimension(600, 400));
        //Poner la ventana en medio de la pantalla
        this.setLocationRelativeTo(null);

        panelIniciarSesion = new JPanel();
        panelIniciarSesion.setLayout(new BorderLayout());
        panelIniciarSesion.setSize(new Dimension(600, 400));
        panelIniciarSesion.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        textoUsuario = new JLabel("Usuario");
        textoUsuario.setBorder(new EmptyBorder(new Insets(80, 10, 0, 10)));
        textoContrasena = new JLabel("Contrasena");
        textoContrasena.setBorder(new EmptyBorder(new Insets(150, 10, 0, 10)));
        campoTextoUsuario = new JTextField();
        campoTextoContrasena = new JPasswordField();

        panelTextos = new JPanel();
        panelTextos.setLayout(new BoxLayout(panelTextos, BoxLayout.PAGE_AXIS));
        panelIniciarSesion.add(panelTextos, BorderLayout.WEST);
        panelTextos.add(textoUsuario);
        panelTextos.add(textoContrasena);

        panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.PAGE_AXIS));
        panelIniciarSesion.add(panelCampos, BorderLayout.CENTER);
        panelCampos.add(campoTextoUsuario);
        panelCampos.add(campoTextoContrasena);

        botonIniciarSesion = new JButton("Iniciar sesion");
        panelIniciarSesion.add(botonIniciarSesion, BorderLayout.SOUTH);

        this.getContentPane().add(panelIniciarSesion);

        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaUsuario();
                frameIniciarSesion.dispatchEvent(new WindowEvent(frameIniciarSesion, WindowEvent.WINDOW_CLOSING));
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
