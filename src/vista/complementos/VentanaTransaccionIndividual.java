package vista.complementos;

import modelo.Transaccion;

import javax.swing.*;
import java.awt.*;

public class VentanaTransaccionIndividual extends JFrame {

    JPanel panelVentanaTransaccion, panelRemitente, panelTextoTransaccion;
    JFrame frameVentanaNota;
    JLabel textoRemitente, textoCantidad, textoFecha, textoEsVenta, textoMensaje, textoConcepto;

    public VentanaTransaccionIndividual(Transaccion transaccion) {

        frameVentanaNota = this;

        this.setTitle("Transaccion individual");
        this.setSize(new Dimension(600, 400));

        panelVentanaTransaccion = new JPanel();
        panelVentanaTransaccion.setBackground(new Color(128, 128, 128));
        panelVentanaTransaccion.setSize(600, 400);
        panelVentanaTransaccion.setLayout(new BorderLayout());

        panelRemitente = new JPanel();
        panelRemitente.setBackground(new Color(128, 128, 128));
        panelRemitente.setLayout(new BoxLayout(panelRemitente, BoxLayout.PAGE_AXIS));
        panelVentanaTransaccion.add(panelRemitente, BorderLayout.NORTH);

        textoRemitente = new JLabel("Creador: " + transaccion.getUsuario().toString());
        textoCantidad = new JLabel("Cantidad: " + transaccion.getCantidad());
        textoEsVenta = new JLabel();
        if (transaccion.getEsVenta()) {
            textoEsVenta.setText("Es una venta");
        } else {
            textoEsVenta.setText("Es un gasto");
        }
        textoFecha = new JLabel("Fecha: " + transaccion.getFecha().toString());
        textoMensaje = new JLabel("Concepto: ");
        panelRemitente.add(textoRemitente);
        panelRemitente.add(textoCantidad);
        panelRemitente.add(textoEsVenta);
        panelRemitente.add(textoFecha);
        panelRemitente.add(textoMensaje);

        panelTextoTransaccion = new JPanel();
        panelVentanaTransaccion.add(panelTextoTransaccion, BorderLayout.CENTER);

        textoConcepto = new JLabel(transaccion.getConcepto());
        panelTextoTransaccion.add(textoConcepto);

        this.getContentPane().add(panelVentanaTransaccion);

        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
