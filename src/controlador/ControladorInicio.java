package controlador;

import bbdd.DAONotas;
import bbdd.DAOTransacciones;
import bbdd.DAOUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.Jornada;
import modelo.ServidorDeMensajeria;

public class ControladorInicio {

    public ControladorInicio() throws BeerBarException {

        if (new DAOUsuarios().devuelveUsuarios().size() == 0) {
            new DAOUsuarios().introduceUsuario("admin", "admin", true);
        }
        this.actualizarInformacion();
    }

    public void actualizarInformacion() throws BeerBarException {
        GestorDeUsuarios.darInstancia().setUsuarios(new DAOUsuarios().devuelveUsuarios());
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());
        //TODO
        //Jornada.darInstancia().setTransacciones(new DAOTransacciones().devuelveTransacciones());
    }
}