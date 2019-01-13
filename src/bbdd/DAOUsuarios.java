package bbdd;

import modelo.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOUsuarios extends Conexion {


    public ArrayList<Usuario> devuelveUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM usuarios;");
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String nombre = rs.getString("nombre_usuario");
                String contrasena = rs.getString("contrasena");
                String booleano = rs.getString("esAdmin");
                boolean esAdmin = this.fromStringToBool(booleano);
                Usuario u = new Usuario(nombre, contrasena, esAdmin);
                listaUsuarios.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();


        return listaUsuarios;
    }



    private boolean fromStringToBool(String s){
        if(s.equals("si")){
            return true;
        }else{
            return false;
        }
    }

    private String fromBoolToString(boolean b){
        if(b){
            return "si";
        }else{
            return "no";
        }
    }


    public void introduceUsuario(String nombre, String contrasena, boolean b){
        String esAdmin = fromBoolToString(b);
        this.abrirConexion();
        String valores = "(" + nombre + ", " + contrasena + ", " + esAdmin + ");";
        try {
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO usuarios VALUES ('" + nombre + "', '" + contrasena + "', '" + esAdmin + "');");
            st.executeUpdate();
            System.out.println("Usuario introducido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
    }


    public void eliminarUsuario(String nombre){
        this.abrirConexion();
        PreparedStatement st = null;
        try {
            st = this.getConexion().prepareStatement("DELETE FROM usuarios WHERE nombre_usuario='"+nombre+ "';");
            st.executeUpdate();
            System.out.println("Usuario eliminado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }
}
