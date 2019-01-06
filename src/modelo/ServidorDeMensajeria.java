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
     * Constructor de la clase. Inicializa el ArrayList de notas y lo llena con todas las notas de la base de datos.
     */
    private ServidorDeMensajeria(){
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

    public ArrayList<Nota> mostrarNotasDe(Usuario usuario){
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for(Nota n:this.notas){
            if(n.getRemitente().equals(usuario)){
                lista.add(n);
            }
        }
        return lista;
    }

    public ArrayList<Nota> mostrarNotasHacia(Usuario usuario){
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for(Nota n:this.notas){
            if(n.getDestinatario().equals(usuario)){
                lista.add(n);
            }
        }
        return lista;
    }



    public ArrayList<Nota> mostrarNotasDelDia(Fecha fecha){
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for(Nota n:this.notas){
            if(n.getFecha().equals(fecha)){
                lista.add(n);
            }
        }
        return lista;
    }


    public ArrayList<Nota> mostrarNotasDeHacia(Usuario rem, Usuario dest){
        ArrayList<Nota> output = new ArrayList<Nota>();
        ArrayList<Nota> notasremitente = this.mostrarNotasDe(rem);
        for(Nota n:notasremitente){
            if(n.getDestinatario().equals(dest)){
                output.add(n);
            }
        }
        return output;
    }
}
