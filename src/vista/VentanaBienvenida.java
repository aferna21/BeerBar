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

    public VentanaBienvenida(){

        frameBienvenida = this;

        this.setTitle("Bienvenida");
        this.setSize(new Dimension(400, 200));
        //Poner la ventana en el medio de la pantalla
        this.setLocationRelativeTo(null);

        panelBienvenida = new JPanel();
        BorderLayout bl = new BorderLayout();
        panelBienvenida.setLayout(bl);
        panelBienvenida.setSize(new Dimension(400, 200));
        panelBienvenida.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        textoBienvenida = new JLabel("Bienvenido a BeerBar");
        textoBienvenida.setBorder(new EmptyBorder(new Insets(0, 100, 0, 0)));
        panelBienvenida.add(textoBienvenida, BorderLayout.CENTER);

        botonEntrar = new JButton("Entrar");
        botonEntrar.setSize(new Dimension(40, 20));
        panelBienvenida.add(botonEntrar, BorderLayout.SOUTH);

        this.getContentPane().add(panelBienvenida);

        botonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaIniciarSesion();
                frameBienvenida.dispatchEvent(new WindowEvent(frameBienvenida, WindowEvent.WINDOW_CLOSING));
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
