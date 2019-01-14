package vista;

import modelo.BeerBarException;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotasUsuario extends JFrame {

    JPanel panelNotas, panelDestinatario, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas, opcionAyuda;
    JFrame frameVentanaNotas;
    JLabel textoMensaje;
    JTextField campoTextoDestinatario;
    JTextArea campoMensaje;
    String nombreUsuario;

    private VentanaNotasUsuario ventanaNotasUsuario = this;

    public VentanaNotasUsuario(String nombreUsuario){

        frameVentanaNotas = this;
        this.nombreUsuario = nombreUsuario;

        this.setTitle("Notas de " + this.nombreUsuario);
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Acciones");
        ayuda = new JMenu("Ayuda");
        opcionEscribirNota = new JMenuItem("Escribir nota");
        opcionVerNotasRecibidas = new JMenuItem("Ver notas recibidas");
        opcionVerNotasEnviadas = new JMenuItem("Ver notas enviadas");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionEscribirNota);
        acciones.add(opcionVerNotasRecibidas);
        acciones.add(opcionVerNotasEnviadas);
        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelNotas = new JPanel();
        panelNotas.setBackground(new Color(128, 128, 128));
        panelNotas.setLayout(new BorderLayout());
        JLabel textoNotas = new JLabel("Ventana de notas de " + this.nombreUsuario);
        panelNotas.add(textoNotas, BorderLayout.CENTER);
        panelNotas.setBorder(new EmptyBorder(new Insets(0, 300, 0, 0)));
        this.getContentPane().add(panelNotas);


        //ESCRIBIR NOTA
        panelEscribirNotaA = new JPanel();
        panelEscribirNotaA.setBackground(new Color(128, 128, 128));
        panelEscribirNotaA.setSize(800, 600);
        panelEscribirNotaA.setLayout(new BorderLayout());
        panelDestinatario = new JPanel();
        panelDestinatario.setBackground(new Color(128, 128, 128));
        panelDestinatario.setLayout(new BoxLayout(panelDestinatario, BoxLayout.PAGE_AXIS));
        panelEscribirNotaA.add(panelDestinatario, BorderLayout.NORTH);
        JLabel textoDestinatario = new JLabel("Destinatario");
        campoTextoDestinatario = new JTextField();
        textoMensaje = new JLabel("Mensaje");
        panelDestinatario.add(textoDestinatario);
        panelDestinatario.add(campoTextoDestinatario);
        panelDestinatario.add(textoMensaje);
        campoMensaje = new JTextArea();
        panelEscribirNotaA.add(campoMensaje, BorderLayout.CENTER);
        JButton botonEnviar = new JButton("Enviar");
        botonEnviar.setBackground(new Color(0, 38, 77));
        botonEnviar.setForeground(Color.WHITE);
        botonEnviar.setOpaque(true);
        botonEnviar.setBorderPainted(false);
        botonEnviar.setPreferredSize(new Dimension(10, 40));
        panelEscribirNotaA.add(botonEnviar, BorderLayout.SOUTH);
        panelEscribirNotaA.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Esto creo que está muy mal porque estoy mezclando modelo y vista, pero hay que crear el controaldor en el main
                MainBeer.controladorUsuario.setVentana(ventanaNotasUsuario);
                Usuario usuario = new Usuario();
                usuario.setNombre(campoTextoDestinatario.toString());
                try {
                    MainBeer.controladorUsuario.enviarNotaA(usuario, campoMensaje.toString());
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }

                // Aqui crear una instancia de la clase controladora de las notas y pasarle al constructor
                // el destinatario y el texto, y que lo envie. Despues de enviar, se vuelve al panel de las notas
                // y se muestra un mensaje de confirmacion del envio
            }
        });


        //VER NOTAS RECIBIDAS
        panelVerNotasRecibidas = new JPanel();
        panelVerNotasRecibidas.setBackground(new Color(128, 128, 128));
        panelVerNotasRecibidas.setSize(800, 600);
        panelVerNotasRecibidas.setLayout(new BorderLayout());
        JPanel panelDentroScrollRecibidas = new JPanel();
        panelDentroScrollRecibidas.setLayout(new BoxLayout(panelDentroScrollRecibidas, BoxLayout.PAGE_AXIS));
        panelDentroScrollRecibidas.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollRecibidas = new JScrollPane(panelDentroScrollRecibidas);
        panelScrollRecibidas.getVerticalScrollBar().setUnitIncrement(40);
        panelVerNotasRecibidas.add(panelScrollRecibidas, BorderLayout.CENTER);
        panelDentroScrollRecibidas.setBackground(new Color(128, 128, 128));

        JTextAreaNotas texto1 = new JTextAreaNotas("Adri", "Felipe", "1 de Enero de 2019", "Hola que tal estas como te va la vida crak");
        panelDentroScrollRecibidas.add(texto1);

        JTextAreaNotas texto2 = new JTextAreaNotas("Felipe", "Adri", "4 de Enero de 2019", "A mi bien y a ti que tal meteoro");
        panelDentroScrollRecibidas.add(texto2);


        //VER NOTAS ENVIADAS
        panelVerNotasEnviadas = new JPanel();
        panelVerNotasEnviadas.setBackground(new Color(128, 128, 128));
        panelVerNotasEnviadas.setSize(800, 600);
        panelVerNotasEnviadas.setLayout(new BorderLayout());
        JPanel panelDentroScrollEnviadas = new JPanel();
        panelDentroScrollEnviadas.setLayout(new BoxLayout(panelDentroScrollEnviadas, BoxLayout.PAGE_AXIS));
        panelDentroScrollEnviadas.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollEnviadas = new JScrollPane(panelDentroScrollEnviadas);
        panelScrollEnviadas.getVerticalScrollBar().setUnitIncrement(40);
        panelVerNotasEnviadas.add(panelScrollEnviadas, BorderLayout.CENTER);
        panelDentroScrollEnviadas.setBackground(new Color(128, 128, 128));

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

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaNotas.getContentPane());
                ayuda.muestraAyudaNotasUsuario();
            }
        });

        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
