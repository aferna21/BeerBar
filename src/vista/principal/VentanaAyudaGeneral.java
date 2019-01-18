package vista.principal;

import controlador.ControladorGestorDeUsuarios;
import vista.complementos.JOptionPaneAyuda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAyudaGeneral extends JFrame {

    JPanel panelAyuda;
    JFrame frameAyuda;
    JButton botonBievenida, botonInicioSesion, botonUsuario, botonNotasUsuario,
        botonTransaccionesUsuario, botonAdministrador, botonNotasAdministrador,
        botonTransaccionesAdministrador, botonGestorUsuarios, botonVentanaVerTran2Fechas,
        botonVentanaElegirNota;

    public VentanaAyudaGeneral (){

        frameAyuda = this;

        this.setTitle("Menú de ayuda.");
        this.setSize(new Dimension(800, 450));
        this.setLocationRelativeTo(null);

        panelAyuda = new JPanel();
        panelAyuda.setBackground(new Color(128, 128, 128));
        panelAyuda.setLayout(new FlowLayout());

        botonBievenida = new JButton("Pantalla de bienvenida");
        botonInicioSesion = new JButton("Pantalla de inicio de sesión");
        botonUsuario = new JButton("Pantalla de usuario");
        botonNotasUsuario = new JButton("Pantalla de notas de usuario");
        botonTransaccionesUsuario = new JButton("Pantalla de transacciones usuario");
        botonAdministrador = new JButton("Pantalla de administrador");
        botonNotasAdministrador = new JButton("Pantalla de notas de administrador");
        botonTransaccionesAdministrador = new JButton("Pantalla de transacciones de administrador");
        botonGestorUsuarios = new JButton("Pantalla de gestor de usuarios");
        botonVentanaVerTran2Fechas = new JButton("Pantalla de ver transacciones entre dos fechas");
        botonVentanaElegirNota = new JButton("Pantalla de elegir nota");

        botonBievenida.setBackground(new Color(0, 38, 77));
        botonInicioSesion.setBackground(new Color(0, 38, 77));
        botonUsuario.setBackground(new Color(0, 38, 77));
        botonNotasUsuario.setBackground(new Color(0, 38, 77));
        botonTransaccionesUsuario.setBackground(new Color(0, 38, 77));
        botonAdministrador.setBackground(new Color(0, 38, 77));
        botonNotasAdministrador.setBackground(new Color(0, 38, 77));
        botonTransaccionesAdministrador.setBackground(new Color(0, 38, 77));
        botonGestorUsuarios.setBackground(new Color(0, 38, 77));
        botonVentanaVerTran2Fechas.setBackground(new Color(0, 38, 77));
        botonVentanaElegirNota.setBackground(new Color(0, 38, 77));

        botonBievenida.setForeground(Color.WHITE);
        botonInicioSesion.setForeground(Color.WHITE);
        botonUsuario.setForeground(Color.WHITE);
        botonNotasUsuario.setForeground(Color.WHITE);
        botonTransaccionesUsuario.setForeground(Color.WHITE);
        botonAdministrador.setForeground(Color.WHITE);
        botonNotasAdministrador.setForeground(Color.WHITE);
        botonTransaccionesAdministrador.setForeground(Color.WHITE);
        botonGestorUsuarios.setForeground(Color.WHITE);
        botonVentanaVerTran2Fechas.setForeground(Color.WHITE);
        botonVentanaElegirNota.setForeground(Color.WHITE);

        botonBievenida.setOpaque(true);
        botonInicioSesion.setOpaque(true);
        botonUsuario.setOpaque(true);
        botonNotasUsuario.setOpaque(true);
        botonTransaccionesUsuario.setOpaque(true);
        botonAdministrador.setOpaque(true);
        botonNotasAdministrador.setOpaque(true);
        botonTransaccionesAdministrador.setOpaque(true);
        botonGestorUsuarios.setOpaque(true);
        botonVentanaVerTran2Fechas.setOpaque(true);
        botonVentanaElegirNota.setOpaque(true);

        botonBievenida.setBorderPainted(false);
        botonInicioSesion.setBorderPainted(false);
        botonUsuario.setBorderPainted(false);
        botonNotasUsuario.setBorderPainted(false);
        botonTransaccionesUsuario.setBorderPainted(false);
        botonAdministrador.setBorderPainted(false);
        botonNotasAdministrador.setBorderPainted(false);
        botonTransaccionesAdministrador.setBorderPainted(false);
        botonGestorUsuarios.setBorderPainted(false);
        botonVentanaVerTran2Fechas.setBorderPainted(false);
        botonVentanaElegirNota.setBorderPainted(false);

        botonBievenida.setBorderPainted(false);
        botonInicioSesion.setBorderPainted(false);
        botonUsuario.setBorderPainted(false);
        botonNotasUsuario.setBorderPainted(false);
        botonTransaccionesUsuario.setBorderPainted(false);
        botonAdministrador.setBorderPainted(false);
        botonNotasAdministrador.setBorderPainted(false);
        botonTransaccionesAdministrador.setBorderPainted(false);
        botonGestorUsuarios.setBorderPainted(false);
        botonVentanaVerTran2Fechas.setBorderPainted(false);
        botonVentanaElegirNota.setBorderPainted(false);

        botonBievenida.setPreferredSize(new Dimension(250, 60));
        botonInicioSesion.setPreferredSize(new Dimension(250, 60));
        botonUsuario.setPreferredSize(new Dimension(250, 60));
        botonNotasUsuario.setPreferredSize(new Dimension(250, 60));
        botonTransaccionesUsuario.setPreferredSize(new Dimension(320, 60));
        botonAdministrador.setPreferredSize(new Dimension(250, 60));
        botonNotasAdministrador.setPreferredSize(new Dimension(350, 60));
        botonTransaccionesAdministrador.setPreferredSize(new Dimension(350, 60));
        botonGestorUsuarios.setPreferredSize(new Dimension(330, 60));
        botonVentanaVerTran2Fechas.setPreferredSize(new Dimension(400, 60));
        botonVentanaElegirNota.setPreferredSize(new Dimension(250, 60));

        panelAyuda.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        panelAyuda.add(botonBievenida);
        panelAyuda.add(botonInicioSesion);
        panelAyuda.add(botonUsuario);
        panelAyuda.add(botonNotasUsuario);
        panelAyuda.add(botonTransaccionesUsuario);
        panelAyuda.add(botonAdministrador);
        panelAyuda.add(botonNotasAdministrador);
        panelAyuda.add(botonTransaccionesAdministrador);
        panelAyuda.add(botonGestorUsuarios);
        panelAyuda.add(botonVentanaVerTran2Fechas);
        panelAyuda.add(botonVentanaElegirNota);

        this.getContentPane().add(panelAyuda);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameAyuda.getContentPane());

                if (actionEvent.getSource() == botonBievenida){
                    ayuda.muestraAyudaBienvenida();
                }else if (actionEvent.getSource() == botonBievenida){
                    ayuda.muestraAyudaInicioSesion();
                }else if (actionEvent.getSource() == botonInicioSesion){
                    ayuda.muestraAyudaInicioSesion();
                }else if (actionEvent.getSource() == botonUsuario){
                    ayuda.muestraAyudaUsuario();
                }else if (actionEvent.getSource() == botonNotasUsuario){
                    ayuda.muestraAyudaNotasUsuario();
                }else if (actionEvent.getSource() == botonTransaccionesUsuario){
                    ayuda.muestraAyudaTransaccionesUsuario();
                }else if (actionEvent.getSource() == botonAdministrador){
                    ayuda.muestraAyudaAdministrador();
                }else if (actionEvent.getSource() == botonNotasAdministrador) {
                    ayuda.muestraAyudaNotasAdministrador();
                }else if (actionEvent.getSource() == botonTransaccionesAdministrador) {
                    ayuda.muestraAyudaTransaccionesAdministrador();
                }else if (actionEvent.getSource() == botonGestorUsuarios) {
                    ayuda.muestraAyudaGestorUsuarios();
                }else if (actionEvent.getSource() == botonVentanaVerTran2Fechas) {
                    ayuda.muestraAyudaVentanaVerTransaccionesEntreDosFechas();
                }else if (actionEvent.getSource() == botonVentanaElegirNota) {
                    ayuda.muestraAyudaVentanaElegirNota();
                }
            }
        };

        botonBievenida.addActionListener(actionListener);
        botonInicioSesion.addActionListener(actionListener);
        botonUsuario.addActionListener(actionListener);
        botonNotasUsuario.addActionListener(actionListener);
        botonTransaccionesUsuario.addActionListener(actionListener);
        botonAdministrador.addActionListener(actionListener);
        botonNotasAdministrador.addActionListener(actionListener);
        botonTransaccionesAdministrador.addActionListener(actionListener);
        botonGestorUsuarios.addActionListener(actionListener);
        botonVentanaVerTran2Fechas.addActionListener(actionListener);
        botonVentanaElegirNota.addActionListener(actionListener);

        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}