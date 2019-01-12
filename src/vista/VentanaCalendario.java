package vista;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VentanaCalendario extends JFrame {

    JCalendar calendar;
    JPanel panelCalendario;

    public VentanaCalendario(){

        this.setTitle("Calendario");
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);

        panelCalendario = new JPanel();
        panelCalendario.setLayout(new BorderLayout());
        panelCalendario.setSize(new Dimension(800, 600));
        panelCalendario.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        calendar = new JCalendar();
        calendar.setTodayButtonVisible(true);
        calendar.setTodayButtonText("Dia de hoy");
        calendar.setNullDateButtonVisible(true);
        calendar.setNullDateButtonText("Sin fecha");
        calendar.setForeground(Color.GREEN);
        calendar.setSundayForeground(Color.BLUE);
        calendar.setWeekdayForeground(Color.RED);
        Calendar cal = new GregorianCalendar(2019, 1, 1);
        calendar.setDate(cal.getTime());
        calendar.setMinSelectableDate(new Date(2019, 1, 1));
        calendar.setMaxSelectableDate(new Date(2020, 1, 1));
        panelCalendario.add(calendar, BorderLayout.CENTER);

        this.getContentPane().add(panelCalendario);

        this.setMinimumSize(new Dimension(400, 300));
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }
}
