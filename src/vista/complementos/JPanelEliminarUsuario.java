package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import controlador.ControladorInicio;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelEliminarUsuario extends JPanel {

    JPanel panelEliminarUsuario;
    JLabel textoNombreEliminar;
    JTextField campoTextoNombreEliminar;
    JButton botonEliminar;

    public JPanelEliminarUsuario(JFrame frameVentanaUsuarios){

        this.setBackground(new Color(128, 128, 128));
        this.setSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());

        panelEliminarUsuario = new JPanel();
        panelEliminarUsuario.setBackground(new Color(128, 128, 128));
        panelEliminarUsuario.setLayout(new BoxLayout(panelEliminarUsuario, BoxLayout.PAGE_AXIS));
        this.add(panelEliminarUsuario);

        textoNombreEliminar = new JLabel("Nombre: ");
        campoTextoNombreEliminar = new JTextField();
        panelEliminarUsuario.add(textoNombreEliminar);
        panelEliminarUsuario.add(campoTextoNombreEliminar);
        this.add(panelEliminarUsuario, BorderLayout.NORTH);

        botonEliminar = new JButton("Eliminar usuario");
        botonEliminar.setBackground(new Color(0, 38, 77));
        botonEliminar.setForeground(Color.WHITE);
        botonEliminar.setOpaque(true);
        botonEliminar.setBorderPainted(false);
        botonEliminar.setPreferredSize(new Dimension(10, 40));
        this.add(botonEliminar, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean b = false;
                try {
                    b = new ControladorGestorDeUsuarios().eliminarUsuario(campoTextoNombreEliminar.getText());
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                if(b) {
                    JOptionPane usuarioEliminado = new JOptionPane();
                    usuarioEliminado.showMessageDialog(frameVentanaUsuarios.getContentPane(), "Usuario eliminado correctamente");
                }
                else{
                    JOptionPane usuarioEliminado = new JOptionPane();
                    usuarioEliminado.showMessageDialog(frameVentanaUsuarios.getContentPane(), "No se ha podido eliminar el usuario porque no existe en la base de datos.");
                }
            }
        });
    }
}
