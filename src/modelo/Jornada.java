package modelo;

import java.util.ArrayList;

public class Jornada {
    private Fecha fecha;
    private ArrayList<Transaccion> transacciones;

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
        return new String();
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
        return 0;
    }

}
