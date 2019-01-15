package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaNotaIndividual extends JFrame {

    JPanel panelVentanaNota, panelRemitente, panelTextoNota, panelBotones;
    JFrame frameVentanaNota;

    public VentanaNotaIndividual(){

        frameVentanaNota = this;

        this.setTitle("Nota individual");
        this.setSize(new Dimension(600, 400));

        panelVentanaNota = new JPanel();
        panelVentanaNota.setBackground(new Color(128, 128, 128));
        panelVentanaNota.setSize(600, 400);
        panelVentanaNota.setLayout(new BorderLayout());
        panelRemitente = new JPanel();
        panelRemitente.setBackground(new Color(128, 128, 128));
        panelRemitente.setLayout(new BoxLayout(panelRemitente, BoxLayout.PAGE_AXIS));
        panelVentanaNota.add(panelRemitente, BorderLayout.NORTH);
        JLabel textoRemitente = new JLabel("Remitente: Tupu");
        JLabel textoFecha = new JLabel("Fecha: 1 de Enero de 2019");
        panelRemitente.add(textoRemitente);
        panelRemitente.add(textoFecha);
        panelTextoNota = new JPanel();
        panelVentanaNota.add(panelTextoNota, BorderLayout.CENTER);
        JLabel textoNota = new JLabel("ME CAGO EN MIS MUELAS");
        panelTextoNota.add(textoNota);
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelVentanaNota.add(panelBotones, BorderLayout.SOUTH);
        JButton botonMadre = new JButton("Ir a la madre");
        botonMadre.setBackground(new Color(0, 38, 77));
        botonMadre.setForeground(Color.WHITE);
        botonMadre.setOpaque(true);
        botonMadre.setBorderPainted(false);
        //botonMadre.setPreferredSize(new Dimension(10, 40));
        JButton botonHija = new JButton("Ir a la hija");
        botonHija.setBackground(new Color(0, 38, 77));
        botonHija.setForeground(Color.WHITE);
        botonHija.setOpaque(true);
        botonHija.setBorderPainted(false);
        //botonHija.setPreferredSize(new Dimension(10, 40));
        panelBotones.add(botonMadre);
        panelBotones.add(botonHija);
        panelVentanaNota.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        this.getContentPane().add(panelVentanaNota);

        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
