package modelo;

/**
 * Mensajes que se enviaran los empleados entre ellos, contienen un texto, quien lo envia,
 * quien lo recibe, la fecha en la que se creo, y puede contener una madre y una hija si son
 * respuestas entre notas. Se puede comprobar si han sido leidas.
 */
public class Nota {

    /**
     * Texto que va en el cuerpo de la nota.
     */
    private String texto;

    /**
     * Usuario que envia la nota.
     */
    private Usuario remitente;

    /**
     * Usuario que recibe la nota.
     */
    private Usuario destinatario;

    /**
     * Dia en el que se creo la nota.
     */
    private Fecha fecha;

    /**
     * Opcional. Nota a la que responde la nota actual.
     */
    private Nota madre;

    /**
     * Opcional. Nota que ha respondido a la nota actual.
     */
    private Nota hija;

    /**
     * True si la nota ha sido leida por el destinatario.
     */
    private boolean leida;


    /**
     * Constructor. Crea una instancia de la clase Nota.
     *
     * @param texto - Contenido de la nota.
     * @param remitente - Usuario que escribe la nota.
     * @param destinatario - Usuario al que va dirigida la nota.
     * @param fecha - Dia en el que esta escrita la nota.
     * @param madre - Nota de la que proviene la escrita. Sera null si empieza un nuevo hilo
     */
    public Nota(String texto, Usuario remitente, Usuario destinatario, Fecha fecha, Nota madre, Nota hija) throws BeerBarException {
        if(texto == null || remitente == null || destinatario == null || fecha == null){
            throw new BeerBarException("Error al crear la nota.");
        }
        else {
            this.texto = texto;
            this.remitente = remitente;
            this.destinatario = destinatario;
            this.fecha = fecha;
            this.madre = madre;
            this.hija = hija;
            this.leida = false;

            if(this.madre != null){
                this.madre.setHija(this);
            }
        }
    }

    /**
     * Getters y setters.
     */

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

    public Nota getMadre(){
        return this.madre;
    }

    public Nota getHija(){
        return this.hija;
    }

    public boolean esLeida(){
        return this.leida;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public void setMadre(Nota madre){
        this.madre = madre;
    }

    public void setHija(Nota hija){
        this.hija = hija;
    }

    public void setLeida(boolean leida){
        this.leida = leida;
    }


    /**
     * Devuelve true si el usuario es remitente de la nota.
     *
     * @param u - Presunto remitente de la nota.
     * @return - True si el usuario u la ha escrito.
     */
    public boolean esRemitente(Usuario u){
        return this.remitente.equals(u);
    }


    /**
     * Devuelve true si el usuario es el destinatario de la nota.
     *
     * @param u - Presunto destinatario de la nota.
     * @return - true si el usuario u es al que va dirigido la nota.
     */
    public boolean esDestinatario(Usuario u){
        return this.destinatario.equals(u);
    }


    /**
     * Devuelve true si la nota esta escrita en una fecha determinada.
     *
     * @param f - Presunta fecha en la que esta escrita la nota.
     * @return - True si la fecha de la nota es f.
     */
    public boolean estaEscritaEn(Fecha f){
        return f.equals(this.fecha);
    }


    /**
     * Devuelve true si la nota actual es hija de la nota n.
     *
     * @param n - Presunta madre de la nota actual.
     * @return - True si esta nota es hija de n.
     */
    public boolean esHijaDe(Nota n){
        return this.madre.equals(n);
    }


    /**
     * Devuelve true si la nota actual es madre de la nota n.
     *
     * @param n - Presunta hija de la nota actual.
     * @return - True si la nota es madre de n.
     */
    public boolean esMadreDe(Nota n){
        return this.hija.equals(n);
    }

    /**
     * Se comparan dos notas para ver si son la misma. Asumimos que es la misma si
     * tiene el mismo texto, el mismo remitente y destinatario y se han escrito el mismo dia
     *
     * @param n - Presunta nota igual que la actual.
     * @return - True si son iguales.
     */
    public boolean equals(Nota n){
        return this.texto.equals(n.getTexto()) &&
                this.destinatario.equals(n.getDestinatario()) &&
                this.remitente.equals(n.getRemitente()) &&
                this.fecha.equals(n.getFecha());

    }
}
