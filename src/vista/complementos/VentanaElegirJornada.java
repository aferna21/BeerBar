package vista.complementos;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import vista.principal.VentanaTransacciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaElegirJornada extends JFrame {

    JPanel panelSelector;
    JLabel textoSeleccion;
    JDateChooser dateChooserJornada;
    JButton botonAceptar;
    JFrame frameElegir;

    public VentanaElegirJornada() {

        frameElegir = this;

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
                new VentanaTransacciones();
                frameElegir.dispose();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
