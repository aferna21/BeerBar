package modelo;

public class Transaccion {

    /**
     * Dinero que se ha introducido en la transaccion.
     */
    private float cantidad;

    /**
     * Explicacion opcional sobre la transaccion.
     */
    private String concepto;

    /**
     * Fecha en la que se produjo la transaccion.
     */
    private Fecha fecha;

    /**
     * Nombre del usuario que ha introducido la transaccion.
     */
    private Usuario usuario;

    /**
     * Indica si la transaccion es una venta o un gasto.
     */
    private boolean esVenta;

    /**
     * Constructor de la clase. Crea una transaccion y le asigna la cantidad,
     * el concepto, la fecha, el usuario y si es venta o gasto.
     *
     * @param cantidad - Cantidad de euros introducidos.
     * @param concepto - Explicacion opcional sobre la transaccion.
     * @param fecha - Fecha en la que se ha producido la transaccion.
     * @param usuario - Usuario que realiza la transaccion.
     */
    public Transaccion(float cantidad, String concepto, Fecha fecha, Usuario usuario){
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = fecha;
        this.usuario = usuario;
        if(cantidad >= 0) {
            this.esVenta = true;
        } else {
            this.esVenta = false;
        }
    }

    /**
     * Getters y setters.
     */

    public float getCantidad(){
        return this.cantidad;
    }

    public String getConcepto(){
        return this.concepto;
    }

    public boolean getEsVenta(){
        return this.esVenta;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public Fecha getFecha(){
        return this.fecha;
    }

    public void setFecha(Fecha f){
        this.fecha = f;
    }

    public void setUsuario(Usuario u){
        this.usuario = u;
    }

    public String toString(){
        String salida = new String();
        if (!this.getConcepto().isEmpty()){
            salida += this.getConcepto();
        }
        if (this.getEsVenta()){
            salida += "\nVenta";
        }else{
            salida += "\nGasto";
        }
        salida += " de " + this.getCantidad() + "€. Atendido por: " + this.getUsuario() + ".\n";
        return salida;
    }

    /**
     * Devuelve true si el usuario es el que ha creado la transaccion.
     * @param usuario presunto creador de la transaccion.
     * @return true si el usuario es el que ha escrito la transaccion.
     */
    public boolean esUsuario(Usuario usuario){
        return usuario.equals(this.getUsuario());
    }

    /**
     * Devuelve true si la transaccion esta escrita en una fecha determinada
     * @param fecha presunta fecha en la que ha sido escrita la transaccion
     * @return true si es la fecha de escritura de la transaccion
     */
    public boolean estaEscritaEn(Fecha fecha){
        return this.getFecha().equals(fecha);
    }

    /**
     * Dos transacciones son consideradas iguales cuando su cantidad, usuario, fecha y concepto son iguales.
     *
     * @param t - Transaccion a comparar.
     * @return - True si son los mismos.
     */
    public boolean equals(Transaccion t){
        return this.cantidad == t.getCantidad()  && this.concepto.equals(t.getConcepto())
                && this.fecha.equals(t.getFecha()) && this.usuario.equals(t.getFecha());
    }
}
