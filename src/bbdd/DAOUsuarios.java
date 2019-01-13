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


        return listaUsuarios;
    }



    private boolean fromStringToBool(String s){
        if(s.equals("si")){
            return true;
        }else{
            return false;
        }
    }
}
