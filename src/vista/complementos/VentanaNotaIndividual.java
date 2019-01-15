package vista.complementos;

import modelo.Nota;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotaIndividual extends JFrame {

    JPanel panelVentanaNota, panelRemitente, panelTextoNota, panelBotones;
    JFrame frameVentanaNota;
    JLabel textoRemitente, textoDestinatario, textoFecha, textoMensaje, textoNota;
    JButton botonMadre, botonResponder, botonHija;

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

        textoRemitente = new JLabel("Remitente: " + nota.getRemitente().toString());
        textoDestinatario = new JLabel("Destinatario: " + nota.getDestinatario().toString());
        textoFecha = new JLabel("Fecha: " + nota.getFecha().toString());
        textoMensaje = new JLabel("Mensaje: ");
        panelRemitente.add(textoRemitente);
        panelRemitente.add(textoDestinatario);
        panelRemitente.add(textoFecha);
        panelRemitente.add(textoMensaje);

        panelTextoNota = new JPanel();
        panelVentanaNota.add(panelTextoNota, BorderLayout.CENTER);

        textoNota = new JLabel(nota.getTexto());
        panelTextoNota.add(textoNota);

        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        panelVentanaNota.add(panelBotones, BorderLayout.SOUTH);

       botonMadre = new JButton("Ir a la madre");
        botonMadre.setBackground(new Color(0, 38, 77));
        botonMadre.setForeground(Color.WHITE);
        botonMadre.setOpaque(true);
        botonMadre.setBorderPainted(false);
        botonMadre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                //Cargar la nota madre a partir de ControladorServidorNotas a raiz del numero de madre

                /*if(nota.getMadre() != 0) {
                    new VentanaNotaIndividual(nota.getMadre());
                }
                else{
                    JOptionPane panelNoExisteMadre = new JOptionPane();
                    panelNoExisteMadre.showMessageDialog(frameVentanaNota.getContentPane(), "Esta nota no tiene madre");
                }*/
            }
        });

        botonResponder = new JButton("Responder");
        botonResponder.setBackground(new Color(0, 38, 77));
        botonResponder.setForeground(Color.WHITE);
        botonResponder.setOpaque(true);
        botonResponder.setBorderPainted(false);
        botonResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO

            }
        });

        botonHija = new JButton("Ir a la hija");
        botonHija.setBackground(new Color(0, 38, 77));
        botonHija.setForeground(Color.WHITE);
        botonHija.setOpaque(true);
        botonHija.setBorderPainted(false);
        botonHija.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                //Cargar la nota hija a partir de ControladorServidorNotas a raiz del numero de hija

                /*if(nota.getHija() != 0) {
                    new VentanaNotaIndividual(nota.getHija());
                }
                else{
                    JOptionPane panelNoExisteHija = new JOptionPane();
                    panelNoExisteHija.showMessageDialog(frameVentanaNota.getContentPane(), "Esta nota no tiene hija");
                }*/
            }
        });

        panelBotones.add(botonMadre);
        panelBotones.add(botonResponder);
        panelBotones.add(botonHija);
        panelVentanaNota.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        this.getContentPane().add(panelVentanaNota);

        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
