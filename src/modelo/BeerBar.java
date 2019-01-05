package modelo;

import java.util.ArrayList;

/**
 * Clase BeerBar, maneja los eventos principales de la aplicacion
 *
 * Consta de la jornada actual sobre la que trabaja y del conjunto de usuarios
 * que participan en ella
 */
public class BeerBar {

    /**
     * Dia actual
     */
    private Jornada jornada;

    /**
     * Conjunto de usuarios pertenecientes al sistema
     */
    private GestorDeUsuarios usuarios;

    /**
     * Constructor de la clase
     */
    public BeerBar(){

    }

    /**
     * Inicia sesion en la aplicacion. Consulta si el usuario es admin o no para mostrar una ventana
     * u otra
     *
     * @param usuario - Usuario que inicia sesion
     */
    public void iniciarSesion(Usuario usuario){

    }

    /**
     * Crea una nota y la envia a un usuario destino. Las notas son manejadas por el Servidor de
     * mensajeria
     *
     * @param usuarioOrigen - Usuario que crea la nota
     * @param usuarioDestino - Usuario al que va dirigida
     * @param texto - Texto de la nota
     */
    public void escribirNota(Usuario usuarioOrigen, Usuario usuarioDestino, String texto){

    }

    /**
     * Devuelve una lista con todas las transacciones del dia
     *
     * @return - Lista de transacciones
     */
    public ArrayList verHistorialDeTransacciones(){
        return new ArrayList();
    }

    /**
     * Elimina el usuario del sistema
     *
     * @param usuario - Usuario a eliminar
     * @return - True si se ha eliminado correctamente
     */
    public boolean eliminarUsuario(Usuario usuario){
        return true;
    }

    /**
     * Anade un usuario al sistema
     *
     * @param usuario - Usuario nuevo
     * @return - True si se ha anadido correctamente
     */
    public boolean anadirUsuario(Usuario usuario){
        return true;
    }

    /**
     * Devuelve todas las notas enviadas en una jornada. Solo puede ser usado por el
     * administrador
     *
     * @return - Lista de notas
     */
    public ArrayList verNotasDeTodosLosUsuarios(){
        return new ArrayList();
    }

    /**
     * Cambia la cantidad de una transaccion determinada. Solo puede ser usado por el
     * administrador
     *
     * @param transaccion - Transaccion a modificar
     * @param cantidad - Nueva cantidad
     * @return - True si se ha modificado correctamente
     */
    public boolean modificarTransaccion(Transaccion transaccion, int cantidad){
        return true;
    }

    /**
     * Crea una nueva transaccion y la introduce en el conjunto de la jornada
     *
     * @param esVenta - True si es una venta y false si es un gasto
     * @param cantidad - Cantidad de la transaccion
     * @return - True si se ha introducido correctamente
     */
    public boolean introducirTransaccion(boolean esVenta, int cantidad){
        return true;
    }

    /**
     * Devuelve una lista con las notas recibidas en una jornada
     *
     * @return - Lista de notas
     */
    public ArrayList verNotasRecibidas(){
        return new ArrayList();
    }

    /**
     * Descarga una copia de seguridad de los datos almacenados en la base de datos
     * del sistema
     *
     * @return - True si se ha descargado correctamente
     */
    public boolean descargarCopiaDeSeguridad(){
        return true;
    }


    /**
     * Cierra la sesion actual de un usuario. Sale del sistema y cierra las ventanas.
     *
     * @param usuario - Usuario que cerrara la sesion (normalmente deberia ser this)
     * @return - True si se ha cerrado la sesion correctamente
     */
    public boolean cerrarSesion(Usuario usuario){
        return true;
    }
}
