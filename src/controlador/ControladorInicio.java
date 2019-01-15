package controlador;

import bbdd.DAONotas;
import bbdd.DAOUsuarios;
import modelo.BeerBarException;
import modelo.GestorDeUsuarios;
import modelo.ServidorDeMensajeria;

public class ControladorInicio {

    public ControladorInicio() {

        if (new DAOUsuarios().devuelveUsuarios().size() == 0) {
            new DAOUsuarios().introduceUsuario("admin", "admin", true);
        }
        this.actualizarUsuarios();
        try {
            this.cargarNotas();
        } catch (BeerBarException e) {
            e.printStackTrace();
        }

    }

    public void actualizarUsuarios(){
        GestorDeUsuarios.darInstancia().setUsuarios(new DAOUsuarios().devuelveUsuarios());
    }

    public void cargarNotas() throws BeerBarException {
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());
    }
}
