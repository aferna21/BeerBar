package modelo;

/**
 * Constructor de la clase Calendario. Es una unica instancia del objeto y se crea cada vez que se inicia la aplicación,
 * recibiendo de la base de datos las jornadas correspondientes.
 */
public class Calendario {
    private Jornadas[] jornada;



    public Calendario(){

    }

    //No hacen falta getters y setters porque para eso son los metodos de abajo


    /**
     * @param fecha
     * @return
     */
    private int obtenerBeneficios(Fecha fecha){
        return 0;
    }

    public int obtenerBeneficios(Fecha fechainicio, Fecha fechafinal){
        return 0;
    }

    private Transacciones[] verTransaccionesDesde(Fecha fecha){
        return new Transacciones[0];
    }

    public Transacciones[] verTransaccionesDesde(Fecha fechainicio, Fecha fechafinal){
        return new Transacciones[0];
    }

    private Transacciones[] verTransaccionesDe(Fecha fecha, Usuario usuario){
        return new Transacciones[0];
    }

    private Transacciones[] verTransaccionesDe(Fecha fechainicio, Fecha fechafin, Usuario usuario){
        return new Transacciones[0];
    }


}
