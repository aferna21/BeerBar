package vista;

import controlador.ControladorGestorDeUsuarios;
import modelo.BeerBarException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JButton comenzarButton;
    private JPanel panel1;

    public Login() {
        JFrame ventana = new JFrame();
        ventana.add(panel1);
        panel1.setLayout(new BorderLayout());
        panel1.add(comenzarButton, BorderLayout.SOUTH);
        panel1.add(new JLabel("Bienvenido a Beerbar"), BorderLayout.CENTER);

        ventana.setSize(200, 300);

        ventana.setTitle("Ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        iniciarSesion();
    }

    public void iniciarSesion(){
        comenzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame iniciosesion = new JFrame();
                iniciosesion.setSize(200, 300);
                JPanel panel = new JPanel();
                iniciosesion.add(panel);
                JTextPane user = new JTextPane();
                JTextPane pass = new JTextPane();
                JButton dale = new JButton("Iniciar sesion");
                panel.add(user);
                panel.add(pass);
                panel.add(dale);


                dale.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ControladorGestorDeUsuarios c = null;
                        try {
                            c = new ControladorGestorDeUsuarios();
                        } catch (BeerBarException e) {
                            e.printStackTrace();
                        }
                        boolean b = c.autenticar(user.getText(), pass.getText());
                        System.out.println(b);
                    }
                });

                iniciosesion.setTitle("Iniciar sesion");
                iniciosesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                iniciosesion.setLocationRelativeTo(null);

                iniciosesion.setVisible(true);
            }
        });
    }
}
