package controlador;

import bbdd.DAONotas;
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
        //crea las jornadas
        for(Transaccion t:transacciones){
            if(!calendario.existeDia(t.getFecha())){
                Jornada j = new Jornada(t.getFecha(), new ArrayList<Transaccion>());
                instancia.anadirJornada(j);
            }
        }
        //rellena las jornadas
        for(Transaccion t:transacciones){
            Jornada j = instancia.getJornada(t.getFecha());
            j.anadirTransaccion(t);
        }
    }

    public Jornada devuelveJornada(Fecha f){
        return instancia.getJornada(f);
    }

    public float obtenerBeneficiosEnRango(Fecha fechainicio, Fecha fechafin){
        return instancia.obtenerBeneficios(fechainicio, fechafin);
    }

    public ArrayList<Transaccion> obtenTransaccionesEnRango(Fecha fechainicio, Fecha fechafinal){
        return instancia.verTransaccionesDeLosDias(fechainicio, fechafinal);
    }


    public ArrayList<Transaccion> verTransaccionesDeEnRango(Fecha fechainicio, Fecha fechafinal, Usuario usuario){
        return instancia.verTransaccionesDe(fechainicio, fechafinal, usuario);
    }

    public ArrayList<Transaccion> verTodasLasTransaccionesDe(Usuario u){
        return instancia.verTodasDe(u);
    }


    public void introduceTransaccion(float cantidad, String concepto, Fecha fecha, Usuario usuario){
        Jornada jornada = instancia.getJornada(fecha);
        if(jornada == null){
            jornada = new Jornada(fecha, new ArrayList<Transaccion>());
            instancia.anadirJornada(jornada);
        }
        //anade al singleton
        jornada.anadirTransaccion(new Transaccion(cantidad, concepto, fecha, usuario));

        //anade a la BBDD, hay que cambiar esto, lo se.
        new DAOTransacciones().introduceTransaccion(cantidad, fecha.toStringAbreviado(), usuario.getNombre(), concepto);
    }
}
