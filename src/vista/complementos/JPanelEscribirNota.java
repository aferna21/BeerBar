package vista.complementos;

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

    public JPanelEscribirNota() {

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
                // Aqui crear una instancia de la clase controladora de las notas y pasarle al constructor
                // el destinatario y el texto, y que lo envie. Despues de enviar, se vuelve al panel de las notas
                // y se muestra un mensaje de confirmacion del envio
            }
        });
    }
}
