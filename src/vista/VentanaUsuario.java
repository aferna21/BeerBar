package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUsuario extends JFrame{

    JPanel panelUsuario;
    JButton botonNotas, botonTransacciones;
    JMenuBar barraMenu;
    JMenu ayuda;
    JMenuItem opcionAyuda;
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
        opcionAyuda = new JMenuItem("Ayuda");
        ayuda.add(opcionAyuda);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelUsuario = new JPanel();
        panelUsuario.setLayout(new FlowLayout());

        botonNotas = new JButton("Notas");
        botonTransacciones = new JButton("Transacciones");

        botonNotas.setPreferredSize(new Dimension(140, 80));
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
                new VentanaTransaccionesUsuario(nombreUsuario);
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
