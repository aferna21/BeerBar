package vista;

import javax.swing.*;

public class JTextAreaTransacciones extends JTextArea {

    public JTextAreaTransacciones(Boolean esVenta, String usuario, String fecha, String importe){

        if(esVenta){
            this.setText("----------\nTipo: Venta" + "\nUsuario: " + usuario + "\nFecha: " + fecha + "\nImporte: " + importe + "\n----------\n");
        }
        else{
            this.setText("----------\nTipo: Gasto" + "\nUsuario: " + usuario + "\nFecha: " + fecha + "\nImporte: " + importe + "\n----------\n");
        }
        this.setEditable(false);
    }
}
