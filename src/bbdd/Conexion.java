package bbdd;
import com.mysql.cj.MysqlConnection;

import java.sql.*;
import javax.sql.*;

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
            System.out.println("Conexion abierta con la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(){
        try {
            this.conexion.close();
            System.out.println(("Conexion cerrada con la base de datos."));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Creacion de las tablas.
    public void creartablas() throws SQLException {
        String usuarios = "CREATE TABLE usuarios\n" +
                "(\n" +
                "nombre_usuario VARCHAR(20) PRIMARY KEY,\n" +
                "contrasena VARCHAR(20),\n" +
                "esAdmin CHAR(2)\n" +
                ");\n";
        String notas = "CREATE TABLE notas\n" +
                "(\n" +
                "id_nota INTEGER(8) PRIMARY KEY,\n" +
                "remitente_nombre VARCHAR(20), \n" +
                "destinatario_nombre VARCHAR(20),\n" +
                "fecha VARCHAR(50),\n" +
                "madre INTEGER(8),\n" +
                "hija INTEGER(8),\n" +
                "texto VARCHAR(4000)\n" +
                ");\n";

        String transacciones = "CREATE TABLE transacciones\n" +
                "(\n" +
                "id_transaccion INTEGER(8) PRIMARY KEY,\n" +
                "cantidad FLOAT(6),\n" +
                "fecha VARCHAR(50),\n" +
                "usuario VARCHAR(20)\n" +
                ");\n";

        String total = usuarios + notas + transacciones;
        Statement st = conexion.createStatement();
        st.executeUpdate(usuarios);
        st.executeUpdate(notas);
        st.executeUpdate(transacciones);
        System.out.println("Tablas creadas!");

    }

}
