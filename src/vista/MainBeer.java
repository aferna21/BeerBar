package vista;

import bbdd.DAONotas;
import controlador.ControladorInicio;
import controlador.ControladorServidorDeMensajeria;
import modelo.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        new VentanaBienvenida();
        new ControladorInicio().actualizarInformacion();
        Nota nota = new ControladorServidorDeMensajeria().crearNota("holaaa2", "Felipe", "Adri");
        new ControladorServidorDeMensajeria().escribirNota("holaaa", "Felipe", "Adri", null);
        System.out.println(ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Felipe")).get(0).getTexto());

        //new ControladorServidorDeMensajeria().responderNota(nota, "nota de respuesta2", "Felipe", "Adri");

    }
}
