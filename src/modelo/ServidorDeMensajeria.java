package modelo;

import java.util.ArrayList;

/**
 * Clase que maneja los mensajes del sistema. Es un Singleton, por lo tanto solo tiene una
 * instancia sobre la que trabajan el resto de clases.
 */
public class ServidorDeMensajeria {

    /**
     * Instancia unica del ServidorDeMensajeria.
     */
    private static ServidorDeMensajeria instancia = new ServidorDeMensajeria();
    private ArrayList<Nota> notas;

    /**
     * Constructor de la clase. Inicializa el ArrayList de notas.
     */
    public ServidorDeMensajeria(){
        this.notas = new ArrayList<>();
    }

    /**
     * Devuelve la instancia unica de la clase.
     *
     * @return - Instancia de la clase.
     */
    public static ServidorDeMensajeria darInstancia(){
        return instancia;
    }

    public void anadirNota(Nota nota){
        this.notas.add(nota);
    }

    public ArrayList mostrarNotasDe(Usuario usuario){
        return new ArrayList();
    }

    public ArrayList mostrarNotasHacia(Usuario usuario){
        return new ArrayList();
    }

    public ArrayList mostrarTodasNotas(Usuario usuario){
        return new ArrayList();
    }

    public ArrayList mostrarNotasDelDia(Fecha fecha){
        return new ArrayList();
    }
}
