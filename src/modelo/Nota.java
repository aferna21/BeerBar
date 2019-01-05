package modelo;

public class Nota {
    private String texto;
    private Usuario remitente;
    private Usuario destinatario;
    private Fecha fecha;
    private Nota padre;
    private Nota hijo;
    private boolean leida;


    public Nota(){

    }

    /**
     * Constructor. Crea una instancia de la clase Nota.
     * @param texto contenido de la nota.
     * @param remitente usuario que escribe la nota.
     * @param destinatario usuario al que va dirigida la nota.
     * @param fecha dia en el que esta escrita la fecha
     * @param padre nota de la que proviene la escrita. Sera null si empieza un nuevo hilo
     */
    public Nota(String texto, Usuario remitente, Usuario destinatario, Fecha fecha, Nota padre){
        this.texto = texto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.padre = padre;
        this.hijo = null;
        this.leida = false;
    }

    public String getTexto(){
        return this.texto;
    }

    public Usuario getRemitente(){
        return this.remitente;
    }

    public Usuario getDestinatario(){
        return this.destinatario;
    }

    public Fecha getFecha(){
        return this.fecha;
    }

    public Nota getPadre(){
        return this.padre;
    }

    public Nota getHijo(){
        return this.hijo;
    }

    public boolean isLeida(){
        return this.leida;
    }

    public void setTexto(String s){
        this.texto = s;
    }


    /**
     * Devuelve true si el usuario es remitente de la nota.
     * @param u presunto remitente de la nota.
     * @return true si el usuario u la ha escrito.
     */
    public boolean esRemitente(Usuario u){
        return this.remitente.equals(u);
    }


    /**
     * Devuelve true si el usuario es el destinatario de la nota
     * @param u presunto destinatario de la nota
     * @return true si el usuario u es al que va dirigido la nota
     */
    public boolean esDestinatario(Usuario u){
        return this.destinatario.equals(u);
    }


    /**
     * Devuelve true si la nota esta escrita en una fecha determinada.
     * @param f presunta fecha en la que esta escrita la nota.
     * 1@return true si la fecha de la nota es f.
     */
    public boolean estaEscritaEn(Fecha f){
        return f.equals(this.fecha);
    }


    /**
     * Devuelve true si la nota actual es hija de la nota n
     * @param n presunto padre de la nota actual
     * @return true si esta nota es hija de n
     */
    public boolean esHijaDe(Nota n){
        return this.padre.equals(n);
    }


    /**
     * Devuelve true si la nota actual es padre de la nota n
     * @param n presunta hija de la nota actual
     * @return true si la nota es padre de n
     */
    public boolean esPadreDe(Nota n){
        return this.hijo.equals(n);
    }

    /**
     * No pongo el padre ni el hijo porque pueden ser null.
     * @param n
     * @return
     */
    public boolean equals(Nota n){
        return this.texto.equals(n.getTexto()) &&
                this.destinatario.equals(n.getDestinatario()) &&
                this.remitente.equals(n.getRemitente()) &&
                this.fecha.equals(n.getFecha());

    }
}
