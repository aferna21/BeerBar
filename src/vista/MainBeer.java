package vista;

import bbdd.DAONotas;
import controlador.ControladorInicio;
import modelo.*;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        new VentanaBienvenida();

        /*new ControladorInicio().actualizarInformacion();

        /*new DAONotas().introduceNota("Felipe", "Adri", "1/4/2019", null, null, "Primera nota");
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());

        new DAONotas().introduceNota("Adri", "Felipe", "2/4/2019", ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Felipe")).get(0), null, "Segunda nota");
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());

        new DAONotas().introduceNota("Felipe", "Adri", "3/4/2019", ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Felipe")).get(0), ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Adri")).get(0), "Tercera nota");
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());*/
    }
}
