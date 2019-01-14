package modelo;

import java.util.ArrayList;

public class GestorDeUsuarios {

    private ArrayList<Usuario> usuarios;
    private static GestorDeUsuarios instancia = new GestorDeUsuarios();

    /**
     * Deberia ser privado porque es un singleton pero lo pongo publico para subir los test
     */
    private GestorDeUsuarios(){
        this.usuarios = new ArrayList<Usuario>();
    }


    public static GestorDeUsuarios darInstancia(){
        return instancia;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    /**
     * Peculiaridad del singleton
     */
    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }

    /**
     * Indica si el usuario y la contrasena introducidas son correctos.
     * @param nombreUsuario nombre del usuario.
     * @param contrasena contrasena del usuario.
     * @return true si la contrasena corresponde a un nombre de usuario que existe.
     */
    public boolean autentificar(String nombreUsuario, String contrasena){
        Usuario u = this.getUsuario(nombreUsuario);
        if(u == null) return false;

        return nombreUsuario.equals(u.getNombre())  &&  contrasena.equals(u.getContrasena());
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
    public boolean anadirUsuario(String nombre, String contrasena) throws BeerBarException {
        for (Usuario u : this.usuarios){
            if (u.getNombre().equals(nombre)){
                throw new BeerBarException("El nombre de usuario ya existe.\n");
            }
        }
        this.usuarios.add(new Usuario(nombre, contrasena, false));
        return true;
    }

    /**
     * Elimina un usuario de la coleccion de usuarios del sistema
     * @param nombre nombre del usuario a eliminar
     */
    public boolean eliminarUsuario(String nombre) throws BeerBarException {
        for (Usuario u : this.usuarios){
            if (u.getNombre().equals(nombre)){
                this.usuarios.remove(u);
                return true;
            }
        }
        throw new BeerBarException("Usuario no encontrado.\n");
    }

    public boolean cambiarContrasena(String nombre, String contrasena) throws BeerBarException {
        for (Usuario u : this.usuarios){
            if (u.getNombre().equals(nombre)){
                u.setContrasena(contrasena);
                return true;
            }
        }
        throw new BeerBarException("El nombre de usuario ya existe.\n");
    }

    /**
     * Devuelve un usuario a partir de su nombre. Si no existe, devolvera null.
     * @param nombre nombre del usuario a buscar.
     * @return el usuario si existe, null si no existe.
     */
    public Usuario getUsuario(String nombre){
        for(Usuario usuario:this.usuarios){
            if(usuario.getNombre().equals(nombre)){
                return usuario;
            }
        }
        return null;
    }

}
