package bbdd;

import controlador.ControladorInicio;
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


    private void asignarHijaA(int idmadre, int idhija){
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE notas SET hija = " + idhija +
                    " WHERE id_nota = " + idmadre + " ;");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
    }

    private Nota getNota(String id) throws BeerBarException {

        Nota nota = null;
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM notas WHERE id_nota="+entrecomilla(id) +";");
            ResultSet rs = st.executeQuery();
            ArrayList<Nota> lista = this.getNotas(rs);
            if(lista.size() != 0) nota = lista.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        return nota;
    }

    public ArrayList<Nota> devuelveNotas() throws BeerBarException {
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

    public int nuevoIdNota(){
        this.abrirConexion();
        int salida = 0;
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT MAX(id_nota) FROM notas");
            ResultSet rs = st.executeQuery();
            if(rs.next()) salida = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        return salida+1;
    }


    public void introduceNota(String remitente, String destinatario, String fecha, Nota madre, Nota hija, String texto){
        this.abrirConexion();
        int m = 0;
        int h = 0;
        if(madre != null) m = getID(madre);
        if(hija != null) h = getID(madre);

        try {
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO notas VALUES ("+
                    nuevoIdNota() + ", " + entrecomilla(remitente)+", " + entrecomilla(destinatario) +", " +
                    entrecomilla(fecha) + ", "+ m + ", " + h + ", " + entrecomilla(texto) +
                    ", " + "'no'" + ");");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getID(Nota nota){
        int id = 0;
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT id_nota FROM notas WHERE " +
                    "remitente_nombre = "+ this.entrecomilla(nota.getRemitente().getNombre()) +
                    "AND destinatario_nombre = "+ this.entrecomilla(nota.getDestinatario().getNombre()) +
                    "AND fecha = "+ this.entrecomilla(nota.getFecha().toStringAbreviado()) +
                    "AND texto = "+ this.entrecomilla(nota.getTexto()) + ";");
            ResultSet rs = st.executeQuery();
            if(rs.next()) id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return id;
    }


}
