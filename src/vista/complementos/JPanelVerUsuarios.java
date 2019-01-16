package vista.complementos;

import controlador.ControladorGestorDeUsuarios;
import modelo.BeerBarException;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class JPanelVerUsuarios extends JPanel {

    JPanel panelDentroScrollUsuarios;
    JScrollPane panelScrollUsuarios;

    public JPanelVerUsuarios() throws BeerBarException {

        this.setBackground(new Color(128, 128, 128));
        this.setSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());

        panelDentroScrollUsuarios = new JPanel();
        panelDentroScrollUsuarios.setLayout(new BoxLayout(panelDentroScrollUsuarios, BoxLayout.PAGE_AXIS));
        panelDentroScrollUsuarios.setBorder(new EmptyBorder(new Insets(10, 10, 10,10)));
        panelScrollUsuarios = new JScrollPane(panelDentroScrollUsuarios);
        panelScrollUsuarios.getVerticalScrollBar().setUnitIncrement(40);
        this.add(panelScrollUsuarios, BorderLayout.CENTER);
        panelDentroScrollUsuarios.setBackground(new Color(128, 128, 128));

        actualizarUsuarios();
    }

    public void actualizarUsuarios() throws BeerBarException{

        ArrayList<Usuario> arr = new ControladorGestorDeUsuarios().devuelveUsuarios();
        while (!arr.isEmpty()){
            Usuario usuario = arr.get(0);
            panelDentroScrollUsuarios.add(new JTextArea("----------\nUsuario: " +
                    usuario.getNombre() + "\nCotrasena: " + usuario.getContrasena() +
                    "\n----------"));
            arr.remove(0);
        }
    }
}
