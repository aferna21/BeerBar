package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotasUsuario extends JFrame {

    JPanel panelNotas, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas;
    JMenuBar barraMenu;
    JMenu menu;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas;
    JFrame frameVentanaNotas;

    public VentanaNotasUsuario(){

        frameVentanaNotas = this;

        this.setTitle("Notas usuario");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        opcionEscribirNota = new JMenuItem("Escribir nota");
        opcionVerNotasRecibidas = new JMenuItem("Ver notas recibidas");
        opcionVerNotasEnviadas = new JMenuItem("Ver notas enviadas");
        menu.add(opcionEscribirNota);
        menu.add(opcionVerNotasRecibidas);
        menu.add(opcionVerNotasEnviadas);
        barraMenu.add(menu);
        this.setJMenuBar(barraMenu);

        panelNotas = new JPanel();
        panelNotas.setLayout(new BorderLayout());
        JLabel textoNotas = new JLabel("Ventana de notas");
        panelNotas.add(textoNotas, BorderLayout.CENTER);
        panelNotas.setBorder(new EmptyBorder(new Insets(0, 300, 0, 300)));
        this.getContentPane().add(panelNotas);


        //ESCRIBIR NOTA
        panelEscribirNotaA = new JPanel();
        panelEscribirNotaA.setSize(800, 600);
        panelEscribirNotaA.setLayout(new BorderLayout());
        JPanel panelDestinatario = new JPanel();
        panelDestinatario.setLayout(new BoxLayout(panelDestinatario, BoxLayout.PAGE_AXIS));
        panelEscribirNotaA.add(panelDestinatario, BorderLayout.NORTH);
        JLabel textoDestinatario = new JLabel("Destinatario");
        JTextField campoTextoDestinatario = new JTextField();
        JLabel textoMensaje = new JLabel("Mensaje");
        panelDestinatario.add(textoDestinatario);
        panelDestinatario.add(campoTextoDestinatario);
        panelDestinatario.add(textoMensaje);
        JTextArea campoMensaje = new JTextArea();
        panelEscribirNotaA.add(campoMensaje, BorderLayout.CENTER);
        JButton botonEnviar = new JButton("Enviar");
        panelEscribirNotaA.add(botonEnviar, BorderLayout.SOUTH);
        panelEscribirNotaA.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui crear una instancia de la clase controladora de las notas y pasarle al constructor
                // el destinatario y el texto, y que lo envie. Despues de enviar, se vuelve al panel de las notas
                // y se muestra un mensaje de confirmacion del envio
            }
        });


        //VER NOTAS RECIBIDAS
        panelVerNotasRecibidas = new JPanel();
        panelVerNotasRecibidas.setSize(800, 600);
        panelVerNotasRecibidas.setLayout(new BorderLayout());
        JPanel panelDentroScrollRecibidas = new JPanel();
        panelDentroScrollRecibidas.setLayout(new BoxLayout(panelDentroScrollRecibidas, BoxLayout.PAGE_AXIS));
        panelDentroScrollRecibidas.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollRecibidas = new JScrollPane(panelDentroScrollRecibidas);
        panelScrollRecibidas.getVerticalScrollBar().setUnitIncrement(40);
        panelVerNotasRecibidas.add(panelScrollRecibidas, BorderLayout.CENTER);
        panelDentroScrollRecibidas.setBackground(Color.BLACK);

        JTextAreaNotas texto1 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "Hola que tal estas como te va la vida crak");
        panelDentroScrollRecibidas.add(texto1);

        JTextAreaNotas texto2 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "A mi bien y a ti que tal meteoro");
        panelDentroScrollRecibidas.add(texto2);


        //VER NOTAS ENVIADAS
        panelVerNotasEnviadas = new JPanel();
        panelVerNotasEnviadas.setSize(800, 600);
        panelVerNotasEnviadas.setLayout(new BorderLayout());
        JPanel panelDentroScrollEnviadas = new JPanel();
        panelDentroScrollEnviadas.setLayout(new BoxLayout(panelDentroScrollEnviadas, BoxLayout.PAGE_AXIS));
        panelDentroScrollEnviadas.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollEnviadas = new JScrollPane(panelDentroScrollEnviadas);
        panelScrollEnviadas.getVerticalScrollBar().setUnitIncrement(40);
        panelVerNotasEnviadas.add(panelScrollEnviadas, BorderLayout.CENTER);
        panelDentroScrollEnviadas.setBackground(Color.BLACK);

        JTextAreaNotas texto3 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "Bueno pues otro texto de prueba jejejej");
        panelDentroScrollEnviadas.add(texto3);

        JTextAreaNotas texto4 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "Tampoco se que poner aqui sois unas tenias");
        panelDentroScrollEnviadas.add(texto4);


        opcionEscribirNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelEscribirNotaA);
                frameVentanaNotas.setVisible(true);
            }
        });

        opcionVerNotasRecibidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelVerNotasRecibidas);
                frameVentanaNotas.setVisible(true);
            }
        });

        opcionVerNotasEnviadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelVerNotasEnviadas);
                frameVentanaNotas.setVisible(true);
            }
        });

        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
