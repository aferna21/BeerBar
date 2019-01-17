package controlador;

import bbdd.DAOTransacciones;
import modelo.*;

import java.util.ArrayList;


public class ControladorCalendario {

    Calendario instancia;

    public ControladorCalendario(){
        instancia = Calendario.darInstancia();
    }


    public ArrayList<Transaccion> getTransacciones(String fechaString) throws BeerBarException {

        Fecha f = new Fecha().fromStringAbreviadoToFecha(fechaString);
        return instancia.verTransaccionesDeLosDias(f, f);
    }
}
