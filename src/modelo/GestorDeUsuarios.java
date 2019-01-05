package modelo;

import java.util.ArrayList;

public class GestorDeUsuarios {

    private ArrayList<Usuario> usuarios;

    /**
     * privado porque es singleton. Aun no se muy bien como va, buscar x google
     */
    private GestorDeUsuarios(){

    }

    /**
     * peculiaridad del singletoooooooonnn
     */
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }

    /**
     * Indica si el usuario y la contrasena introducidas son correctos.
     * @param nombreusuario nombre del usuario.
     * @param contrasena contrasena del usuario.
     * @return true si la contrasena corresponde a un nombre de usuario que existe.
     */
    public boolean autentificar(String nombreusuario, String contrasena){
        Usuario u = this.getUsuario(nombreusuario);
        if(u == null) return false;

        return nombreusuario.equals(u.getNombre())  &&  contrasena.equals(u.getContrasena());
    }

    /**
     * Indica si el nombre de usuario introducido es administrador de la aplicacion.
     * @param nombre nombre del usuario.
     * @return true si el usuario es administrador.
     */
    public boolean esAdmin(String nombre){
        Usuario u = this.getUsuario(nombre);
        if(u == null) return false;

        return u.getEsAdmin();
    }


    /**
     * Anade un nuevo usuario a la coleccion de usuarios del sistema
     * @param nombre nombre el usuario a anadir
     * @param contrasena contrasena del usuario a anadir
     */
    public void anadirUsuario(String nombre, String contrasena){
        Usuario nuevousuario = new Usuario(nombre, contrasena, false);
        this.usuarios.add(nuevousuario);
    }

    /**
     * Devuelve un usuario a partir de su nombre. Si no existe, devolvera null.
     * @param nombre nombre del usuario a buscar.
     * @return el usuario si existe, null si no existe.
     */
    private Usuario getUsuario(String nombre){
        for(Usuario usuario:this.usuarios){
            if(usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        return null;
    }

}
