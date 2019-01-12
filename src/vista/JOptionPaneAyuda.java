package vista;

import javax.swing.*;

public class JOptionPaneAyuda extends JOptionPane {

    JPanel panelActual;

    public JOptionPaneAyuda(JPanel panelActual){

        this.panelActual = panelActual;
    }

    public void muestraAyudaBienvenida(){

        String mensaje =
                "Esta es la pantalla de inicio del programa. Pulsa el boton 'Entrar'\n" +
                "para acceder a la pantalla de inicio de sesion. La primera vez\n" +
                "que se inicie el programa se creara un usuario administrador con nombre\n" +
                        "'admin' y contrasena 'admin'.";

        this.showMessageDialog(panelActual,mensaje, "Ayuda ventana bienvenida", JOptionPane.INFORMATION_MESSAGE);
    }
}
