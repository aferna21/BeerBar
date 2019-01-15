package vista;

import vista.complementos.JOptionPaneAyuda;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTransaccionesUsuario extends JFrame {

    JPanel panelTransacciones, panelIntroducirVenta, panelIntroducirGasto, panelVerTransacciones;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionIntroducirVenta, opcionIntroducirGasto, opcionVerTransacciones, opcionAyuda;
    JFrame frameVentanaTransacciones;
    String nombreUsuario;

    public VentanaTransaccionesUsuario(String nombreUsuario){

        frameVentanaTransacciones = this;
        this.nombreUsuario = nombreUsuario;

        this.setTitle("Transacciones de " + this.nombreUsuario);
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        acciones = new JMenu("Acciones");
        ayuda = new JMenu("Ayuda");
        opcionIntroducirVenta = new JMenuItem("Introducir una venta");
        opcionIntroducirGasto = new JMenuItem("Introducir un gasto");
        opcionVerTransacciones = new JMenuItem("Ver transacciones");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionIntroducirVenta);
        acciones.add(opcionIntroducirGasto);
        acciones.add(opcionVerTransacciones);
        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelTransacciones = new JPanel();
        panelTransacciones.setBackground(new Color(128, 128, 128));
        panelTransacciones.setLayout(new BorderLayout());
        JLabel textoNotas = new JLabel("Ventana de transacciones de " + this.nombreUsuario);
        panelTransacciones.add(textoNotas, BorderLayout.CENTER);
        panelTransacciones.setBorder(new EmptyBorder(new Insets(0, 250, 0, 0)));
        this.getContentPane().add(panelTransacciones);


        //INTRODUCIR VENTA
        panelIntroducirVenta = new JPanel();
        panelIntroducirVenta.setBackground(new Color(128, 128, 128));
        panelIntroducirVenta.setSize(800, 600);
        panelIntroducirVenta.setLayout(new BorderLayout());
        JPanel panelVenta = new JPanel();
        panelVenta.setBackground(new Color(128, 128, 128));
        panelVenta.setLayout(new BoxLayout(panelVenta, BoxLayout.PAGE_AXIS));
        panelIntroducirVenta.add(panelVenta, BorderLayout.NORTH);
        JLabel textoImporteVenta = new JLabel("Importe de la venta");
        JTextField campoTextoImporteVenta = new JTextField();
        JLabel textoConceptoVenta = new JLabel("Concepto");
        panelVenta.add(textoImporteVenta);
        panelVenta.add(campoTextoImporteVenta);
        panelVenta.add(textoConceptoVenta);
        JTextArea campoConceptoVenta = new JTextArea();
        panelIntroducirVenta.add(campoConceptoVenta, BorderLayout.CENTER);
        JButton botonIntroducirVenta = new JButton("Introducir venta");
        botonIntroducirVenta.setBackground(new Color(0, 38, 77));
        botonIntroducirVenta.setForeground(Color.WHITE);
        botonIntroducirVenta.setOpaque(true);
        botonIntroducirVenta.setBorderPainted(false);
        botonIntroducirVenta.setPreferredSize(new Dimension(10, 40));
        panelIntroducirVenta.add(botonIntroducirVenta, BorderLayout.SOUTH);
        panelIntroducirVenta.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));


        //INTRODUCIR GASTO
        panelIntroducirGasto = new JPanel();
        panelIntroducirGasto.setBackground(new Color(128, 128, 128));
        panelIntroducirGasto.setSize(800, 600);
        panelIntroducirGasto.setLayout(new BorderLayout());
        JPanel panelGasto = new JPanel();
        panelGasto.setBackground(new Color(128, 128, 128));
        panelGasto.setLayout(new BoxLayout(panelGasto, BoxLayout.PAGE_AXIS));
        panelIntroducirGasto.add(panelGasto, BorderLayout.NORTH);
        JLabel textoImporteGasto = new JLabel("Importe del gasto");
        JTextField campoTextoImporteGasto = new JTextField();
        JLabel textoConceptoGasto = new JLabel("Concepto");
        panelGasto.add(textoImporteGasto);
        panelGasto.add(campoTextoImporteGasto);
        panelGasto.add(textoConceptoGasto);
        JTextArea campoConceptoGasto = new JTextArea();
        panelIntroducirGasto.add(campoConceptoGasto, BorderLayout.CENTER);
        JButton botonIntroducirGasto = new JButton("Introducir gasto");
        botonIntroducirGasto.setBackground(new Color(0, 38, 77));
        botonIntroducirGasto.setForeground(Color.WHITE);
        botonIntroducirGasto.setOpaque(true);
        botonIntroducirGasto.setBorderPainted(false);
        botonIntroducirGasto.setPreferredSize(new Dimension(10, 40));
        panelIntroducirGasto.add(botonIntroducirGasto, BorderLayout.SOUTH);
        panelIntroducirGasto.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));


        //VER TRANSACCIONES
        panelVerTransacciones = new JPanel();
        panelTransacciones.setBackground(new Color(128, 128, 128));
        panelVerTransacciones.setSize(800, 600);
        panelVerTransacciones.setLayout(new BorderLayout());
        JPanel panelDentroScrollTransacciones = new JPanel();
        panelDentroScrollTransacciones.setLayout(new BoxLayout(panelDentroScrollTransacciones, BoxLayout.PAGE_AXIS));
        panelDentroScrollTransacciones.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollTransacciones = new JScrollPane(panelDentroScrollTransacciones);
        panelScrollTransacciones.getVerticalScrollBar().setUnitIncrement(40);
        panelVerTransacciones.add(panelScrollTransacciones, BorderLayout.CENTER);
        panelDentroScrollTransacciones.setBackground(new Color(128, 128, 128));


        opcionIntroducirVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaTransacciones.getContentPane().removeAll();
                frameVentanaTransacciones.getContentPane().repaint();
                frameVentanaTransacciones.getContentPane().revalidate();
                frameVentanaTransacciones.getContentPane().add(panelIntroducirVenta);
                frameVentanaTransacciones.setVisible(true);
            }
        });

        opcionIntroducirGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaTransacciones.getContentPane().removeAll();
                frameVentanaTransacciones.getContentPane().repaint();
                frameVentanaTransacciones.getContentPane().revalidate();
                frameVentanaTransacciones.getContentPane().add(panelIntroducirGasto);
                frameVentanaTransacciones.setVisible(true);
            }
        });

        opcionVerTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaTransacciones.getContentPane().removeAll();
                frameVentanaTransacciones.getContentPane().repaint();
                frameVentanaTransacciones.getContentPane().revalidate();
                frameVentanaTransacciones.getContentPane().add(panelVerTransacciones);
                frameVentanaTransacciones.setVisible(true);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaTransacciones.getContentPane());
                ayuda.muestraAyudaTransaccionesUsuario();
            }
        });

        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
