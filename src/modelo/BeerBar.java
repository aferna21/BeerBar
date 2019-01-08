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
    public BeerBar(Jornada jornada){
        this.jornada = jornada;
        this.usuarios = GestorDeUsuarios.darInstancia().;
    }

    /**
     * Inicia sesion en la aplicacion. Consulta si el usuario es admin o no para mostrar una ventana
     * u otra
     *
     * @param nombre - Usuario que inicia sesion
     * @param contrasena - clave de inicio de sesion del usuario
     * @return true si el usuario existe y la contrasena corresponde al nombre de usuario
     */
    public boolean iniciarSesion(String nombre, String contrasena){
        return usuarios.autentificar(nombre, contrasena);
    }

    /**
     * Crea una nota y la envia a un usuario destino. Las notas son manejadas por el Servidor de
     * mensajeria
     *
     * @param usuarioOrigen - Usuario que crea la nota
     * @param usuarioDestino - Usuario al que va dirigida
     * @param texto - Texto de la nota
     */
    public void escribirNota(Usuario usuarioOrigen, Usuario usuarioDestino, String texto) throws BeerBarException {
        usuarioOrigen.escribirNotaA(usuarioDestino, texto);
    }

    /**
     * Devuelve una lista con todas las transacciones del dia
     *
     * @return - Lista de transacciones
     */
    public ArrayList<Transaccion> verHistorialDeTransacciones() throws BeerBarException {
        return Calendario.darInstancia().verTransaccionesDeLosDias(
                new Fecha().getFechaActual(), new Fecha().getFechaActual());
    }

    /**
     * Elimina el usuario del sistema
     *
     * @param usuario - Usuario a eliminar
     * @return - True si se ha eliminado correctamente
     */
    public boolean eliminarUsuario(Usuario usuario) throws BeerBarException {

        return GestorDeUsuarios.darInstancia().eliminarUsuario(usuario.getNombre());

    }

    /**
     * Anade un usuario al sistema
     *
     * @param usuario - Usuario nuevo
     * @return - True si se ha anadido correctamente
     */
    public boolean anadirUsuario(Usuario usuario) throws BeerBarException {

        return GestorDeUsuarios.darInstancia().anadirUsuario(usuario.getNombre(), usuario.getContrasena());
    }

    /**
     * Devuelve todas las notas enviadas en una jornada. Solo puede ser usado por el
     * administrador
     *
     * @return - Lista de notas
     */
    public ArrayList<Nota> verNotasDeTodosLosUsuarios() throws BeerBarException {
        // Como ponemos que solo sea usado por el administrador???
        return ServidorDeMensajeria.darInstancia().mostrarNotasDelDia(new Fecha().getFechaActual());
    }

    /**
     * Cambia la cantidad de una transaccion determinada. Solo puede ser usado por el
     * administrador
     *
     * @param transaccion - Transaccion a modificar
     * @param cantidad - Nueva cantidad
     * @return - True si se ha modificado correctamente
     */
    public boolean modificarTransaccion(Transaccion transaccion, int cantidad) throws BeerBarException {
        // Como ponemos que solo sea usado por el administrador???
        ArrayList<Transaccion> transaccionesJornada = Jornada.darInstancia().getTransacciones();
        for (Transaccion t : transaccionesJornada){
            if (t.equals(transaccion)){
                t.setCantidad(cantidad);
                return true;
            }
        }
        throw new BeerBarException("Transaccion no encontrada.\n");
    }

    /**
     * Crea una nueva transaccion y la introduce en el conjunto de la jornada
     *
     * @param esVenta - True si es una venta y false si es un gasto
     * @param cantidad - Cantidad de la transaccion
     * @return - True si se ha introducido correctamente
     */
    public boolean introducirTransaccion(boolean esVenta, float cantidad){
        // Como se que usuario es
        return true;
        //Transaccion t = new Transaccion(cantidad, "", new Fecha().getFechaActual(), usuario);
        //return Jornada.darInstancia().anadirTransaccion(t);
    }

    /**
     * Devuelve una lista con las notas recibidas en una jornada
     *
     * @return - Lista de notas
     */
    public ArrayList<Nota> verNotasRecibidas() throws BeerBarException {
        // Este metodo es para un usuario en concreto ¿?
        return ServidorDeMensajeria.darInstancia().mostrarNotasDelDia(new Fecha().getFechaActual());
    }

    /**
     * Descarga una copia de seguridad de los datos almacenados en la base de datos
     * del sistema
     *
     * @return - True si se ha descargado correctamente
     */
    public boolean descargarCopiaDeSeguridad(){
        // Que queremos descargar¿?
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
