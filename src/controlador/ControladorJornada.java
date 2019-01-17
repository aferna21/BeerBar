package controlador;

import bbdd.DAOTransacciones;
import modelo.*;

import java.util.ArrayList;


public class ControladorJornada {

    Jornada instancia;

    public ControladorJornada(){
        instancia = Jornada.darInstancia();
    }


    public void introducirTransaccion(float cantidad, String concepto, String nombreUsuario, String fechaString) throws BeerBarException {
        instancia.setFecha(new Fecha().fromStringAbreviadoToFecha(fechaString));
        Transaccion t = new Transaccion(cantidad, concepto, instancia.getFecha().fromStringAbreviadoToFecha(fechaString), GestorDeUsuarios.darInstancia().getUsuario(nombreUsuario));
        instancia.anadirTransaccion(t);
        new DAOTransacciones().introduceTransaccion(cantidad, fechaString, nombreUsuario, concepto);
    }

    public ArrayList<Transaccion> getTransacciones(String fechaString) throws BeerBarException {

        instancia.setFecha(new Fecha().fromStringAbreviadoToFecha(fechaString));

        return instancia.getTransacciones();
    }
}
