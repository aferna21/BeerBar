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

    public ArrayList<Transaccion> obtenTransaccionesEnRango(Fecha fechainicio, Fecha fechafinal){
        return calendario.verTransaccionesDeLosDias(fechainicio, fechafinal);
    }

    public ArrayList<Transaccion> obtenTransaccionesDelDia(Fecha fecha){
        return calendario.verTransaccionesDelDia(fecha);
    }

    public void introduceTransaccion(float cantidad, String concepto, Fecha fecha, Usuario usuario){
        Jornada jornada = calendario.getJornada(fecha);
        if(jornada == null){
            ArrayList<Transaccion> transacciones = new ArrayList<>();
            jornada = new Jornada(fecha, transacciones);
            calendario.anadirJornada(jornada);
        }
        jornada.anadirTransaccion(new Transaccion(cantidad, concepto, fecha, usuario));
        new DAOTransacciones().introduceTransaccion(cantidad, fecha.toStringAbreviado(), usuario.getNombre(), concepto);;
    }

    public float sumaTransaccionesDelDia(String fechaString){
        float sumaTotal = 0;
        try {
            ArrayList<Transaccion> transacciones = new ControladorCalendario().obtenTransaccionesDelDia(new Fecha().fromStringAbreviadoToFecha(fechaString));
            for(Transaccion t: transacciones){
                sumaTotal += t.getCantidad();
            }
        } catch (BeerBarException e1) {
            e1.printStackTrace();
        }
        return sumaTotal;
    }

    public float sumaTransaccionesDeLosDias(String fechaInicio, String fechaFinal){
        try {
            Fecha inicio = new Fecha().fromStringAbreviadoToFecha(fechaInicio);
            Fecha f_final = new Fecha().fromStringAbreviadoToFecha(fechaFinal);
            return this.calendario.obtenerBeneficios(inicio, f_final);
        } catch (BeerBarException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
