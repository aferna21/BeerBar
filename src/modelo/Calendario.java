package modelo;

import java.util.ArrayList;

/**
 * Constructor de la clase Calendario. Es una unica instancia del objeto y se crea cada vez que se inicia la aplicación,
 * recibiendo de la base de datos las jornadas correspondientes.
 */
public class Calendario {

    private ArrayList<Jornada> jornadas;
    private static Calendario instancia = new Calendario();

    private Calendario(){
        jornadas = new ArrayList<Jornada>();
    }


    /**
     * Constructor de Calendario.
     * La clase es un singleton, el constructor crea una unica instancia al iniciar la aplicacion que carga de
     * la base de datos el conjunto de jornadas que guarda.
     * @return instancia de la clase Calendario.
     */
    public static Calendario darInstancia(){
        return instancia;
    }

    //No hacen falta getters y setters porque para eso son los metodos de abajo


    /**
     * Devuelve los beneficios de un dia concreto.
     * @param fecha dia del que obtener los beneficios.
     * @return beneficios de ese dia.
     */

    private Jornada buscarJornada(Fecha fecha){
        for(Jornada j:jornadas){
            if(fecha.equals(j.getFecha())){
                return j;
            }
        }

        return null;
    }

    private float obtenerBeneficios(Fecha fecha){
        Jornada jornada = buscarJornada(fecha);
        if(jornada == null){
            return 0;
        }else{
            return jornada.sumaTransacciones();
        }
    }

    /**
     * Devuelve el beneficio en un rango de dias.
     * @param fechainicio primer dia del rango de dias.
     * @param fechafinal ultimo dia del rango de dias.
     * @return beneficio en un rango de dias.
     */
    public float obtenerBeneficios(Fecha fechainicio, Fecha fechafinal){
        float suma = 0;
        Fecha fechaux = fechainicio;
        while(!fechaux.equals(fechafinal)){
            suma += this.obtenerBeneficios(fechaux);
            fechaux.avanza();
        }
        suma += this.obtenerBeneficios(fechaux);
        return suma;
    }

    /**
     * Devuelve el conjunto de beneficios y gastos en un dia concreto.
     * @param fecha dia concreto del que se quieren ver las transacciones
     * @return conjunto de transacciones de un dia.
     */
    public ArrayList<Transaccion> verTransaccionesDelDia(Fecha fecha){
        if(buscarJornada(fecha) == null){
            this.jornadas.add(new Jornada(fecha, new ArrayList<>()));
            return new ArrayList<>();
        }

        return buscarJornada(fecha).getTransacciones();
    }

    /**
     * Devuelve el conjunto de beneficios y gastos en un rango de dias.
     * @param fechainicio primer dia del rango de dias.
     * @param fechafinal ultimo dia del rango de dias.
     * @return conjunto de transacciones de un rango de dias.
     */
    public ArrayList<Transaccion> verTransaccionesDeLosDias(Fecha fechainicio, Fecha fechafinal){
        ArrayList<Transaccion> output = new ArrayList<Transaccion>();
        Fecha fechaux = fechainicio;
        while(!fechaux.equals(fechafinal)){
            if(this.getJornada(fechaux) == null){
                ArrayList<Transaccion> transacciones = new ArrayList<>();
                this.jornadas.add(new Jornada(fechaux, transacciones));
            }
            else {
                output.addAll(this.verTransaccionesDelDia(fechaux));
            }
            fechaux.avanza();
        }
        if(this.getJornada(fechaux) == null){
            this.jornadas.add(new Jornada(fechaux, new ArrayList<Transaccion>()));
        }
        else {
            output.addAll(this.verTransaccionesDelDia(fechaux));
        }
        return output;
    }

    public void anadirJornada(Jornada jornada){
        this.jornadas.add(jornada);
    }

    public boolean existeDia(Fecha f){
        boolean existe = false;
        for(Jornada j:this.jornadas){
            if(j.getFecha().equals(f)){
                existe = true;
            }
        }
        return existe;
    }

    public Jornada getJornada(Fecha f){
        for(Jornada j:this.jornadas){
            if(j.getFecha().equals(f)){
                return j;
            }
        }
        return null;
    }
}
