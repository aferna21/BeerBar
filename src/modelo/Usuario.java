package modelo;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String contrasena;
    private boolean esAdmin;



    /**
     * Constructor de la clase. Crea un usuario y le asigna el nombre, la
     * contrasena y si es administrador o no
     *
     * @param nombre - Nombre del nuevo usuario
     * @param contrasena - Contrasena del nuevo usuario
     * @param esAdmin - Si es administrador o no
     */
    public Usuario(String nombre, String contrasena, boolean esAdmin)
    {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.esAdmin = esAdmin;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getContrasena(){
        return this.contrasena;
    }

    public boolean getEsAdmin(){
        return this.esAdmin;
    }

    /**
     * Crea una nueva nota y se la envia al usuario destino (las notas son manejadas por
     * el servidor de mensajes)
     *
     * @param usuario - usuario destino
     * @param nota - Texto de la nota
     */
    public void escribirNotaA(Usuario usuario, String nota){

    }

    /**
     * Devuelve todas las notas enviadas por el usuario que las consulta (this)
     *
     * @return - Lista de notas
     */
    private ArrayList verNotasHacia(){
        return new ArrayList();
    }

    /**
     * Devuelve las notas enviadas hacia un usuario en concreto por el usuario
     * que las consulta (this)
     *
     * @param usuario - usuario destino
     * @return - Lista de notas
     */
    public ArrayList verNotasHacia(Usuario usuario){
        return new ArrayList();
    }

    /**
     * Devuelve todas las notas enviadas hacia el usuario que las consulta (this)
     *
     * @return - Lista de notas
     */
    private ArrayList verNotasDe(){
        return new ArrayList();
    }

    /**
     * Devuelve las notas enviadas de un usuario en concreto hacia el usuario
     * que las consulta (this)
     *
     * @param usuario - usuario que envio las notas
     * @return - Lista de notas
     */
    public ArrayList verNotasDe(Usuario usuario){
        return new ArrayList();
    }

    /**
     * Crea una nueva venta y la introduce en la jornada del dia en cuestion
     *
     * @param cantidad - Importe de la venta
     * @param concepto - Texto asociado a la venta
     */
    public void introducirVenta(int cantidad, String concepto){

    }

    /**
     * Crea un nuevo gasto y lo introduce en la jornada del dia en cuestion
     *
     * @param cantidad - Importe del gasto
     * @param concepto - Texto asociado al gasto
     */
    public void introducirGasto(int cantidad, String concepto){

    }

    /**
     * Devuelve una lista con todas las ventas realizadas en un periodo de tiempo
     *
     * @param fechaInicio - Fecha del inicio del periodo
     * @param fechaFin - Fecha del fin del periodo
     * @return - Lista de las ventas
     */
    public ArrayList verVentas(Fecha fechaInicio, Fecha fechaFin){
        return new ArrayList();
    }

    /**
     * Devuelve una lista con todas las ventas realizadas en la jornada actual
     *
     * @return - Lista de las ventas
     */
    public ArrayList verVentasDeHoy()
    {
        return new ArrayList();
    }


    public boolean equals(Usuario u){
        return this.nombre.equals(u.getNombre())  &&  this.contrasena.equals(u.getContrasena());

        //No se si eso o:
        //return this.nombre == u.getNombre() && this.contrasena == u.getContrasena()
    }
}
