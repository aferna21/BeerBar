package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelAnadirUsuario extends JPanel {

    JPanel panelNuevoUsuario;
    JLabel textoNombreNuevo, textoContrasenaNuevo;
    JTextField campoTextoNombreNuevo, campoTextoContrasenaNuevo;
    JButton botonAnadir;

    public JPanelAnadirUsuario(JFrame frameVentanaUsuarios){

        this.setBackground(new Color(128, 128, 128));
        this.setSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());

        panelNuevoUsuario = new JPanel();
        panelNuevoUsuario.setBackground(new Color(128, 128, 128));
        panelNuevoUsuario.setLayout(new BoxLayout(panelNuevoUsuario, BoxLayout.PAGE_AXIS));
        this.add(panelNuevoUsuario);

        textoNombreNuevo = new JLabel("Nombre: ");
        campoTextoNombreNuevo = new JTextField();
        textoContrasenaNuevo = new JLabel("Contrasena: ");
        campoTextoContrasenaNuevo = new JTextField();

        panelNuevoUsuario.add(textoNombreNuevo);
        panelNuevoUsuario.add(campoTextoNombreNuevo);
        panelNuevoUsuario.add(textoContrasenaNuevo);
        panelNuevoUsuario.add(campoTextoContrasenaNuevo);
        this.add(panelNuevoUsuario, BorderLayout.NORTH);

        botonAnadir = new JButton("Anadir nuevo usuario");
        botonAnadir.setBackground(new Color(0, 38, 77));
        botonAnadir.setForeground(Color.WHITE);
        botonAnadir.setOpaque(true);
        botonAnadir.setBorderPainted(false);
        botonAnadir.setPreferredSize(new Dimension(10, 40));
        this.add(botonAnadir, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;
                try {
                    b = new ControladorGestorDeUsuarios().anadirUsuario(campoTextoNombreNuevo.getText(), campoTextoContrasenaNuevo.getText());
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                if(b) {
                    JOptionPane usuarioAnadido = new JOptionPane();
                    usuarioAnadido.showMessageDialog(frameVentanaUsuarios.getContentPane(), "Usuario anadido correctamente");
                }
                else{
                    JOptionPane usuarioAnadido = new JOptionPane();
                    usuarioAnadido.showMessageDialog(frameVentanaUsuarios.getContentPane(), "No se ha podido anadir el usuario porque ya esta en la base de datos.");
                }
            }
        });
    }
}
