package vista;

import javax.swing.*;

public class JTextAreaUsuarios extends JTextArea {

    public JTextAreaUsuarios(String nombre, String contrasena){

        this.setText("----------\nNombre: " + nombre + "\nContrasena: " + contrasena + "\n----------\n");
    }
}
