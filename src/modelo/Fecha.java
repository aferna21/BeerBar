package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    /**
     * Dia de la fecha.
     */
    private int dia;

    /**
     * Mes de la fecha.
     */
    private int mes;

    /**
     * Ano de la fecha.
     */
    private int ano;


    /**
     * Constructor de Fecha.
     * Crea un objeto Fecha, con dia, mes y ano.
     * Antes comprueba que son datos correctos.
     */
    public Fecha(int dia, int mes, int ano) throws BeerBarException {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    /**
     * Constructor vacio de Fecha.
     */
    public Fecha(){

    }

    /**
     * Getters y setters.
     */

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

    /**
     * Comprueba si el ano de la fecha es bisiesto.
     * @return si es bisiesto o no
     */
    private boolean esAnoBisiesto(){

        if ((this.ano % 4 == 0) && ((this.ano % 100 != 0) || (this.ano % 400 == 0))) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * Comprueba si el mes esta en el grupo de meses.
     * @param meses array de meses que tienen 31 dias, 30 o 28.
     * @return si el mes esta dentro de ese grupo de meses.
     */
    private boolean contieneMes(int[] meses){
        for(int m : meses){
            if (m == this.mes){
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
        if (a > 0) {
            this.ano = a;
        }else{
            throw new BeerBarException("Ano no correcto.\n");
        }

    }

    /**
     * Dos fechas son consideradas iguales cuando el dia, mes y ano coinciden.
     * @param f - Fecha a comparar.
     * @return - True si son los mismos.
     */
    public boolean equals(Fecha f){
        return this.dia == f.getDia()  &&  this.mes == f.getMes()  &&  this.ano == f.getAno();
    }

    /**
     * Crea un objeto Fecha con la fecha actual.
     * @return un objeto clase Fecha con la fecha actual.
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
     * Devuelve el nombre correspondiente al numero del mes.
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

    private int diasDelMes(){
        if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12){
            return 31;
        }else if(this.mes == 2){
            return 28;
        }else{
            return 30;
        }
    }


    /**
     * Avanza el dia del ano.
     * Si es 28 de febrero, comprueba si es bisiesto o no.
     * Si es 31 de diciembre, pasa a 1 de enero del ano siguiente.
     */
    public void avanza(){
        this.dia++;

        if(this.dia > diasDelMes()){

            if(!(esAnoBisiesto() && this.dia == 28 && this.mes == 2)) {
                this.mes++;
                this.dia = 1;
                if (this.mes > 12) {
                    this.mes = 1;
                    this.ano++;
                }
            }
        }
    }


    public String toStringAbreviado(){
        return this.dia + "/" + this.mes + "/" + this.ano;
    }

    public Fecha fromStringAbreviadoToFecha(String s) throws BeerBarException {
        String[] partes = s.split("/");
        int dia = Integer.valueOf(partes[0]);
        int mes = Integer.valueOf(partes[1]);
        int ano = Integer.valueOf(partes[2]);
        return new Fecha(dia, mes, ano);
    }


    public boolean esMasTardiaQue(Fecha fecha){
        if(this.ano < fecha.getAno()){
            return false;
        }else if (this.ano > fecha.getAno()){
            return true;
        }else{
            if(this.mes < fecha.getMes()){
                return false;
            }else if( this.mes > fecha.getMes()){
                return true;
            }else{
                if(this.dia < fecha.getDia()){
                    return false;
                }else{
                    return true;
                }
            }
        }
    }
}
