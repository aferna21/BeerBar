package vista;

import javax.swing.*;

public class JTextAreaTransacciones extends JTextArea {

    public JTextAreaTransacciones(Boolean esVenta, String usuario, String fecha, String importe, String concepto){

        if(esVenta){
            this.setText("----------\nTipo: Venta" + "\nUsuario: " + usuario + "\nFecha: " + fecha + "\nImporte: " + importe + "\nConcepto: " + concepto + "\n----------\n");
        }
        else{
            this.setText("----------\nTipo: Gasto" + "\nUsuario: " + usuario + "\nFecha: " + fecha + "\nImporte: " + importe + "\nConcepto: " + concepto +  "\n----------\n");
        }
        this.setEditable(false);
    }
}
