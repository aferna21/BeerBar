package vista;

import bbdd.DAONotas;
import bbdd.DAOUsuarios;
import modelo.*;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        new VentanaBienvenida();
        GestorDeUsuarios.darInstancia().setUsuarios(new DAOUsuarios().devuelveUsuarios());
        Nota nota = new Nota("tercera nota.",
                GestorDeUsuarios.darInstancia().getUsuario("admin"),
                GestorDeUsuarios.darInstancia().getUsuario("Adri"),
                new Fecha(10, 10, 1000), null, null);
        ServidorDeMensajeria.darInstancia().setNotas(new DAONotas().devuelveNotas());
        new DAONotas().introduceNota("Adri", "admin", "10/10/1000", ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("admin")).get(0), null, "tercera nota");
    }
}
