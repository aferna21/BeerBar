package modelo;

public class Transaccion {
    private float cantidad;
    private String concepto;
    private Fecha fecha;
    private Usuario usuario;
    private boolean esVenta;


    public Transaccion(){

    }

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

    //cantidad

    public float getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(float c){
        this.cantidad = c;
    }


    //concepto

    public String getConcepto(){
        return this.concepto;
    }

    public void setConcepto(String c){
        this.concepto = c;
    }


    //fecha

    public Fecha getFecha(){
        return this.fecha;
    }

    public void setFecha(Fecha f){
        this.fecha = f;
    }


    //usuario

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario u){
        this.usuario = u;
    }


    //esVenta

    public boolean getEsVenta(){
        return this.esVenta;
    }

    public void setEsVenta(boolean b){
        this.esVenta = b;
    }


    public String toString(){
        return new String();
    }


    /**
     * Devuelve true si el usuario es el que ha creado la transaccion.
     * @param usuario presunto creador de la transaccion.
     * @return true si el usuario es el que ha escrito la transaccion.
     */
    public boolean esUsuario(Usuario usuario){
        return false;
    }

    /**
     * Devuelve true si la transaccion esta escrita en una fecha determinada
     * @param fecha presunta fecha en la que ha sido escrita la transaccion
     * @return true si es la fecha de escritura de la transaccion
     */
    public boolean estaEscritaEn(Fecha fecha){
        return false;
    }
}
