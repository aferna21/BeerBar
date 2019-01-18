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

public class VentanaNotasUsuario extends JFrame {

    JPanel panelNotas, panelEscribirNotaA, panelVerNotasRecibidas, panelVerNotasEnviadas;
    JMenuBar barraMenu;
    JMenu acciones, ayuda;
    JMenuItem opcionEscribirNota, opcionVerNotasRecibidas, opcionVerNotasEnviadas, opcionAyuda, opcionAyudaGeneral;
    JFrame frameVentanaNotas;
    String nombreUsuario;
    ArrayList<Nota> notasRecibidas, notasEnviadas;

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
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
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


        opcionEscribirNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEscribirNotaA = new JPanelEscribirNota(nombreUsuario, frameVentanaNotas);
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
                notasRecibidas = new ControladorServidorDeMensajeria().devuelveNotasHacia(nombreUsuario);
                panelVerNotasRecibidas = new JPanelVerNotas(notasRecibidas, false, nombreUsuario, null);
                actualizarPanel(panelVerNotasRecibidas);
            }
        });


        opcionVerNotasEnviadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notasEnviadas = new ControladorServidorDeMensajeria().devuelveNotasEscritasPor(nombreUsuario);
                panelVerNotasEnviadas = new JPanelVerNotas(notasEnviadas, true, nombreUsuario, null);
                actualizarPanel(panelVerNotasEnviadas);
            }
        });


        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameVentanaNotas.getContentPane());
                ayuda.muestraAyudaNotasUsuario();
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
}
