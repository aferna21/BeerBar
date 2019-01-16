package vista.complementos;

import controlador.ControladorJornada;
import modelo.BeerBarException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelIntroducirTransaccion extends JPanel {

    JPanel panelTransaccion;
    JLabel textoImporte, textoConcepto;
    JTextField campoTextoImporte;
    JTextArea campoConcepto;
    JButton botonIntroducirTransaccion;

    public JPanelIntroducirTransaccion(boolean esVenta, String nombreUsuario, String fechaString){

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelTransaccion = new JPanel();
        panelTransaccion.setBackground(new Color(128, 128, 128));
        panelTransaccion.setLayout(new BoxLayout(panelTransaccion, BoxLayout.PAGE_AXIS));
        this.add(panelTransaccion, BorderLayout.NORTH);

        textoImporte = new JLabel();
        if(esVenta){
            textoImporte.setText("Importe de la venta");
        }
        else{
            textoImporte.setText("Importe del gasto");
        }
        campoTextoImporte = new JTextField();
        textoConcepto = new JLabel("Concepto");
        campoConcepto = new JTextArea();

        panelTransaccion.add(textoImporte);
        panelTransaccion.add(campoTextoImporte);
        panelTransaccion.add(textoConcepto);
        this.add(campoConcepto, BorderLayout.CENTER);

        botonIntroducirTransaccion = new JButton();
        if(esVenta){
            botonIntroducirTransaccion.setText("Introducir venta");
        }
        else{
            botonIntroducirTransaccion.setText("Introducir gasto");
        }
        botonIntroducirTransaccion.setBackground(new Color(0, 38, 77));
        botonIntroducirTransaccion.setForeground(Color.WHITE);
        botonIntroducirTransaccion.setOpaque(true);
        botonIntroducirTransaccion.setBorderPainted(false);
        botonIntroducirTransaccion.setPreferredSize(new Dimension(10, 40));
        this.add(botonIntroducirTransaccion, BorderLayout.SOUTH);
        this.setBorder(new EmptyBorder(new Insets(10,10, 10, 10)));

        botonIntroducirTransaccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                //Introducir en la jornada la venta

                String s = campoTextoImporte.getText();
                Float f = Float.parseFloat(s);

                if (esVenta){
                    try {

                        new ControladorJornada().introducirTransaccion(f, campoConcepto.getText(), nombreUsuario, fechaString);
                    } catch (BeerBarException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    try {
                        new ControladorJornada().introducirTransaccion(-f, campoConcepto.getText(), nombreUsuario, fechaString);
                    } catch (BeerBarException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
