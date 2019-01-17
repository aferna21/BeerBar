package controlador;

import bbdd.DAOTransacciones;
import modelo.*;

import java.util.ArrayList;


public class ControladorCalendario {

    Calendario calendario;

    public ControladorCalendario(){
        calendario = Calendario.darInstancia();
    }


    public void rellenaCalendario() throws BeerBarException {
        ArrayList<Transaccion> transacciones = new DAOTransacciones().devuelveTransacciones();
        //crea las jornadas
        for(Transaccion t:transacciones){
            if(!calendario.existeDia(t.getFecha())){
                Jornada j = new Jornada(t.getFecha(), new ArrayList<Transaccion>());
                calendario.anadirJornada(j);
            }
        }
        //rellena las jornadas
        for(Transaccion t:transacciones){
            Jornada j = calendario.getJornada(t.getFecha());
            j.anadirTransaccion(t);
        }
    }

    public Jornada accederAJornada(Fecha f){
        Jornada jornada = calendario.getJornada(f);
        if(jornada == null){
            jornada = new Jornada(f, new ArrayList<Transaccion>());
            calendario.anadirJornada(jornada);
        }
        return jornada;
    }

    public float obtenerBeneficiosEnRango(Fecha fechainicio, Fecha fechafin){
        return calendario.obtenerBeneficios(fechainicio, fechafin);
    }

    public ArrayList<Transaccion> obtenTransaccionesEnRango(Fecha fechainicio, Fecha fechafinal){
        return calendario.verTransaccionesDeLosDias(fechainicio, fechafinal);
    }

    public ArrayList<Transaccion> obtenTransaccionesDelDia(Fecha fecha){
        return calendario.verTransaccionesDelDia(fecha);
    }


    public ArrayList<Transaccion> verTransaccionesDeEnRango(Fecha fechainicio, Fecha fechafinal, Usuario usuario){
        return calendario.verTransaccionesDe(fechainicio, fechafinal, usuario);
    }

    public ArrayList<Transaccion> verTodasLasTransaccionesDe(Usuario u){
        return calendario.verTodasDe(u);
    }


    //Aqui no se si cambiar el atributo fecha por directamente el atributo jornada. Yo creo que si, pero ya lo veras tu.
    public void introduceTransaccion(float cantidad, String concepto, Fecha fecha, Usuario usuario){
        Jornada jornada = calendario.getJornada(fecha);
        //anade al singleton
        jornada.anadirTransaccion(new Transaccion(cantidad, concepto, fecha, usuario));

        //anade a la BBDD, hay que cambiar esto, lo se.
        new DAOTransacciones().introduceTransaccion(cantidad, fecha.toStringAbreviado(), usuario.getNombre(), concepto);
    }
}
