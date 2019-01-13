package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTransaccionesAdministrador extends JFrame{

    JPanel panelTransacciones, panelIntroducirVenta, panelIntroducirGasto, panelVerTransacciones, panelVerTodasTransacciones;
    JMenuBar barraMenu;
    JMenu menu;
    JMenuItem opcionIntroducirVenta, opcionIntroducirGasto, opcionVerTransacciones, opcionVerTodasTransacciones, opcionAyuda;
    JFrame frameVentanaTransacciones;

    public VentanaTransaccionesAdministrador(){

        frameVentanaTransacciones = this;

        this.setTitle("Transacciones administrador");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        opcionIntroducirVenta = new JMenuItem("Introducir una venta");
        opcionIntroducirGasto = new JMenuItem("Introducir un gasto");
        opcionVerTransacciones = new JMenuItem("Ver transacciones");
        opcionVerTodasTransacciones = new JMenuItem("Ver todas las transacciones");
        opcionAyuda = new JMenuItem("Ayuda");
        menu.add(opcionIntroducirVenta);
        menu.add(opcionIntroducirGasto);
        menu.add(opcionVerTransacciones);
        menu.add(opcionVerTodasTransacciones);
        menu.add(opcionAyuda);
        barraMenu.add(menu);
        this.setJMenuBar(barraMenu);

        panelTransacciones = new JPanel();
        panelTransacciones.setLayout(new BorderLayout());
        JLabel textoNotas = new JLabel("Ventana de transacciones del administrador");
        panelTransacciones.add(textoNotas, BorderLayout.CENTER);
        panelTransacciones.setBorder(new EmptyBorder(new Insets(0, 250, 0, 0)));
        this.getContentPane().add(panelTransacciones);


        //INTRODUCIR VENTA
        panelIntroducirVenta = new JPanel();
        panelIntroducirVenta.setSize(800, 600);
        panelIntroducirVenta.setLayout(new BorderLayout());
        JPanel panelVenta = new JPanel();
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
        panelIntroducirVenta.add(botonIntroducirVenta, BorderLayout.SOUTH);
        panelIntroducirVenta.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));


        //INTRODUCIR GASTO
        panelIntroducirGasto = new JPanel();
        panelIntroducirGasto.setSize(800, 600);
        panelIntroducirGasto.setLayout(new BorderLayout());
        JPanel panelGasto = new JPanel();
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
        panelIntroducirGasto.add(botonIntroducirGasto, BorderLayout.SOUTH);
        panelIntroducirGasto.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));


        //VER TRANSACCIONES
        panelVerTransacciones = new JPanel();
        panelVerTransacciones.setSize(800, 600);
        panelVerTransacciones.setLayout(new BorderLayout());
        JPanel panelDentroScrollTransacciones = new JPanel();
        panelDentroScrollTransacciones.setLayout(new BoxLayout(panelDentroScrollTransacciones, BoxLayout.PAGE_AXIS));
        panelDentroScrollTransacciones.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollTransacciones = new JScrollPane(panelDentroScrollTransacciones);
        panelScrollTransacciones.getVerticalScrollBar().setUnitIncrement(40);
        panelVerTransacciones.add(panelScrollTransacciones, BorderLayout.CENTER);
        panelDentroScrollTransacciones.setBackground(Color.BLACK);

        panelDentroScrollTransacciones.add(new JTextAreaTransacciones(true, "Felipe", "1 de Enero de 2019", "24,57", "Unos buenos cocacolos con una tapichuela de tortilluca"));
        panelDentroScrollTransacciones.add(new JTextAreaTransacciones(false, "Adri", "2 de Enero de 2019", "13,56", "Compra de un buen kilo de alioli como el de hasan"));


        //VER TODAS TRANSACCIONES
        panelVerTodasTransacciones = new JPanel();
        panelVerTodasTransacciones.setSize(800, 600);
        panelVerTodasTransacciones.setLayout(new BorderLayout());
        JPanel panelDentroScrollTodasTransacciones = new JPanel();
        panelDentroScrollTodasTransacciones.setLayout(new BoxLayout(panelDentroScrollTodasTransacciones, BoxLayout.PAGE_AXIS));
        panelDentroScrollTodasTransacciones.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        JScrollPane panelScrollTodasTransacciones = new JScrollPane(panelDentroScrollTodasTransacciones);
        panelScrollTodasTransacciones.getVerticalScrollBar().setUnitIncrement(40);
        panelVerTodasTransacciones.add(panelScrollTodasTransacciones, BorderLayout.CENTER);
        panelDentroScrollTodasTransacciones.setBackground(Color.BLACK);

        panelDentroScrollTodasTransacciones.add(new JTextAreaTransacciones(true, "Felipe", "1 de Enero de 2019", "24,57", "Unos buenos cocacolos con una tapichuela de tortilluca\nadministrador"));
        panelDentroScrollTodasTransacciones.add(new JTextAreaTransacciones(false, "Adri", "2 de Enero de 2019", "13,56", "Compra de un buen kilo de alioli como el de hasan\nadministrador"));


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

        opcionVerTodasTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaTransacciones.getContentPane().removeAll();
                frameVentanaTransacciones.getContentPane().repaint();
                frameVentanaTransacciones.getContentPane().revalidate();
                frameVentanaTransacciones.getContentPane().add(panelVerTodasTransacciones);
                frameVentanaTransacciones.setVisible(true);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaTransacciones.getContentPane());
                ayuda.muestraAyudaTransaccionesAdministrador();
            }
        });


        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
