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
     * Usuario con la sesion activa en la aplicacion
     */
    private Usuario usuarioActual;

    /**
     * Constructor de la clase
     */
    public BeerBar(Jornada jornada){
        this.jornada = jornada;
        this.usuarios = GestorDeUsuarios.darInstancia();
        this.usuarioActual = null;
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
        boolean b = usuarios.autentificar(nombre, contrasena);
        if(b){
            this.usuarioActual = GestorDeUsuarios.darInstancia().getUsuario(nombre);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Crea una nota y la envia a un usuario destino. Las notas son manejadas por el Servidor de
     * mensajeria
     *
     * @param usuarioOrigen - Usuario que crea la nota
     * @param usuarioDestino - Usuario al que va dirigida
     * @param texto - Texto de la nota
     */
    public void escribirNota(Usuario usuarioOrigen, String usuarioDestino, String texto) throws BeerBarException {
        this.usuarioActual.escribirNotaA(GestorDeUsuarios.darInstancia().getUsuario(usuarioDestino), texto);
    }

    /**
     * Devuelve una lista con todas las transacciones del dia
     *
     * @return - Lista de transacciones
     */
    public ArrayList<Transaccion> verHistorialDeTransacciones() throws BeerBarException {
        return Calendario.darInstancia().verTransaccionesDeLosDias(jornada.getFecha(), jornada.getFecha());
    }

    /**
     * Elimina el usuario del sistema
     *
     * @param nombreUsuario - Usuario a eliminar
     * @return - True si se ha eliminado correctamente
     */
    public boolean eliminarUsuario(String nombreUsuario) throws BeerBarException {
        if(GestorDeUsuarios.darInstancia().getUsuario(nombreUsuario) != null){
            GestorDeUsuarios.darInstancia().eliminarUsuario(nombreUsuario);
            return true;
        }
        return false;

    }

    /**
     * Anade un usuario al sistema
     *
     * @param nombre - Usuario nuevo
     * @param contrasena - clave del usuario nuevo.
     * @return - True si se ha anadido correctamente
     */
    public boolean anadirUsuario(String nombre, String contrasena) throws BeerBarException {

        return GestorDeUsuarios.darInstancia().anadirUsuario(nombre, contrasena);
    }

    /**
     * Devuelve todas las notas enviadas en una jornada. Solo puede ser usado por el
     * administrador
     *
     * @return - Lista de notas
     */
    public ArrayList<Nota> verNotasDeTodosLosUsuarios() throws BeerBarException {
        if(usuarioActual.getEsAdmin()){
            return ServidorDeMensajeria.darInstancia().mostrarNotasDelDia(this.jornada.getFecha());
        }else{
            return null;
        }
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
        if(!usuarioActual.getEsAdmin()) return false;

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
    public boolean introducirTransaccion(boolean esVenta, float cantidad, String concepto){
        /*if(esVenta){
            cantidad = 0 -cantidad;
        }*/

        this.jornada.anadirTransaccion(new Transaccion(cantidad, concepto, this.jornada.getFecha(), usuarioActual));
        return true;
    }

    /**
     * Devuelve una lista con las notas recibidas en una jornada
     *
     * @return - Lista de notas
     */
    public ArrayList<Nota> verNotasRecibidas() throws BeerBarException {
        // Este metodo es para un usuario en concreto ¿?
        return ServidorDeMensajeria.darInstancia().mostrarNotasHacia(this.usuarioActual);
    }

    /**
     * Descarga una copia de seguridad de los datos almacenados en la base de datos
     * del sistema
     *
     * @return - True si se ha descargado correctamente
     */
    public boolean descargarCopiaDeSeguridad(){
        // Acceder a la base de datos y descargar en forma de fichero todas las notas, transacciones
        // y usuarios del sistema
        return true;
    }


    /**
     * Cierra la sesion actual de un usuario. Sale del sistema y cierra las ventanas.
     *
     * @param usuario - Usuario que cerrara la sesion (normalmente deberia ser this)
     * @return - True si se ha cerrado la sesion correctamente
     */
    public boolean cerrarSesion(Usuario usuario){
        this.usuarioActual = null;
        return true;
    }
}
