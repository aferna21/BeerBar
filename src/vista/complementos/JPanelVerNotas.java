package vista.complementos;

import controlador.ControladorInicio;
import controlador.ControladorServidorDeMensajeria;
import modelo.BeerBarException;
import modelo.Nota;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanelVerNotas extends JPanel{

    JPanel panelDentroScroll;
    JScrollPane panelScroll;

    public JPanelVerNotas(ArrayList<Nota> notas, boolean sonEnviadas){

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

        while (!notas.isEmpty()){
            Nota notaActual = notas.get(0);
            JButton boton = new JButton(
                    "<html>Remitente: " + notaActual.getRemitente() + "<br/>" +
                            "Destinatario: " + notaActual.getDestinatario() + "<br/>" +
                            "Fecha: " + notaActual.getFecha().toString() + "<br/><html/>");
            boton.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

            if (notaActual.esLeida()) {
                boton.setBackground(new Color(140, 255, 102));
            } else {
                boton.setBackground(new Color(255, 128, 128));
            }

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!sonEnviadas) {
                        boton.setBackground(new Color(140, 255, 102));
                        new ControladorServidorDeMensajeria().leerNota(notaActual);
                    }
                    new VentanaNotaIndividual(notaActual);
                    try {
                        new ControladorInicio().actualizarInformacion();
                    } catch (BeerBarException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            panelDentroScroll.add(boton);
            notas.remove(0);
        }
    }
}
