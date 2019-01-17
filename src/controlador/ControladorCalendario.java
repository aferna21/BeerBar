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


    public void rellenaCalendario() throws BeerBarException {
        ArrayList<Transaccion> transacciones = new DAOTransacciones().devuelveTransacciones();
        Calendario calendario = Calendario.darInstancia();
        for(Transaccion t:transacciones){
            if(!calendario.existeDia(t.getFecha())){
                Jornada j = new Jornada(t.getFecha(), new ArrayList<Transaccion>());
                instancia.anadirJornada(j);
            }
        }

        for(Transaccion t:transacciones){
            Jornada j = instancia.getJornada(t.getFecha());
            j.anadirTransaccion(t);
        }
    }
}
