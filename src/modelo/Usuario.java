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

    public Usuario(){}

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

    public void setContrasena(String s){
        this.contrasena = s;
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

    public String toString(){
        return this.nombre;
    }
}
