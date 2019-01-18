package vista.principal;

import controlador.ControladorCalendario;
import controlador.ControladorInicio;
import modelo.BeerBarException;
import modelo.Fecha;
import modelo.Transaccion;
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
    JMenuItem opcionIntroducirVenta, opcionIntroducirGasto, opcionVerTransacciones, opcionCerrarJornada, opcionAyuda, opcionAyudaGeneral;
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
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");

        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionIntroducirVenta);
        acciones.add(opcionIntroducirGasto);
        acciones.add(opcionVerTransacciones);
        acciones.add(opcionCerrarJornada);
        
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
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
                panelIntroducirVenta = new JPanelIntroducirTransaccion(true, nombreUsuario, fechaString, frameVentanaTransacciones);
                actualizarPanel(panelIntroducirVenta);
            }
        });

        opcionIntroducirGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelIntroducirGasto = new JPanelIntroducirTransaccion(false, nombreUsuario, fechaString, frameVentanaTransacciones);
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
                float sumaTotal = 0;
                try {
                    new ControladorCalendario().rellenaCalendario();
                    ArrayList<Transaccion> transacciones = new ControladorCalendario().obtenTransaccionesDelDia(new Fecha().fromStringAbreviadoToFecha(fechaString));
                    while(!transacciones.isEmpty()){
                        sumaTotal += transacciones.get(0).getCantidad();
                        transacciones.remove(0);
                    }
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }

                JOptionPane panelSumaJornada = new JOptionPane();
                panelSumaJornada.showMessageDialog(frameVentanaTransacciones.getContentPane(), "Total de la jornada: " + sumaTotal);
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

        opcionAyudaGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAyudaGeneral();
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
