package vista.principal;

import bbdd.DAONotas;
import bbdd.DAOTransacciones;
import controlador.ControladorInicio;
import controlador.ControladorServidorDeMensajeria;
import modelo.*;

import java.util.ArrayList;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        new VentanaBienvenida();
        new ControladorInicio().actualizarInformacion();
        ArrayList<Transaccion> t = new DAOTransacciones().devuelveTransacciones();
        System.out.println(t.get(2).toString());
    }


}
