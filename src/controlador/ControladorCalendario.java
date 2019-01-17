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

    public Jornada accederAJornada(Fecha f){
        Jornada jornada = instancia.getJornada(f);
        if(jornada == null){
            jornada = new Jornada(f, new ArrayList<Transaccion>());
            instancia.anadirJornada(jornada);
        }
        return jornada;
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


    //Aqui no se si cambiar el atributo fecha por directamente el atributo jornada. Yo creo que si, pero ya lo veras tu.
    public void introduceTransaccion(float cantidad, String concepto, Fecha fecha, Usuario usuario){
        Jornada jornada = instancia.getJornada(fecha);
        //anade al singleton
        jornada.anadirTransaccion(new Transaccion(cantidad, concepto, fecha, usuario));

        //anade a la BBDD, hay que cambiar esto, lo se.
        new DAOTransacciones().introduceTransaccion(cantidad, fecha.toStringAbreviado(), usuario.getNombre(), concepto);
    }
}
