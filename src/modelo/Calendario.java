package modelo;


import java.util.ArrayList;

/**
 * Constructor de la clase Calendario. Es una unica instancia del objeto y se crea cada vez que se inicia la aplicación,
 * recibiendo de la base de datos las jornadas correspondientes.
 */
public class Calendario {
    private ArrayList<Jornada> jornadas;


    /**
     * Constructor de Calendario.
     * La clase es un singleton, el constructor crea una unica instancia al iniciar la aplicacion que carga de
     * la base de datos el conjunto de jornadas que guarda.
     */
    public Calendario(){

    }

    //No hacen falta getters y setters porque para eso son los metodos de abajo


    /**
     * Devuelve los beneficios de un dia concreto.
     * @param fecha dia del que obtener los beneficios.
     * @return beneficios de ese dia.
     */
    private int obtenerBeneficios(Fecha fecha){
        return 0;
    }




    /**
     * Devuelve el beneficio en un rango de dias.
     * @param fechainicio primer dia del rango de dias.
     * @param fechafinal ultimo dia del rango de dias.
     * @return beneficio en un rango de dias.
     */
    public int obtenerBeneficios(Fecha fechainicio, Fecha fechafinal){
        return 0;
    }




    /**
     * Devuelve el conjunto de beneficios y gastos en un dia concreto.
     * @param fecha dia concreto del que se quieren ver las transacciones
     * @return conjunto de transacciones de un dia.
     */
        private ArrayList<Transaccion> verTransaccionesDesde(Fecha fecha){
        return new ArrayList<Transaccion>();
    }




    /**
     * Devuelve el conjunto de beneficios y gastos en un rango de dias.
     * @param fechainicio primer dia del rango de dias.
     * @param fechafinal ultimo dia del rango de dias.
     * @return conjunto de transacciones de un rango de dias.
     */
    public ArrayList<Transaccion> verTransaccionesDesde(Fecha fechainicio, Fecha fechafinal){
        return new ArrayList<Transaccion>();
    }




    /**
     * Devuelve el conjunto de beneficios y gastos en un dia concreto de un usuario concreto.
     * @param fecha dia del que obtener las transacciones.
     * @param usuario usuario que realizo las transacciones.
     * @return conjunto de transacciones de un dia y un usuario concretos.
     */
    private ArrayList<Transaccion> verTransaccionesDe(Fecha fecha, Usuario usuario){
        return new ArrayList<Transaccion>();
    }


    /**
     * Devuelve el conjunto de beneficios y gastos en un rango de dias de un usuario concreto.
     * @param fechainicio primer dia del rango de dias.
     * @param fechafin ultimo dia del rango de dias.
     * @param usuario usuario del que obtener los beneficios.
     * @return Conjunto de transacciones de un usuario concreto en un rango de dias
     */
    private ArrayList<Transaccion> verTransaccionesDe(Fecha fechainicio, Fecha fechafin, Usuario usuario){
        return new ArrayList<Transaccion>();
    }


}