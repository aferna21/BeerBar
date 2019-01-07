package modelo;

import java.util.ArrayList;

/**
 * Clase que maneja los dias sobre los que se trabaja. Es un Singleton
 */
public class Jornada {

    private static Jornada instancia = new Jornada();
    private Fecha fecha;
    private ArrayList<Transaccion> transacciones;

    private Jornada(){
        transacciones = new ArrayList<>();
    }

    public static Jornada darInstancia(){
        return instancia;
    }

    public Fecha getFecha(){
        return this.fecha;
    }

    public ArrayList<Transaccion> getTransacciones(){
        return this.transacciones;
    }

    public void setFecha(Fecha fecha){
        this.fecha = fecha;
    }

    public String toString(){
        String output = "*******" + fecha.toString() + "*******";
        for(Transaccion t: transacciones){
            output.concat(t.toString());
        }

        return output;
    }

    //ESTE METODO NO SALE EN EL DIAGRAMA. ANADIR EXCEPCION

    /**
     * Anade una transaccion mas al array de transacciones de la jornada.
     * @param transaccion transaccion anadida a la jornada.
     */
    public void anadirTransaccion(Transaccion transaccion){
        this.transacciones.add(transaccion);
    }


    /**
     * Devuelve el sumatorio de las transacciones de la jornada.
     * @return sumatorio de las transacciones en esta jornada.
     */
    public int sumaTransacciones(){
        int suma = 0;
        for(Transaccion t:transacciones){
            suma += t.getCantidad();
        }
        return suma;
    }

    public ArrayList<Transaccion> verTransaccionesDe(Usuario u){
        ArrayList<Transaccion> output = new ArrayList<Transaccion>();
        for(Transaccion t:this.transacciones){
            if(t.getUsuario().equals(u)){
                output.add(t);
            }
        }
        return output;
    }

}
