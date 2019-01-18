package vista.complementos;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class VentanaVerTransaccionesEntreDosFechas extends JFrame {

    JPanel panelVerEntreDosFechas, panelSelector, panelTransacciones;
    JMenu ayuda;
    JMenuBar barraMenu;
    JMenuItem opcionAyuda, opcionAyudaGeneral;
    JLabel textoJornadaPrincipio, textoJornadaFinal;
    JDateChooser dateChooserJornadaInicio, dateChooserJornadaFinal;
    JButton botonAceptar;
    JFrame frameThisVentana;


    public VentanaVerTransaccionesEntreDosFechas(){

        frameThisVentana = this;

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelVerEntreDosFechas = new JPanel();
        panelVerEntreDosFechas.setLayout(new BorderLayout());

        opcionAyuda = new JMenuItem("Ayuda");
        ayuda = new JMenu("Ayuda");
        barraMenu = new JMenuBar();
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelSelector = new JPanel();
        panelSelector.setBackground(new Color(128, 128, 128));
        panelSelector.setLayout(new BoxLayout(panelSelector, BoxLayout.PAGE_AXIS));

        panelTransacciones = new JPanel();
        panelTransacciones.setLayout(new BoxLayout(panelTransacciones, BoxLayout.PAGE_AXIS));

        textoJornadaPrincipio = new JLabel("Selecciona la fecha de inicio.");
        dateChooserJornadaInicio = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        textoJornadaFinal = new JLabel("Selecciona la fecha final.");
        dateChooserJornadaFinal = new JDateChooser(null, null, null, new JSpinnerDateEditor());

        panelSelector.add(textoJornadaPrincipio);
        panelSelector.add(dateChooserJornadaInicio);
        panelVerEntreDosFechas.add(panelSelector, BorderLayout.NORTH);
        panelVerEntreDosFechas.add(panelTransacciones, BorderLayout.CENTER);

        panelSelector.add(textoJornadaFinal);
        panelSelector.add(dateChooserJornadaFinal);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBackground(new Color(0, 38, 77));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setOpaque(true);
        botonAceptar.setBorderPainted(false);
        botonAceptar.setPreferredSize(new Dimension(10, 40));
        this.add(botonAceptar, BorderLayout.SOUTH);
        panelSelector.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        this.getContentPane().add(panelVerEntreDosFechas);

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = dateFormat.format(dateChooserJornadaInicio.getDate());
                String fechaFinal = dateFormat.format(dateChooserJornadaFinal.getDate());
                try {
                    panelTransacciones = new JPanelVerTransacciones(fechaInicio, fechaFinal);
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                actualizarPanel(panelVerEntreDosFechas);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameThisVentana.getContentPane());
                ayuda.muestraAyudaVentanaVerTransaccionesEntreDosFechas();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    public void actualizarPanel(JPanel panelNuevo){
        frameThisVentana.removeAll();
        frameThisVentana.repaint();
        frameThisVentana.revalidate();
        frameThisVentana.add(panelNuevo);
        frameThisVentana.setVisible(true);
    }
}
