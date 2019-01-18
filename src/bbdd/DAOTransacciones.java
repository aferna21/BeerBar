package bbdd;

import modelo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOTransacciones extends Conexion {

    /**
     * Columnas:         |   Atributos de la clase Transaccion:
     *                   |
     * id_transaccion    |   cantidad (float)
     * cantidad          |   concepto (String)
     * fecha             |   fecha (Fecha)
     * usuario           |   usuario (Usuario)
     * concepto          |   esVenta(boolean)
     * esventa
     */

    // Constructor de transaccion: new Transaccion(cantidad, concepto, fecha, usuario)


    public int nuevoIdTransaccion(){
        this.abrirConexion();
        int salida = 0;
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT MAX(id_transaccion) FROM transacciones;");
            ResultSet rs = st.executeQuery();
            if(rs.next()) salida = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        return salida+1;
    }

    private String entrecomilla(String s){
        return "'"+ s + "'";
    }



    public ArrayList<Transaccion> devuelveTransacciones() throws BeerBarException {
        ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
        this.abrirConexion();

        PreparedStatement st = null;
        try {
            st = this.getConexion().prepareStatement("SELECT * FROM transacciones;");
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                float cantidad = rs.getFloat("cantidad");
                String concepto = rs.getString("concepto");
                Fecha fecha = new Fecha().fromStringAbreviadoToFecha(rs.getString("fecha"));
                Usuario usuario = GestorDeUsuarios.darInstancia().getUsuario(rs.getString("usuario"));
                Transaccion t = new Transaccion(cantidad, concepto, fecha, usuario);
                transacciones.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
        return transacciones;
    }

    private String saberEsVenta(float f){
        if (f >= 0){
            return "si";
        }else{
            return "no";
        }
    }

    public void introduceTransaccion(float cantidad, String fecha, String usuario, String concepto){
        this.abrirConexion();

        try {
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO transacciones VALUES (" + this.nuevoIdTransaccion() +
                    ", " + cantidad + ", " + entrecomilla(fecha) + ", " + entrecomilla(usuario) + ", " + entrecomilla(concepto) +
                    ", " + entrecomilla(saberEsVenta(cantidad)) + ");");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
    }

}
