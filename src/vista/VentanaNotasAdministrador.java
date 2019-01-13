package vista;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotasAdministrador extends JFrame{

    JPanel panelNotas, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas, panelVerTodasLasNotas, panelVerNotasFecha;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas, opcionVerTodasLasNotas, opcionVerNotasFecha, opcionAyuda;
    JFrame frameVentanaNotas;

    public VentanaNotasAdministrador(){

        frameVentanaNotas = this;

        this.setTitle("Notas administrador");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Menu");
        ayuda = new JMenu("Ayuda");
        opcionEscribirNota = new JMenuItem("Escribir nota");
        opcionVerNotasRecibidas = new JMenuItem("Ver notas recibidas");
        opcionVerNotasEnviadas = new JMenuItem("Ver notas enviadas");
        opcionVerTodasLasNotas =  new JMenuItem("Ver todas las notas");
        opcionVerNotasFecha = new JMenuItem("Ver notas en un rango de fechas");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionEscribirNota);
        acciones.add(opcionVerNotasRecibidas);
        acciones.add(opcionVerNotasEnviadas);
        acciones.add(opcionVerTodasLasNotas);
        acciones.add(opcionVerNotasFecha);
        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
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

        for(int i=0; i<40; i++){
            panelDentroScrollTodasNotas.add(new JTextAreaNotas("Felipe", "Adri", "2 de febrero", "hola"));
        }


        //VER NOTAS EN RANGO DE FECHAS
        panelVerNotasFecha = new JPanel();
        panelVerNotasFecha.setSize(new Dimension(800, 600));
        panelVerNotasFecha.setLayout(new BorderLayout());

        JPanel panelNotasFechaNorte = new JPanel();
        panelNotasFechaNorte.setLayout(new BoxLayout(panelNotasFechaNorte, BoxLayout.PAGE_AXIS));
        panelNotasFechaNorte.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        panelVerNotasFecha.add(panelNotasFechaNorte, BorderLayout.NORTH);
        JLabel textoFechaInicio = new JLabel("Fecha inicio: ");
        JDateChooser dateChooserInicio = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        JLabel textoFechaFin = new JLabel("Fecha fin: ");
        JDateChooser dateChooserFin = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        JButton botonAceptar = new JButton("Aceptar");
        panelNotasFechaNorte.add(textoFechaInicio);
        panelNotasFechaNorte.add(dateChooserInicio);
        panelNotasFechaNorte.add(textoFechaFin);
        panelNotasFechaNorte.add(dateChooserFin);
        panelNotasFechaNorte.add(botonAceptar);

        JPanel panelDentroScrollNotasFecha = new JPanel();
        panelDentroScrollNotasFecha.setLayout(new BoxLayout(panelDentroScrollNotasFecha, BoxLayout.PAGE_AXIS));
        panelDentroScrollNotasFecha.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollNotasFecha = new JScrollPane(panelDentroScrollNotasFecha);
        panelScrollNotasFecha.getVerticalScrollBar().setUnitIncrement(40);
        panelVerNotasFecha.add(panelScrollNotasFecha, BorderLayout.CENTER);
        panelDentroScrollNotasFecha.setBackground(Color.BLACK);

        for(int i=0; i<40; i++){
            panelDentroScrollNotasFecha.add(new JTextAreaNotas("Felipe", "Adri", "2 de febrero", "hola"));
        }


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

        opcionVerNotasFecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelVerNotasFecha);
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
