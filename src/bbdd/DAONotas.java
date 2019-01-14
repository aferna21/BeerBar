package bbdd;

import modelo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAONotas extends Conexion {
    /**
     * Columnas:                    Atributos de la clase
     * id_nota                      texto (string)
     * remitente_nombre             remitente(usuario)
     * destinatario_nombre          destinatario(usuario)
     * fecha                        fecha(Fecha)
     * madre                        madre(Nota)
     * hija                         hija(Nota)
     * texto                        esLeida(boolean)
     * esleida
     */

    private String entrecomilla(String s){
        return "'"+ s + "'";
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


    private ArrayList<Nota> getNotas(ResultSet rs) throws SQLException, BeerBarException {
        ArrayList<Nota> salida = new ArrayList<Nota>();
        while(rs.next()){
            String texto = rs.getString("texto");
            Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(rs.getString("remitente_nombre"));
            Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(rs.getString("destinatario_nombre"));
            Fecha fecha = new Fecha().fromStringAbreviadoToFecha(rs.getString("fecha"));
            String idmadre = rs.getString("madre");
            String idhija = rs.getString("hija");
            Nota madre=null;
            Nota hija = null;
            if(idmadre != null){
                madre = getNota(idmadre);
            }
            if(idhija != null){
                hija = getNota(idhija);
            }
            boolean esLeida = fromStringToBool(rs.getString("esleida"));
            Nota nota = new Nota(texto, remitente, destinatario, fecha, madre, hija);
            salida.add(nota);
        }
        return salida;
    }




    private Nota getNota(String id) throws BeerBarException {
        Nota nota = null;
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM notas WHERE id_nota="+entrecomilla(id) +";");
            ResultSet rs = st.executeQuery();
            nota = this.getNotas(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        return nota;
    }

    private ArrayList<Nota> devuelveNotas() throws BeerBarException {
        ArrayList<Nota> notas = new ArrayList<Nota>();

        this.abrirConexion();

        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM notas");
            ResultSet rs = st.executeQuery();

            notas = getNotas(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();

        return notas;
    }
}
