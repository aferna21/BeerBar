package controlador;

import bbdd.DAONotas;
import bbdd.DAOUsuarios;
import modelo.*;

public class ControladorServidorDeMensajeria {
    ServidorDeMensajeria instancia;

    public ControladorServidorDeMensajeria(){
        instancia = ServidorDeMensajeria.darInstancia();
    }

    /**
     * este metodo es solo para el testeo
     * @param texto
     * @param nombreremitente
     * @param nombredestinatario
     * @return
     * @throws BeerBarException
     */
    public Nota crearNota(String texto, String nombreremitente, String nombredestinatario) throws BeerBarException {
        Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(nombreremitente);
        Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(nombredestinatario);
        Fecha hoy = new Fecha().getFechaActual();
        Nota nota = new Nota(texto, remitente, destinatario, hoy, null, null );
        return nota;
    }

    public void escribirNota(String texto, String nombreremitente, String nombredestinatario, Nota madre) throws BeerBarException {
        Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(nombreremitente);
        Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(nombredestinatario);
        Fecha hoy = new Fecha().getFechaActual();
        Nota nota = new Nota(texto, remitente, destinatario, hoy, madre, null );
        instancia.anadirNota(nota);
        new DAONotas().introduceNota(nombreremitente, nombredestinatario, nota.getFecha().toStringAbreviado(), madre, null, texto);
    }


    public void responderNota(Nota notaAresponder, String texto, String nombreremitente, String nombredestinatario) throws BeerBarException {
        DAONotas daonotas = new DAONotas();
        daonotas.asignarHijaA(notaAresponder);
        escribirNota(texto, nombreremitente, nombredestinatario, notaAresponder);
    }
}
