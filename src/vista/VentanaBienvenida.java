package vista;

import controlador.ControladorInicio;
import modelo.BeerBarException;

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
        panelBienvenida.setBackground(new Color(128, 128, 128));

        textoBienvenida = new JLabel("Bienvenido a BeerBar");
        textoBienvenida.setBorder(new EmptyBorder(new Insets(0, 80, 0, 0)));
        textoBienvenida.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        panelBienvenida.add(textoBienvenida, BorderLayout.CENTER);

        botonEntrar = new JButton("Entrar");
        botonEntrar.setBackground(new Color(0, 38, 77));
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setOpaque(true);
        botonEntrar.setBorderPainted(false);
        botonEntrar.setPreferredSize(new Dimension(10, 40));
        panelBienvenida.add(botonEntrar, BorderLayout.SOUTH);

        this.getContentPane().add(panelBienvenida);

        botonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crea el usuario admin si no esta, y si esta carga todos los usuarios
                try {
                    new ControladorInicio();
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }

                new VentanaIniciarSesion();
                frameBienvenida.dispose();
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
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
