package controlador;

import bbdd.DAONotas;
import bbdd.DAOTransacciones;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.Jornada;
import modelo.Transaccion;

public class ControladorJornada {

    Jornada instancia;

    public ControladorJornada(){
        instancia = Jornada.darInstancia();
    }


    /*
        Estos dos metodos podrian ser uno tranquilamente.
     */
    public void introducirTransaccion(float cantidad, String concepto, String nombreUsuario, String fechaString) throws BeerBarException {

        /*
        Transaccion t = new Transaccion(cantidad, concepto, instancia.getFecha().fromStringAbreviadoToFecha(fechaString), GestorDeUsuarios.darInstancia().getUsuario(nombreUsuario));
        instancia.anadirTransaccion(t);
        new DAOTransacciones().introduceTransaccion(cantidad, fechaString, nombreUsuario, concepto);
        */
    }



}
