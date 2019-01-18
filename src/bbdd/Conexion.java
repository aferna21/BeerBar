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
}
