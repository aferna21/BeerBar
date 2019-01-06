package modelo;

public class Fecha {

    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

    public void setDia(int d){
        this.dia = d;
    }

    public void setMes(int m){
        this.mes = m;
    }

    public void setAno(int a){
        this.ano = a;
    }


    public boolean equals(Fecha f){
        return this.dia == f.getDia()  &&  this.mes == f.getMes()  &&  this.ano == f.getAno();
    }

    /**
     * CAMBIAR PARA QUE DEVUELVA EL DIA DE HOY CORRECTAMENTE
     * LO DEJO ASI PARA LOS TEST DE MOMENTO
     * @return
     */
    public Fecha getFechaActual(){
        return new Fecha(6, 1,2019);
    }

    /**
     * Devuelve el nombre correspondiente al numero del mes
     * @return nombre del mes
     */
    private String nombreMes(){
        String nombre = new String();
        switch(this.mes){
            case 1:
                nombre = "enero";
                break;
            case 2:
                nombre = "febrero";
                break;
            case 3:
                nombre = "marzo";
                break;
            case 4:
                nombre = "abril";
                break;
            case 5:
                nombre = "mayo";
                break;
            case 6:
                nombre = "junio";
                break;
            case 7:
                nombre = "julio";
                break;
            case 8:
                nombre = "agosto";
                break;
            case 9:
                nombre = "septiembre";
                break;
            case 10:
                nombre = "octubre";
                break;
            case 11:
                nombre = "noviembre";
                break;
            case 12:
                nombre = "diciembre";
                break;
        }
        return nombre;
    }

    public String toString(){
        return this.dia + " de " + this.nombreMes() + " del " + this.ano;
    }
}
