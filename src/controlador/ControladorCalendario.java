package controlador;

import bbdd.DAOTransacciones;
import modelo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ControladorCalendario {

    Calendario instancia;

    public ControladorCalendario(){
        instancia = Calendario.darInstancia();
    }

    public ArrayList<Transaccion> getTransaccionesEntreDosFechas(String fechaInicioString, String fechaFinalString) throws BeerBarException {


        Fecha fechaInicio = new Fecha().fromStringAbreviadoToFecha(fechaInicioString);
        Fecha fechaFinal = new Fecha().fromStringAbreviadoToFecha(fechaFinalString);
        Fecha fechaAux = fechaInicio;

        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();

        Jornada.darInstancia().setFecha(fechaInicio);
        System.out.println(Jornada.darInstancia().getFecha());

        while (!fechaAux.equals(fechaFinal)){
            transacciones.addAll(Jornada.darInstancia().getTransacciones());
            System.out.println("Transacciones en la Jornada: " + Jornada.darInstancia().getTransacciones().size());
            fechaAux.avanza();
        }


        return transacciones;
        //return instancia.verTransaccionesDeLosDias(fechaInicio, fechaFinal);
    }
}
