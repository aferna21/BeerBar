package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) throws BeerBarException {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
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

    public void setDia(int d) throws BeerBarException {

        int[] meses31dias = {1, 3, 5, 7, 8, 10, 12};
        int[] meses30dias = {4, 6, 9, 11};
        int[] meses28dias = {2};


        if (contieneMes(meses31dias) && d >= 1 && d <= 31) {
            this.dia = d;
        } else if (contieneMes(meses30dias) && d >= 1 && d <= 30) {
            this.dia = d;
        } else if (contieneMes(meses28dias) && !esAnoBisiesto() && (d >= 1 && d <= 28)) {
            this.dia = d;
        } else if (contieneMes(meses28dias) && esAnoBisiesto() && (d >= 1 && d <= 29)) {
            this.dia = d;
        }else{
            throw new BeerBarException("Dia no correcto.\n");
        }
    }

    private boolean esAnoBisiesto(){

        if ((this.getAno() % 4 == 0) && ((this.getAno() % 100 != 0) || (this.getAno() % 400 == 0))) {
            return true;
        }else {
            return false;
        }
    }

    private boolean contieneMes(int[] meses){
        for(int m : meses){
            if (m == this.getMes()){
                return true;
            }
        }
        return false;
    }

    public void setMes(int m) throws BeerBarException {
        if (m >= 1 && m <= 12){
            this.mes = m;
        }else{
            throw new BeerBarException("Mes no correcto.\n");
        }

    }

    public void setAno(int a) throws BeerBarException {
        if (a >= 2019 && a <= 2099) {
            this.ano = a;
        }else{
            throw new BeerBarException("Ano no correcto.\n");
        }

    }


    public boolean equals(Fecha f){
        return this.dia == f.getDia()  &&  this.mes == f.getMes()  &&  this.ano == f.getAno();
    }

    /**
     * CAMBIAR PARA QUE DEVUELVA EL DIA DE HOY CORRECTAMENTE
     * LO DEJO ASI PARA LOS TEST DE MOMENTO
     * @return
     */
    public Fecha getFechaActual() throws BeerBarException {

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(date);

        return new Fecha(Integer.parseInt(formattedDate.split("/")[0]),
                Integer.parseInt(formattedDate.split("/")[1]),
                        Integer.parseInt(formattedDate.split("/")[2]));
    }

    /**
     * Devuelve el nombre correspondiente al numero del mes
     * @return nombre del mes
     */
    private String getNombreMes() throws BeerBarException {
        String nombreMes = "";
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
        if (nombreMes.equals("")){
            throw new BeerBarException("Mes no correcto.\n");
        }
        return nombreMes;
    }

    public String toString(){
        String str = "";
        try {
            str = this.dia + " de " + this.getNombreMes() + " del " + this.ano;
        } catch (BeerBarException e) {
            e.printStackTrace();
        }
        return str;
    }

    private int diasDelMes(int mes){
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            return 31;
        }else if( mes == 2){
            return 28;
        }else{
            return 30;
        }
    }

    public boolean esBisiesto(){
        return this.ano % 4 == 0;
    }

    /*ME DA PENA BORRARLA :(
    public int numeroDeDiaDelAno(){
        int suma = 0;
        for(int i = 0; i < this.mes-1; i++){
            suma += this.diasDelMes(i);
        }
        suma+=this.dia;

        if (esBisiesto()) suma++;
        return suma;
    }
    */

    public void avanza(){
        this.dia++;

        if(this.dia > diasDelMes(this.mes)){

            if(!(esBisiesto() && this.dia == 28 && this.mes == 2)) {
                this.mes++;
                this.dia = 1;
                if (this.mes > 12) {
                    this.mes = 1;
                }
            }
        }
    }
}
