package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import controlador.ControladorServidorDeMensajeria;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelEscribirNota extends JPanel {

    JPanel panelDestinatario;
    JLabel textoDestinatario, textoMensaje;
    JTextField campoTextoDestinatario;
    JTextArea campoMensaje;

    public JPanelEscribirNota(String remitente, JFrame frame) {

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelDestinatario = new JPanel();
        panelDestinatario.setBackground(new Color(128, 128, 128));
        panelDestinatario.setLayout(new BoxLayout(panelDestinatario, BoxLayout.PAGE_AXIS));

        textoDestinatario = new JLabel("Destinatario");
        campoTextoDestinatario = new JTextField();
        textoMensaje = new JLabel("Mensaje");

        panelDestinatario.add(textoDestinatario);
        panelDestinatario.add(campoTextoDestinatario);
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
                if(campoTextoDestinatario.getText().equals(remitente)){
                    JOptionPane error = new JOptionPane();
                    error.showMessageDialog(frame.getContentPane(), "No te puedes mandar un mensaje a ti mismo");
                    return;
                }
                try {
                    if(new ControladorGestorDeUsuarios().existe(campoTextoDestinatario.getText())){
                        new ControladorServidorDeMensajeria().escribirNota(campoMensaje.getText(), remitente, campoTextoDestinatario.getText(), 0);
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
