package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class VentanaBienvenida extends JFrame{

    JPanel panelBienvenida;
    JLabel textoBienvenida;
    JButton botonEntrar;
    JFrame frameBienvenida;
    JMenuBar barraMenu;
    JMenu ayuda;
    JMenuItem opcionAyuda;

    public VentanaBienvenida(){

        frameBienvenida = this;

        this.setTitle("Bienvenida");
        this.setSize(new Dimension(400, 200));
        //Poner la ventana en el medio de la pantalla
        this.setLocationRelativeTo(null);

        barraMenu = new JMenuBar();
        ayuda = new JMenu("Ayuda");
        opcionAyuda = new JMenuItem("Ayuda");
        ayuda.add(opcionAyuda);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelBienvenida = new JPanel();
        panelBienvenida.setLayout(new BorderLayout());
        panelBienvenida.setSize(new Dimension(400, 200));
        panelBienvenida.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        textoBienvenida = new JLabel("Bienvenido a BeerBar");
        textoBienvenida.setBorder(new EmptyBorder(new Insets(0, 100, 0, 0)));
        panelBienvenida.add(textoBienvenida, BorderLayout.CENTER);

        botonEntrar = new JButton("Entrar");
        panelBienvenida.add(botonEntrar, BorderLayout.SOUTH);

        this.getContentPane().add(panelBienvenida);

        botonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaIniciarSesion();
                frameBienvenida.dispatchEvent(new WindowEvent(frameBienvenida, WindowEvent.WINDOW_CLOSING));
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameBienvenida.getContentPane());
                ayuda.muestraAyudaBienvenida();
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
