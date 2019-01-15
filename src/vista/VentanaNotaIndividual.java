package vista;

import modelo.Nota;
import modelo.ServidorDeMensajeria;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotaIndividual extends JFrame {

    JPanel panelVentanaNota, panelRemitente, panelTextoNota, panelBotones;
    JFrame frameVentanaNota;

    public VentanaNotaIndividual(Nota nota){

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
        JLabel textoRemitente = new JLabel("Remitente: " + nota.getRemitente().toString());
        JLabel textoDestinatario = new JLabel("Destinatario: " + nota.getDestinatario().toString());
        JLabel textoFecha = new JLabel("Fecha: " + nota.getFecha().toString());
        JLabel textoMensaje = new JLabel("Mensaje: ");
        panelRemitente.add(textoRemitente);
        panelRemitente.add(textoDestinatario);
        panelRemitente.add(textoFecha);
        panelRemitente.add(textoMensaje);
        panelTextoNota = new JPanel();
        panelVentanaNota.add(panelTextoNota, BorderLayout.CENTER);
        JLabel textoNota = new JLabel(nota.getTexto());
        panelTextoNota.add(textoNota);
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelVentanaNota.add(panelBotones, BorderLayout.SOUTH);

        JButton botonMadre = new JButton("Ir a la madre");
        botonMadre.setBackground(new Color(0, 38, 77));
        botonMadre.setForeground(Color.WHITE);
        botonMadre.setOpaque(true);
        botonMadre.setBorderPainted(false);
        botonMadre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nota.getMadre() != null) {
                    new VentanaNotaIndividual(nota.getMadre());
                }
                else{
                    JOptionPane panelNoExisteMadre = new JOptionPane();
                    panelNoExisteMadre.showMessageDialog(frameVentanaNota.getContentPane(), "Esta nota no tiene madre");
                }
            }
        });

        JButton botonResponder = new JButton("Responder");
        botonResponder.setBackground(new Color(0, 38, 77));
        botonResponder.setForeground(Color.WHITE);
        botonResponder.setOpaque(true);
        botonResponder.setBorderPainted(false);
        botonResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton botonHija = new JButton("Ir a la hija");
        botonHija.setBackground(new Color(0, 38, 77));
        botonHija.setForeground(Color.WHITE);
        botonHija.setOpaque(true);
        botonHija.setBorderPainted(false);
        botonHija.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nota.getHija() != null) {
                    new VentanaNotaIndividual(nota.getHija());
                }
                else{
                    JOptionPane panelNoExisteMadre = new JOptionPane();
                    panelNoExisteMadre.showMessageDialog(frameVentanaNota.getContentPane(), "Esta nota no tiene hija");
                }
            }
        });

        panelBotones.add(botonMadre);
        panelBotones.add(botonHija);
        panelBotones.add(botonResponder);
        panelVentanaNota.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        this.getContentPane().add(panelVentanaNota);

        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
