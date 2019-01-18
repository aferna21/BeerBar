package bbdd;

import java.sql.*;

public class Conexion {

    private String ruta;
    private String usuario;
    private String contrasena;
    private Connection conexion;

    public Conexion(){
        ruta = "jdbc:mysql://localhost:3306/beerbar";
        usuario = "inso";
        contrasena = "inso";

    }

    public Connection getConexion(){
        return this.conexion;
    }

    public void abrirConexion(){
        try {
            this.conexion = DriverManager.getConnection(ruta, usuario, contrasena);
            //System.out.println("Conexion abierta con la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(){
        try {
            this.conexion.close();
            //System.out.println(("Conexion cerrada con la base de datos."));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarBBDD(){
        this.eliminarUsuarios();
        this.eliminarNotas();
        this.eliminarTransacciones();
    }

    private void eliminarUsuarios(){
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM usuarios;");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }

    private void eliminarNotas(){
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM notas;");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }

    private void eliminarTransacciones(){
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("DELETE FROM transacciones;");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }
}
