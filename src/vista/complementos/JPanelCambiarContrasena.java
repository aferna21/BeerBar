package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelCambiarContrasena extends JPanel {

    JPanel panelCambiarUsuario;
    JLabel textoNombreAnterior, textoContrasenaModificar;
    JTextField campoTextoNombreCambiar, campoTextoContrasenaModificar;
    JButton botonCambiar;

    public JPanelCambiarContrasena(JFrame frameVentanaUsuarios){

        this.setBackground(new Color(128, 128, 128));
        this.setSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());
        panelCambiarUsuario = new JPanel();
        panelCambiarUsuario.setBackground(new Color(128, 128, 128));
        panelCambiarUsuario.setLayout(new BoxLayout(panelCambiarUsuario, BoxLayout.PAGE_AXIS));
        this.add(panelCambiarUsuario);
        textoNombreAnterior = new JLabel("Nombre usuario: ");
        campoTextoNombreCambiar = new JTextField();
        textoContrasenaModificar = new JLabel("Nueva contrasena: ");
        campoTextoContrasenaModificar = new JTextField();
        panelCambiarUsuario.add(textoNombreAnterior);
        panelCambiarUsuario.add(campoTextoNombreCambiar);
        panelCambiarUsuario.add(textoContrasenaModificar);
        panelCambiarUsuario.add(campoTextoContrasenaModificar);
        this.add(panelCambiarUsuario, BorderLayout.NORTH);
        botonCambiar = new JButton("Cambiar contrasena");
        botonCambiar.setBackground(new Color(0, 38, 77));
        botonCambiar.setForeground(Color.WHITE);
        botonCambiar.setOpaque(true);
        botonCambiar.setBorderPainted(false);
        botonCambiar.setPreferredSize(new Dimension(10, 40));
        this.add(botonCambiar, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;
                try {
                    b = new ControladorGestorDeUsuarios().cambiarContrasena(campoTextoNombreCambiar.getText(), campoTextoContrasenaModificar.getText());
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                if(b) {
                    JOptionPane contrasenaCambiada = new JOptionPane();
                    contrasenaCambiada.showMessageDialog(frameVentanaUsuarios.getContentPane(), "Contrasena cambiada correctamente");
                }
                else{
                    JOptionPane contrasenaCambiada = new JOptionPane();
                    contrasenaCambiada.showMessageDialog(frameVentanaUsuarios.getContentPane(), "No se ha podido cambiar la contrasena porque el usuario no existe en la base de datos.");
                }
            }
        });
    }
}
