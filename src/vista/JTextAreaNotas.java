package vista;

import javax.swing.*;

public class JTextAreaNotas extends JTextArea{

    public JTextAreaNotas(String origen, String destinatario, String fecha, String mensaje){

        this.setText("----------\nOrigen: " + origen + "\nDestinatario: " + destinatario + "\nFecha: " + fecha + "\nMensaje: " + mensaje + "\n----------\n");
        this.setEditable(false);
    }
}
