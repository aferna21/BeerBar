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
     * madre                        madre(int)
     * hija                         hija(int)
     * texto                        esLeida(boolean)
     * esleida                      contador(int)
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

    private ArrayList<Nota> getNotas(ResultSet rs) throws SQLException, BeerBarException {
        ArrayList<Nota> salida = new ArrayList<Nota>();
        while(rs.next()){
            String texto = rs.getString("texto");
            Usuario remitente = GestorDeUsuarios.darInstancia().getUsuario(rs.getString("remitente_nombre"));
            Usuario destinatario = GestorDeUsuarios.darInstancia().getUsuario(rs.getString("destinatario_nombre"));
            Fecha fecha = new Fecha().fromStringAbreviadoToFecha(rs.getString("fecha"));
            int idmadre = rs.getInt("madre");
            int idhija = rs.getInt("hija");
            boolean esLeida = fromStringToBool(rs.getString("esleida"));
            Nota nota = new Nota(texto, remitente, destinatario, fecha, idmadre, idhija, rs.getInt("id_nota"));
            nota.setHija(rs.getInt("hija"));
            nota.setLeida(esLeida);
            salida.add(nota);
        }
        return salida;
    }

    public void asignarHijaA(int notamadre, int notahija){

        try {
            this.abrirConexion();
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE notas SET hija = " + notahija +
                    " WHERE id_nota = " + notamadre + " ;");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
    }

    private Nota getNota(int id, boolean esMadre, boolean esHija) throws BeerBarException {
        System.out.println("Estamos en getNota(int id). Le he pasado el int: " + id);
        Nota nota = null;
        this.abrirConexion();
        try {
            PreparedStatement st = this.getConexion().prepareStatement("SELECT * FROM notas WHERE id_nota='"+id +"';");
            ResultSet rs = st.executeQuery();
            ArrayList<Nota> lista = this.getNotas(rs);
            if(lista.size() != 0) nota = lista.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        System.out.println("texto de la nota que devuelvo: "+ nota.getTexto());
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


    public void introduceNota(int id_nota, String remitente, String destinatario, String fecha, int madre, int hija, String texto){
        this.abrirConexion();

        if(id_nota == 0) id_nota = nuevoIdNota();

        try {
            PreparedStatement st = this.getConexion().prepareStatement("INSERT INTO notas VALUES ("+
                    id_nota + ", " + entrecomilla(remitente)+", " + entrecomilla(destinatario) +", " +
                    entrecomilla(fecha) + ", "+ madre + ", " + hija + ", " + entrecomilla(texto) +
                    ", " + "'no'" + ");");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cambiaEsLeido(String esleido, int idNota){
        this.abrirConexion();

        try {
            PreparedStatement st = this.getConexion().prepareStatement("UPDATE notas SET esleida = " +
                    entrecomilla(esleido) + " WHERE id_nota = '" + idNota + "';");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
    }

    public void eliminaNota(int id, int idhija, int idmadre){
        this.abrirConexion();
        PreparedStatement st = null;
        try {
            st = this.getConexion().prepareStatement("DELETE FROM notas WHERE id_nota="+id+ ";");
            st.executeUpdate();
            if(idhija != 0){
                st = this.getConexion().prepareStatement("UPDATE notas SET madre = 0 WHERE id_nota = "+idhija+";");
                st.executeUpdate();
            }
            if(idmadre != 0){
                st = this.getConexion().prepareStatement("UPDATE notas SET hija = 0 WHERE id_nota = "+idmadre+";");
                st.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }
}
