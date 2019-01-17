package vista.complementos;

import controlador.ControladorCalendario;
import modelo.BeerBarException;
import modelo.Fecha;
import modelo.Transaccion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelVerTransacciones extends JPanel {

    JPanel panelDentroScroll;
    JScrollPane panelScroll;

    public JPanelVerTransacciones(String fechaInicioString, String fechaFinalString) throws BeerBarException {

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

        /*if (fechaFinalString.equals("")) {
            transacciones = new ControladorJornada().getTransacciones(fechaString);
        } else {
            transacciones = new ControladorCalendario().getTransaccionesEntreDosFechas(fechaString, fechaFinalString);
        }*/

        transacciones = new ControladorCalendario().obtenTransaccionesEnRango(new Fecha().fromStringAbreviadoToFecha(fechaInicioString), new Fecha().fromStringAbreviadoToFecha(fechaFinalString));

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
                    new VentanaTransaccionIndividual(transaccionActual);
                }
            });

            panelDentroScroll.add(boton);
            transacciones.remove(0);
        }
    }
}
