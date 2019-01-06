package modelo;

import java.util.ArrayList;

/**
 * Maneja los usuarios del sistema. Sabe de ellos su nombre de usuario, contrasena y si
 * es administrador o no. El administrador tiene mas permisos que el resto.
 */
public class Usuario {

    /**
     * Nombre del Usuario.
     */
    private String nombre;

    /**
     * Contrasena que le permite acceder al sistema.
     */
    private String contrasena;

    /**
     * True solo si es el administrador.
     */
    private boolean esAdmin;

    /**
     * Constructor de la clase. Crea un usuario y le asigna el nombre, la
     * contrasena y si es administrador o no.
     *
     * @param nombre - Nombre del nuevo usuario.
     * @param contrasena - Contrasena del nuevo usuario.
     * @param esAdmin - True si es el administrador.
     */
    public Usuario(String nombre, String contrasena, boolean esAdmin)
    {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
    }

    /**
     * Getters y setters.
     */

    public String getNombre(){
        return this.nombre;
    }

    public String getContrasena(){
        return this.contrasena;
    }

    public boolean getEsAdmin(){
        return this.esAdmin;
    }

    public void setNombre(String s) {
        this.nombre = s;
    }

    public void setContrasena(String s){
        this.contrasena = s;
    }

    public void setEsAdmin(boolean b){
        this.esAdmin = b;
    }

    /**
     * Crea una nueva nota y se la envia al usuario destino (las notas son manejadas por
     * el servidor de mensajes).
     *
     * @param usuario - Usuario destino.
     * @param texto - Texto de la nota.
     */
    public void escribirNotaA(Usuario usuario, String texto) throws BeerBarException {
        //CAMBIAR ESTO DE LA FECHA DE HOY
        //CAMBIADO
        Fecha hoy = new Fecha().getFechaActual();
        Nota nota = new Nota(texto, this, usuario, hoy, null);
        ServidorDeMensajeria.darInstancia().anadirNota(nota);
    }

    /**
     * Devuelve todas las notas enviadas por el usuario que las consulta (this).
     *
     * @return - Lista de notas.
     */
    public ArrayList verNotasEnviadas(){
        return ServidorDeMensajeria.darInstancia().mostrarNotasDe(this);
    }

    /**
     * Devuelve las notas enviadas hacia un usuario en concreto por el usuario
     * que las consulta (this).
     *
     * @param usuario - Usuario destino.
     * @return - Lista de notas.
     */
    public ArrayList verNotasHacia(Usuario usuario){
        return ServidorDeMensajeria.darInstancia().mostrarNotasDeHacia(this, usuario);
    }

    /**
     * Devuelve todas las notas enviadas hacia el usuario que las consulta (this).
     *
     * @return - Lista de notas.
     */
    public ArrayList verNotasRecibidas(){
        return ServidorDeMensajeria.darInstancia().mostrarNotasHacia(this);
    }

    /**
     * Devuelve las notas enviadas de un usuario en concreto hacia el usuario
     * que las consulta (this).
     *
     * @param usuario - Usuario que envio las notas.
     * @return - Lista de notas.
     */
    public ArrayList<Nota> verNotasDe(Usuario usuario){
        return ServidorDeMensajeria.darInstancia().mostrarNotasDeHacia(usuario, this);
    }

    /**
     * Crea una nueva venta y la introduce en la jornada del dia en cuestion.
     *
     * @param cantidad - Importe de la venta.
     * @param concepto - Texto asociado a la venta.
     */
    public void introducirVenta(int cantidad, String concepto) throws BeerBarException {
        Fecha hoy = new Fecha();
        hoy = hoy.getFechaActual();
        Transaccion transaccion = new Transaccion(cantidad, concepto, hoy, this);
        Jornada jornada = Jornada.darInstancia();
        jornada.anadirTransaccion(transaccion);
    }

    /**
     * Crea un nuevo gasto y lo introduce en la jornada del dia en cuestion.
     *
     * @param cantidad - Importe del gasto.
     * @param concepto - Texto asociado al gasto.
     */
    public void introducirGasto(int cantidad, String concepto) throws BeerBarException{
        Fecha hoy = new Fecha();
        hoy = hoy.getFechaActual();
        Transaccion transaccion = new Transaccion(-cantidad, concepto, hoy, this);
        Jornada jornada = Jornada.darInstancia();
        jornada.anadirTransaccion(transaccion);
    }

    /**
     * Devuelve una lista con todas las ventas realizadas en un periodo de tiempo.
     *
     * @param fechaInicio - Fecha del inicio del periodo.
     * @param fechaFin - Fecha del fin del periodo.
     * @return - Lista de las ventas.
     */
    public ArrayList verVentas(Fecha fechaInicio, Fecha fechaFin){

        //LLAMAR A METODOS DE LA CLASE JORNADA PARA HACERLO

        return new ArrayList();
    }

    /**
     * Devuelve una lista con todas las ventas realizadas en la jornada actual.
     *
     * @return - Lista de las ventas.
     */
    public ArrayList verVentasDeHoy() throws BeerBarException{
        Fecha hoy = new Fecha();
        hoy = hoy.getFechaActual();
        return verVentas(hoy, hoy);
    }

    /**
     * Dos usuarios son considerados iguales cuando su nombre y contrasena coinciden.
     *
     * @param u - Usuario a comparar.
     * @return - True si son los mismos.
     */
    public boolean equals(Usuario u){
        return this.nombre.equals(u.getNombre())  &&
                this.contrasena.equals(u.getContrasena());
    }
}
