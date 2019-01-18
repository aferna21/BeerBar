package modelo;

import controlador.ControladorInicio;

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
     * @return - Instancia de la clase.
     */
    public static ServidorDeMensajeria darInstancia(){
        return instancia;
    }

    /**
     * Anade una nota al conjunto de notas.
     * @param nota que se anade.
     */
    public void anadirNota(Nota nota){
        this.notas.add(nota);
    }

    public void setNotas(ArrayList<Nota> newnotas){
        this.notas = newnotas;
    }

    /**
     * Muestra las notas que se ha enviado el usuario pasado por parametro.
     * @param usuario remitente de las notas que queremos mostrar.
     * @return Conjunto de notas del usuario con ese remitente.
     */
    public ArrayList<Nota> mostrarNotasDe(Usuario usuario){
        try {
            new ControladorInicio().actualizarInformacion();
        } catch (BeerBarException e) {
            e.printStackTrace();
        }
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for(Nota n:this.notas){
            if(n.getRemitente().equals(usuario)){
                lista.add(n);
            }
        }
        return lista;
    }

    /**
     * Muestra las notas que se han enviado hacia el usuario pasado por parametro.
     * @param usuario destinatario de las notas que queremos mostrar.
     * @return Conjunto de notas del usuario con ese destinatario.
     */
    public ArrayList<Nota> mostrarNotasHacia(Usuario usuario){
        try {
            new ControladorInicio().actualizarInformacion();
        } catch (BeerBarException e) {
            e.printStackTrace();
        }
        ArrayList<Nota> lista = new ArrayList<Nota>();
        for(Nota n:this.notas){
            if(n.getDestinatario().equals(usuario)){
                lista.add(n);
            }
        }
        return lista;
    }

    /**
     * Muestra las notas de un usuario especifico a un destinatario especifico.
     * @param  rem usuario remitente de la nota.
     * @param dest usuario destinatario de la nota.
     * @return Conjunto de notas entre el remitente y el destinatario.
     */
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

    public Nota devuelveNota(int contador){
        for(Nota n:this.notas){
            if(n.getContador() == contador){
                return n;
            }
        }
        return null;
    }

    public int contadorUltimaNota(){
        int output = 0;

        for(Nota n:this.notas){
            if(n.getContador() > output){
                output = n.getContador();
            }
        }

        return output;
    }

    public ArrayList<Nota> devuelveTodasNotas(){
        try {
            new ControladorInicio().actualizarInformacion();
        } catch (BeerBarException e) {
            e.printStackTrace();
        }
        return notas;
    }

    public ArrayList<Nota> devuelveNotasEnRelacionA(Usuario u){
        ArrayList<Nota> output = this.mostrarNotasDe(u);
        output.addAll(this.mostrarNotasHacia(u));
        return output;
    }

    public void eliminarNota(Nota n){
        int contadorHija = n.getHija();
        int contadorMadre = n.getMadre();
        if(contadorHija != 0){
            this.devuelveNota(contadorHija).setMadre(0);
        }
        if(contadorMadre != 0){
            this.devuelveNota(contadorMadre).setHija(0);
        }
        this.notas.remove(n);
    }
}
