package vista.complementos;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVerTransaccionesEntreDosFechas extends JFrame {

    JPanel panelSelector;
    JMenu ayuda;
    JMenuBar barraMenu;
    JMenuItem opcionAyuda;
    JLabel textoJornadaPrincipio, textoJornadaFinal;
    JDateChooser dateChooserJornadaInicio, dateChooserJornadaFinal;
    JButton botonAceptar;
    JFrame frameThisVentana;


    public VentanaVerTransaccionesEntreDosFechas(){

        frameThisVentana = this;

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        opcionAyuda = new JMenuItem("Ayuda");
        ayuda = new JMenu("Ayuda");
        barraMenu = new JMenuBar();
        ayuda.add(opcionAyuda);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelSelector = new JPanel();
        panelSelector.setBackground(new Color(128, 128, 128));
        panelSelector.setLayout(new BoxLayout(panelSelector, BoxLayout.PAGE_AXIS));

        textoJornadaPrincipio = new JLabel("Selecciona la fecha de inicio.");
        dateChooserJornadaInicio = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        textoJornadaFinal = new JLabel("Selecciona la fecha final.");
        dateChooserJornadaFinal = new JDateChooser(null, null, null, new JSpinnerDateEditor());

        panelSelector.add(textoJornadaPrincipio);
        panelSelector.add(dateChooserJornadaInicio);
        this.add(panelSelector, BorderLayout.NORTH);

        panelSelector.add(textoJornadaFinal);
        panelSelector.add(dateChooserJornadaFinal);

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
                //TODO

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
}
