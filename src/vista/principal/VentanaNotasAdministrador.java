package vista.principal;

import controlador.ControladorInicio;
import controlador.ControladorServidorDeMensajeria;
import modelo.BeerBarException;
import modelo.Nota;
import vista.complementos.JOptionPaneAyuda;
import vista.complementos.JPanelEscribirNota;
import vista.complementos.JPanelVerNotas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaNotasAdministrador extends JFrame{

    JPanel panelNotas, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas, panelVerTodasLasNotas;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas, opcionVerTodasLasNotas, opcionAyuda, opcionAyudaGeneral;
    JFrame frameVentanaNotas;
    ArrayList<Nota> notasRecibidas, notasEnviadas, notasTotales;
    VentanaNotasAdministrador ventanaNotasAdministrador;

    public VentanaNotasAdministrador(){

        ventanaNotasAdministrador = this;

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
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionEscribirNota);
        acciones.add(opcionVerNotasRecibidas);
        acciones.add(opcionVerNotasEnviadas);
        acciones.add(opcionVerTodasLasNotas);
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelNotas = new JPanel();
        panelNotas.setBackground(new Color(128, 128, 128));
        panelNotas.setLayout(new BorderLayout());

        JLabel textoNotas = new JLabel("Ventana de notas del administrador");
        panelNotas.add(textoNotas, BorderLayout.CENTER);
        panelNotas.setBorder(new EmptyBorder(new Insets(0, 250, 0, 0)));

        this.getContentPane().add(panelNotas);


        opcionEscribirNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEscribirNotaA = new JPanelEscribirNota("admin", frameVentanaNotas);
                try {
                    new ControladorInicio().actualizarInformacion();
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                actualizarPanel(panelEscribirNotaA);
            }
        });


        opcionVerNotasRecibidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasRecibidas = new ControladorServidorDeMensajeria().devuelveNotasHacia("admin");
                panelVerNotasRecibidas = new JPanelVerNotas(notasRecibidas, false, "admin", ventanaNotasAdministrador);
                actualizarPanel(panelVerNotasRecibidas);
            }
        });


        opcionVerNotasEnviadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasEnviadas = new ControladorServidorDeMensajeria().devuelveNotasEscritasPor("admin");
                panelVerNotasEnviadas = new JPanelVerNotas(notasEnviadas, true, "admin", ventanaNotasAdministrador);
                actualizarPanel(panelVerNotasEnviadas);
            }
        });


        opcionVerTodasLasNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasTotales = new ControladorServidorDeMensajeria().dameTodasNotas();
                panelVerTodasLasNotas = new JPanelVerNotas(notasTotales, true, "admin", ventanaNotasAdministrador);
                actualizarPanel(panelVerTodasLasNotas);
            }
        });


        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaNotas.getContentPane());
                ayuda.muestraAyudaNotasAdministrador();
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
        frameVentanaNotas.getContentPane().removeAll();
        frameVentanaNotas.getContentPane().repaint();
        frameVentanaNotas.getContentPane().revalidate();
        frameVentanaNotas.getContentPane().add(panelNuevo);
        frameVentanaNotas.setVisible(true);
    }

    public void actualizaPanelVerTodas() throws BeerBarException {
        new ControladorInicio().actualizarInformacion();
        notasTotales = new ControladorServidorDeMensajeria().dameTodasNotas();
        panelVerTodasLasNotas = new JPanelVerNotas(notasTotales, true, "admin", ventanaNotasAdministrador);
        actualizarPanel(panelVerTodasLasNotas);
    }
}
