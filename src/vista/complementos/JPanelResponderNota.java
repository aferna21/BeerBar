package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import controlador.ControladorServidorDeMensajeria;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelResponderNota extends JPanel {

    JPanel panelDestinatario;
    JLabel textoMensaje;
    JTextArea campoMensaje;

    public JPanelResponderNota(String remitente, String destinatario, JFrame frame, int madre) {

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelDestinatario = new JPanel();
        panelDestinatario.setBackground(new Color(128, 128, 128));
        panelDestinatario.setLayout(new BoxLayout(panelDestinatario, BoxLayout.PAGE_AXIS));

        textoMensaje = new JLabel("Mensaje");

        panelDestinatario.add(textoMensaje);
        this.add(panelDestinatario, BorderLayout.NORTH);

        campoMensaje = new JTextArea();
        this.add(campoMensaje, BorderLayout.CENTER);

        JButton botonEnviar = new JButton("Enviar");
        botonEnviar.setBackground(new Color(0, 38, 77));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setOpaque(true);
        botonEnviar.setBorderPainted(false);
        botonEnviar.setPreferredSize(new Dimension(10, 40));
        this.add(botonEnviar, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(new ControladorGestorDeUsuarios().existe(remitente)){
                        new ControladorServidorDeMensajeria().responderNota(madre, campoMensaje.getText(), remitente, destinatario);
                        JOptionPane mensajeEnviado = new JOptionPane();
                        mensajeEnviado.showMessageDialog(frame.getContentPane(), "Mensaje enviado correctamente");
                    }
                    else{
                        JOptionPane destinatarioIncorrecto = new JOptionPane();
                        destinatarioIncorrecto.showMessageDialog(frame.getContentPane(), "Destinatario incorrecto");
                    }
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
