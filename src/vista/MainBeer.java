package vista;

import bbdd.DAONotas;
import controlador.ControladorInicio;
import controlador.ControladorServidorDeMensajeria;
import modelo.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        /*new VentanaBienvenida();
        new ControladorInicio().actualizarInformacion();
        Nota nota = new ControladorServidorDeMensajeria().crearNota("holaaa2", "Felipe", "Adri");
        new ControladorServidorDeMensajeria().escribirNota("holaaa", "Felipe", "Adri", null);
        System.out.println(ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Felipe")).get(0).getTexto());

        //new ControladorServidorDeMensajeria().responderNota(nota, "nota de respuesta2", "Felipe", "Adri");*/
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(0);
        a.add(0);
        pollita(a);
        System.out.println(a.get(3));


    }

    private static void pollita(ArrayList<Integer> a){
        a.add(3);

    }
}
