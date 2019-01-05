package modelo;

import java.util.ArrayList;

public class BeerBar {

    private Jornada jornadas;
    private GestorDeUsuarios usuarios;

    public BeerBar(){

    }

    public void iniciarSesion(Usuario usuario){

    }

    public void escribirNota(Usuario usuarioOrigen, Usuario usuarioDestino, String texto){

    }

    public ArrayList verHistorialDeTransacciones(){
        return new ArrayList();
    }

    public boolean eliminarUsuario(){
        return true;
    }

    public boolean anadirUsuario(){
        return true;
    }

    public ArrayList verNotasDeTodosLosUsuarios(){
        return new ArrayList();
    }

    public boolean modificarTransaccion(Transaccion transaccion, int cantidad){
        return true;
    }

    public boolean introducirTransaccion(boolean esVenta, int cantidad){
        return true;
    }

    public ArrayList verNotasRecibidas(){
        return new ArrayList();
    }

    public boolean descargarCopiaDeSeguridad(){
        return true;
    }

    public void consultarAyuda(){

    }

    public boolean cerrarSesion(Usuario usuario){
        return true;
    }
}
