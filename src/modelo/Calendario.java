package modelo;

/**
 * Constructor de la clase Calendario. Es una unica instancia del objeto y se crea cada vez que se inicia la aplicación,
 * recibiendo de la base de datos las jornadas correspondientes.
 */
public class Calendario {
    private Jornada[] jornada;



    public Calendario(){

    }

    //No hacen falta getters y setters porque para eso son los metodos de abajo


    /**
     * @param fecha dia del que obtener los beneficios
     * @return
     */
    private int obtenerBeneficios(Fecha fecha){
        return 0;
    }




    /**
     * @param fechainicio
     * @param fechafinal
     * @return
     */
    public int obtenerBeneficios(Fecha fechainicio, Fecha fechafinal){
        return 0;
    }




    /**
     * @param fecha
     * @return
     */
    private Transaccion[] verTransaccionesDesde(Fecha fecha){
        return new Transaccion[0];
    }




    /**
     * @param fechainicio
     * @param fechafinal
     * @return
     */
    public Transaccion[] verTransaccionesDesde(Fecha fechainicio, Fecha fechafinal){
        return new Transaccion[0];
    }




    /**
     * @param fecha
     * @param usuario
     * @return
     */
    private Transaccion[] verTransaccionesDe(Fecha fecha, Usuario usuario){
        return new Transaccion[0];
    }




    /**
     * @param fechainicio
     * @param fechafin
     * @param usuario
     * @return
     */
    private Transaccion[] verTransaccionesDe(Fecha fechainicio, Fecha fechafin, Usuario usuario){
        return new Transaccion[0];
    }


}
