package controlador;

import bbdd.DAOUsuarios;
import modelo.GestorDeUsuarios;

public class ControladorInicio {

    public ControladorInicio() {

        if (new DAOUsuarios().devuelveUsuarios().size() == 0) {
            new DAOUsuarios().introduceUsuario("admin", "admin", true);
        }
        this.actualizarUsuarios();

    }

    public void actualizarUsuarios(){
        this.cargarUsuarios();
    }

    private void cargarUsuarios(){

        GestorDeUsuarios.darInstancia().setUsuarios(new DAOUsuarios().devuelveUsuarios());
    }
}
