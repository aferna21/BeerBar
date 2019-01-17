package vista.principal;

import modelo.BeerBarException;
import vista.complementos.JOptionPaneAyuda;
import vista.complementos.JPanelIntroducirTransaccion;
import vista.complementos.JPanelVerTransacciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTransacciones extends JFrame {

    JPanel panelTransacciones, panelIntroducirVenta, panelIntroducirGasto, panelVerTransacciones;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionIntroducirVenta, opcionIntroducirGasto, opcionVerTransacciones, opcionCerrarJornada, opcionAyuda;
    JFrame frameVentanaTransacciones;
    String nombreUsuario;

    public VentanaTransacciones(String nombreUsuario, String fechaString) throws BeerBarException {

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


        opcionIntroducirVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelIntroducirVenta = new JPanelIntroducirTransaccion(true, nombreUsuario, fechaString);
                actualizarPanel(panelIntroducirVenta);
            }
        });

        opcionIntroducirGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelIntroducirGasto = new JPanelIntroducirTransaccion(false, nombreUsuario, fechaString);
                actualizarPanel(panelIntroducirGasto);
            }
        });

        opcionVerTransacciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panelVerTransacciones = new JPanelVerTransacciones(fechaString, fechaString);
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                actualizarPanel(panelVerTransacciones);
            }
        });

        opcionCerrarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane panelSumaJornada = new JOptionPane();
                panelSumaJornada.showMessageDialog(frameVentanaTransacciones.getContentPane(), "Total de la jornada: doziento euro primo\n" +
                        "pd: tonto el que lo lea jeje");
                dispose();
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
