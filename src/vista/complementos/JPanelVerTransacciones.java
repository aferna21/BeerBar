package vista.complementos;

import controlador.ControladorCalendario;
import controlador.ControladorJornada;
import modelo.BeerBarException;
import modelo.Nota;
import modelo.Transaccion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JPanelVerTransacciones extends JPanel {

    JPanel panelDentroScroll;
    JScrollPane panelScroll;

    public JPanelVerTransacciones(String fechaString, String fechaFinalString) throws BeerBarException {

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelDentroScroll = new JPanel();
        panelDentroScroll.setLayout(new BoxLayout(panelDentroScroll, BoxLayout.PAGE_AXIS));
        panelDentroScroll.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        panelScroll = new JScrollPane(panelDentroScroll);
        panelScroll.getVerticalScrollBar().setUnitIncrement(40);
        this.add(panelScroll, BorderLayout.CENTER);
        panelDentroScroll.setBackground(new Color(128, 128, 128));

        ArrayList<Transaccion> transacciones;
        //TODO
        if (fechaFinalString.equals("")) {
            transacciones = new ControladorJornada().getTransacciones(fechaString);
        } else {
            transacciones = new ControladorCalendario().getTransaccionesEntreDosFechas(fechaString, fechaFinalString);
        }

        while (!transacciones.isEmpty()){
            Transaccion transaccionActual = transacciones.get(0);
            JButton boton = new JButton(
                    "<html>Creador: " + transaccionActual.getUsuario().toString() + "<br/>" +
                            "Cantidad: " + transaccionActual.getCantidad() + "<br/>" +
                            "Fecha: " + transaccionActual.getFecha().toString() + "<br/><html/>");
            boton.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

            if(transaccionActual.getEsVenta()){
                boton.setBackground(new Color(140, 255, 102));
            }
            else {
                boton.setBackground(new Color(255, 128, 128));
            }

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boton.setBackground(new Color(140, 255, 102));
                    new VentanaTransaccionIndividual(transaccionActual);
                }
            });

            panelDentroScroll.add(boton);
            transacciones.remove(0);
        }
    }
}
