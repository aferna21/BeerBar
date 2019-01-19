package vista.complementos;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;
import controlador.ControladorCalendario;
import modelo.BeerBarException;
import modelo.Fecha;
import vista.principal.VentanaAyudaGeneral;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class VentanaVerTransaccionesEntreDosFechas extends JFrame {

    JPanel panelVerEntreDosFechas, panelSelector, panelTransacciones;
    JMenu acciones, ayuda;
    JMenuBar barraMenu;
    JMenuItem opcionSuma, opcionAyuda, opcionAyudaGeneral;
    JLabel textoJornadaPrincipio, textoJornadaFinal;
    JDateChooser dateChooserJornadaInicio, dateChooserJornadaFinal;
    JButton botonAceptar;
    JFrame frameThisVentana;


    public VentanaVerTransaccionesEntreDosFechas(){

        frameThisVentana = this;

        this.setBackground(new Color(128, 128, 128));
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        panelVerEntreDosFechas = new JPanel();
        panelVerEntreDosFechas.setLayout(new BorderLayout());

        opcionAyuda = new JMenuItem("Ayuda");
        ayuda = new JMenu("Ayuda");
        acciones = new JMenu("Acciones");
        opcionSuma = new JMenuItem("Suma de todas las transacciones");
        barraMenu = new JMenuBar();
        opcionAyudaGeneral = new JMenuItem("Menú de ayuda");
        acciones.add(opcionSuma);
        ayuda.add(opcionAyuda);
        ayuda.add(opcionAyudaGeneral);
        barraMenu.add(acciones);
        barraMenu.add(ayuda);
        this.setJMenuBar(barraMenu);

        panelSelector = new JPanel();
        panelSelector.setBackground(new Color(128, 128, 128));
        panelSelector.setLayout(new BoxLayout(panelSelector, BoxLayout.PAGE_AXIS));

        panelTransacciones = new JPanel();
        panelTransacciones.setLayout(new BoxLayout(panelTransacciones, BoxLayout.PAGE_AXIS));

        textoJornadaPrincipio = new JLabel("Selecciona la fecha de inicio.");
        dateChooserJornadaInicio = new JDateChooser(null, null, null, new JSpinnerDateEditor());
        textoJornadaFinal = new JLabel("Selecciona la fecha final.");
        dateChooserJornadaFinal = new JDateChooser(null, null, null, new JSpinnerDateEditor());

        panelSelector.add(textoJornadaPrincipio);
        panelSelector.add(dateChooserJornadaInicio);
        panelVerEntreDosFechas.add(panelSelector, BorderLayout.NORTH);
        panelVerEntreDosFechas.add(panelTransacciones, BorderLayout.CENTER);

        panelSelector.add(textoJornadaFinal);
        panelSelector.add(dateChooserJornadaFinal);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBackground(new Color(0, 38, 77));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setOpaque(true);
        botonAceptar.setBorderPainted(false);
        botonAceptar.setPreferredSize(new Dimension(10, 40));
        this.add(botonAceptar, BorderLayout.SOUTH);
        panelSelector.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        this.getContentPane().add(panelVerEntreDosFechas);

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dateChooserJornadaFinal.getDate() != null && dateChooserJornadaInicio.getDate() != null) {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaInicio = dateFormat.format(dateChooserJornadaInicio.getDate());
                    String fechaFinal = dateFormat.format(dateChooserJornadaFinal.getDate());

                    try {
                        if (new ControladorCalendario().esMasTardia(new Fecha().fromStringAbreviadoToFecha(fechaInicio), new Fecha().fromStringAbreviadoToFecha(fechaFinal))) {
                            JOptionPane errorFechas = new JOptionPane();
                            errorFechas.showMessageDialog(frameThisVentana.getContentPane(), "Introduzca las fechas en el orden correcto.");
                            return;
                        }
                    } catch (BeerBarException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        panelTransacciones = new JPanelVerTransacciones(fechaInicio, fechaFinal);
                    } catch (BeerBarException e1) {
                        e1.printStackTrace();
                    }

                    actualizarPanel(panelTransacciones);

                }else{
                    JOptionPane errorFechasVacias = new JOptionPane();
                    errorFechasVacias.showMessageDialog(frameThisVentana.getContentPane(), "No deje las fechas vacías.");
                }
            }
        });

        opcionSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = dateFormat.format(dateChooserJornadaInicio.getDate());
                String fechaFinal = dateFormat.format(dateChooserJornadaFinal.getDate());
                float sumaTotal = new ControladorCalendario().sumaTransaccionesDeLosDias(fechaInicio, fechaFinal);
                JOptionPane panelSuma = new JOptionPane();
                panelSuma.showMessageDialog(frameThisVentana.getContentPane(), "Suma de las transacciones: " + sumaTotal);
            }
        });

        opcionAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPaneAyuda ayuda = new JOptionPaneAyuda((JPanel) frameThisVentana.getContentPane());
                ayuda.muestraAyudaVentanaVerTransaccionesEntreDosFechas();
            }
        });

        opcionAyudaGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAyudaGeneral();
            }
        });

        this.setMinimumSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    }

    public void actualizarPanel(JPanel panelNuevo){
        frameThisVentana.getContentPane().removeAll();
        frameThisVentana.getContentPane().repaint();
        frameThisVentana.getContentPane().revalidate();
        frameThisVentana.getContentPane().add(panelNuevo);
        frameThisVentana.setVisible(true);
    }
}
