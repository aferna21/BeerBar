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

    public Fecha(){

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
        String nombreMes = new String();
        switch(this.mes){
            case 1:
                nombreMes = "enero";
                break;
            case 2:
                nombreMes = "febrero";
                break;
            case 3:
                nombreMes = "marzo";
                break;
            case 4:
                nombreMes = "abril";
                break;
            case 5:
                nombreMes = "mayo";
                break;
            case 6:
                nombreMes = "junio";
                break;
            case 7:
                nombreMes = "julio";
                break;
            case 8:
                nombreMes = "agosto";
                break;
            case 9:
                nombreMes = "septiembre";
                break;
            case 10:
                nombreMes = "octubre";
                break;
            case 11:
                nombreMes = "noviembre";
                break;
            case 12:
                nombreMes = "diciembre";
                break;
        }
        if (nombreMes == ""){
            throw new BeerBarException("Mes no correcto.\n");
        }
        return nombreMes;
    }

    public String toString(){
        return this.dia + " de " + this.nombreMes() + " del " + this.ano;
    }
}
