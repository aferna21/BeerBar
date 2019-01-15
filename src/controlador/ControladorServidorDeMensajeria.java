package controlador;

import bbdd.DAONotas;
import bbdd.DAOUsuarios;
import modelo.*;

public class ControladorServidorDeMensajeria {
    ServidorDeMensajeria instancia;

    public ControladorServidorDeMensajeria(){
        instancia = ServidorDeMensajeria.darInstancia();
    }

    public void escribirNota(String texto, String nombreremitente, String nombredestinatario) throws BeerBarException {
        Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(nombreremitente);
        Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(nombredestinatario);
        Nota nota = new Nota(texto, remitente, destinatario, new Fecha().getFechaActual(), null, null );
        instancia.anadirNota(nota);
        new DAONotas().introduceNota(nombreremitente, nombredestinatario, new Fecha().getFechaActual().toStringAbreviado(), null, null, texto);
    }
}
