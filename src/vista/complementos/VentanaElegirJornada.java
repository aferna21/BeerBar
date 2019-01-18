package vista.complementos;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import modelo.BeerBarException;
import vista.principal.VentanaTransacciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class VentanaElegirJornada extends JFrame {

    JPanel panelSelector;
    JMenuItem opcionVerTransaccionesEntreDosFechas, opcionAyuda, opcionAyudaGeneral;
    JMenu acciones, ayuda;
    JMenuBar barraMenu;
    JLabel textoSeleccion;
    JDateChooser dateChooserJornada;
    JButton botonAceptar;
    JFrame frameElegir;

    public VentanaElegirJornada(String nombreUsuario) {

        frameElegir = this;

        barraMenu = new JMenuBar();
        acciones = new JMenu("Acciones");
        ayuda = new JMenu("Ayuda");
        opcionVerTransaccionesEntreDosFechas = new JMenuItem("Ver transacciones entre 2 fechas");
        opcionAyuda = new JMenuItem("Ayuda");
        acciones.add(opcionVerTransaccionesEntreDosFechas);
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelSelector = new JPanel();
        panelSelector.setBackground(new Color(128, 128, 128));
        panelSelector.setLayout(new BoxLayout(panelSelector, BoxLayout.PAGE_AXIS));

        textoSeleccion = new JLabel("Selecciona una jornada");
        dateChooserJornada = new JDateChooser(null, null, null, new JSpinnerDateEditor());

        panelSelector.add(textoSeleccion);
        panelSelector.add(dateChooserJornada);
        this.add(panelSelector, BorderLayout.NORTH);


        botonAceptar = new JButton("Enviar");
        botonAceptar.setBackground(new Color(0, 38, 77));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setOpaque(true);
        botonAceptar.setBorderPainted(false);
        botonAceptar.setPreferredSize(new Dimension(10, 40));
        this.add(botonAceptar, BorderLayout.SOUTH);
        panelSelector.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = dateFormat.format(dateChooserJornada.getDate());

                try {
                    new VentanaTransacciones(nombreUsuario, dateString);
                } catch (BeerBarException e1) {
                    e1.printStackTrace();
                }
                frameElegir.dispose();
            }
        });

        opcionVerTransaccionesEntreDosFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaVerTransaccionesEntreDosFechas();
                frameElegir.dispose();
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameElegir.getContentPane());
                ayuda.muestraAyudaVentanaElegirNota();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
