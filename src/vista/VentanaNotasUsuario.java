package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNotasUsuario extends JFrame {

    JPanel panelNotas, panelPruebaA, panelPruebaB;
    JButton botonNuevaNota;
    JMenuBar barraMenu;
    JMenu menu;
    JMenuItem pruebaA, pruebaB;
    JFrame frameVentanaNotas;

    public VentanaNotasUsuario(){

        frameVentanaNotas = this;

        this.setTitle("Notas usuario");
        this.setSize(new Dimension(800, 600));

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");
        pruebaA = new JMenuItem("Pantalla verde");
        pruebaB = new JMenuItem("Pantalla azul");
        menu.add(pruebaA);
        menu.add(pruebaB);
        barraMenu.add(menu);
        this.setJMenuBar(barraMenu);

        panelPruebaA = new JPanel();
        panelPruebaA.setSize(800, 600);
        panelPruebaA.setBackground(Color.GREEN);

        panelPruebaB = new JPanel();
        panelPruebaB.setSize(800, 600);
        panelPruebaB.setBackground(Color.BLUE);

        pruebaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelPruebaA);
                frameVentanaNotas.setVisible(true);
            }
        });

        pruebaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameVentanaNotas.getContentPane().removeAll();
                frameVentanaNotas.getContentPane().repaint();
                frameVentanaNotas.getContentPane().revalidate();
                frameVentanaNotas.getContentPane().add(panelPruebaB);
                frameVentanaNotas.setVisible(true);
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
