package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotasAdministrador extends JFrame{

    JPanel panelNotas, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas, panelVerTodasLasNotas;
    JMenuBar barraMenu;
    JMenu menu;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas, opcionVerTodasLasNotas, opcionAyuda;
    JFrame frameVentanaNotas;

    public VentanaNotasAdministrador(){

        frameVentanaNotas = this;

        this.setTitle("Notas administrador");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        opcionEscribirNota = new JMenuItem("Escribir nota");
        opcionVerNotasRecibidas = new JMenuItem("Ver notas recibidas");
        opcionVerNotasEnviadas = new JMenuItem("Ver notas enviadas");
        opcionVerTodasLasNotas =  new JMenuItem("Ver todas las notas");
        opcionAyuda = new JMenuItem("Ayuda");
        menu.add(opcionEscribirNota);
        menu.add(opcionVerNotasRecibidas);
        menu.add(opcionVerNotasEnviadas);
        menu.add(opcionVerTodasLasNotas);
        menu.add(opcionAyuda);
        barraMenu.add(menu);
        this.setJMenuBar(barraMenu);

        panelNotas = new JPanel();
        panelNotas.setLayout(new BorderLayout());
        JLabel textoNotas = new JLabel("Ventana de notas del administrador");
        panelNotas.add(textoNotas, BorderLayout.CENTER);
        panelNotas.setBorder(new EmptyBorder(new Insets(0, 250, 0, 0)));
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

        JTextAreaNotas texto1 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "prueba de las notas del admin");
        panelDentroScrollRecibidas.add(texto1);

        JTextAreaNotas texto2 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "me cago en mis muelas a ver si acabamos");
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

        JTextAreaNotas texto3 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "otra prueba mais");
        panelDentroScrollEnviadas.add(texto3);

        JTextAreaNotas texto4 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "y otra mais esto se va a descontrolaaaaaaa");
        panelDentroScrollEnviadas.add(texto4);


        //VER TODAS LAS NOTAS
        panelVerTodasLasNotas = new JPanel();
        panelVerTodasLasNotas.setSize(800, 600);
        panelVerTodasLasNotas.setLayout(new BorderLayout());
        JPanel panelDentroScrollTodasNotas = new JPanel();
        panelDentroScrollTodasNotas.setLayout(new BoxLayout(panelDentroScrollTodasNotas, BoxLayout.PAGE_AXIS));
        panelDentroScrollTodasNotas.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollTodasNotas = new JScrollPane(panelDentroScrollTodasNotas);
        panelScrollTodasNotas.getVerticalScrollBar().setUnitIncrement(40);
        panelVerTodasLasNotas.add(panelScrollTodasNotas, BorderLayout.CENTER);
        panelDentroScrollTodasNotas.setBackground(Color.BLACK);

        JTextAreaNotas texto5 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "eeeeeeeeeee jejeje");
        panelDentroScrollTodasNotas.add(texto5);

        JTextAreaNotas texto6 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "hola qu tal n¡mu buenas");
        panelDentroScrollTodasNotas.add(texto6);


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

        opcionVerTodasLasNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelVerTodasLasNotas);
                frameVentanaNotas.setVisible(true);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaNotas.getContentPane());
                ayuda.muestraAyudaNotasAdministrador();
            }
        });


        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
