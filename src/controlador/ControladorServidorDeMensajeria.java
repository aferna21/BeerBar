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
        Nota nota = new Nota(texto, remitente, destinatario, hoy, 0, 0 );
        return nota;
    }

    public void escribirNota(String texto, String nombreremitente, String nombredestinatario, int madre) throws BeerBarException {
        Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(nombreremitente);
        Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(nombredestinatario);
        Fecha hoy = new Fecha().getFechaActual();
        Nota nota = new Nota(texto, remitente, destinatario, hoy, madre, 0 );
        instancia.anadirNota(nota);
        new DAONotas().introduceNota(nota.getContador(), nombreremitente, nombredestinatario, nota.getFecha().toStringAbreviado(), madre, 0, texto);
    }


    public void responderNota(int notaAresponder, String texto, String nombreremitente, String nombredestinatario) throws BeerBarException {
        DAONotas daonotas = new DAONotas();
        daonotas.asignarHijaA(notaAresponder, ServidorDeMensajeria.darInstancia().contadorUltimaNota()+1);
        escribirNota(texto, nombreremitente, nombredestinatario, notaAresponder);
    }
}
