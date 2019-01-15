package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaNotaIndividual extends JFrame {

    JPanel panelVentanaNota;
    JFrame frameVentanaNota;

    public VentanaNotaIndividual(){

        frameVentanaNota = this;

        this.setTitle("Nota individual");
        this.setSize(new Dimension(600, 400));

        panelVentanaNota = new JPanel();

        this.setMinimumSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
