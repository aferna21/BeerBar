package vista.principal;

import modelo.BeerBarException;
import vista.complementos.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionUsuarios extends JFrame {

    JPanel panelUsuarios, panelAnadir, panelEliminar, panelCambiar, panelVer;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionAnadir, opcionEliminar, opcionVer, opcionCambiar, opcionAyuda, opcionAyudaGeneral;
    JFrame frameVentanaUsuarios;
    JLabel textoGestor;

    public VentanaGestionUsuarios() throws BeerBarException {

        frameVentanaUsuarios = this;

        this.setTitle("Gestion de usuarios");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Menu");
        ayuda = new JMenu("Ayuda");
        opcionAnadir = new JMenuItem("Anadir a un usuario");
        opcionEliminar = new JMenuItem("Eliminar a un usuario");
        opcionCambiar = new JMenuItem("Cambiar contrasena un usuario");
        opcionVer = new JMenuItem("Ver los usuarios del sistema");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionAnadir);
        acciones.add(opcionEliminar);
        acciones.add(opcionCambiar);
        acciones.add(opcionVer);
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelUsuarios = new JPanel();
        panelUsuarios.setBackground(new Color(128, 128, 128));
        panelUsuarios.setLayout(new BorderLayout());

        textoGestor = new JLabel("Ventana de gestion de usuarios");
        panelUsuarios.add(textoGestor, BorderLayout.CENTER);
        panelUsuarios.setBorder(new EmptyBorder(new Insets(0, 260, 0, 0)));
        this.getContentPane().add(panelUsuarios);


        opcionAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelAnadir = new JPanelAnadirUsuario(frameVentanaUsuarios);
                actualizarPanel(panelAnadir);
            }
        });


        opcionEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEliminar = new JPanelEliminarUsuario(frameVentanaUsuarios);
                actualizarPanel(panelEliminar);
            }
        });


        opcionCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCambiar = new JPanelCambiarContrasena(frameVentanaUsuarios);
                actualizarPanel(panelCambiar);
            }
        });


        opcionVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panelVer = new JPanelVerUsuarios();
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                actualizarPanel(panelVer);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaUsuarios.getContentPane());
                ayuda.muestraAyudaGestorUsuarios();
            }
        });

        opcionAyudaGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAyudaGeneral();
            }
        });


        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }


    public void actualizarPanel(JPanel panelNuevo){
        frameVentanaUsuarios.getContentPane().removeAll();
        frameVentanaUsuarios.getContentPane().repaint();
        frameVentanaUsuarios.getContentPane().revalidate();
        frameVentanaUsuarios.getContentPane().add(panelNuevo);
        frameVentanaUsuarios.setVisible(true);
    }
}
