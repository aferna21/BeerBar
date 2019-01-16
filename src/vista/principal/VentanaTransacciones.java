package vista.principal;

import vista.complementos.JOptionPaneAyuda;
import vista.complementos.JPanelIntroducirTransaccion;
import vista.complementos.JPanelVerTransacciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaTransacciones extends JFrame {

    JPanel panelTransacciones, panelIntroducirVenta, panelIntroducirGasto, panelVerTransacciones;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionIntroducirVenta, opcionIntroducirGasto, opcionVerTransacciones, opcionCerrarJornada, opcionAyuda;
    JFrame frameVentanaTransacciones;
    String nombreUsuario;

    public VentanaTransacciones(String nombreUsuario, String fechaString){

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
        opcionCerrarJornada = new JMenuItem("Cerrar jornada");

        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionIntroducirVenta);
        acciones.add(opcionIntroducirGasto);
        acciones.add(opcionVerTransacciones);
        acciones.add(opcionCerrarJornada);

        ayuda.add(opcionAyuda);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelTransacciones = new JPanel();
        panelTransacciones.setBackground(new Color(128, 128, 128));
        panelTransacciones.setLayout(new BorderLayout());

        JLabel textoNotas = new JLabel("Ventana de transacciones de " + this.nombreUsuario);
        panelTransacciones.add(textoNotas, BorderLayout.CENTER);
        panelTransacciones.setBorder(new EmptyBorder(new Insets(0, 300, 0, 0)));

        this.getContentPane().add(panelTransacciones);


        //INTRODUCIR VENTA
        panelIntroducirVenta = new JPanelIntroducirTransaccion(true, this.nombreUsuario, fechaString);


        //INTRODUCIR GASTO
        panelIntroducirGasto = new JPanelIntroducirTransaccion(false, this.nombreUsuario, fechaString);


        //VER TRANSACCIONES
        //TODO
        panelVerTransacciones = new JPanelVerTransacciones(new ArrayList<>());


        opcionIntroducirVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPanel(panelIntroducirVenta);
            }
        });

        opcionIntroducirGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPanel(panelIntroducirGasto);
            }
        });

        opcionVerTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPanel(panelVerTransacciones);
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

    public void actualizarPanel(JPanel panelNuevo){
        frameVentanaTransacciones.getContentPane().removeAll();
        frameVentanaTransacciones.getContentPane().repaint();
        frameVentanaTransacciones.getContentPane().revalidate();
        frameVentanaTransacciones.getContentPane().add(panelNuevo);
        frameVentanaTransacciones.setVisible(true);
    }
}
