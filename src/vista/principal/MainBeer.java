package vista.principal;

import modelo.*;

import java.util.ArrayList;

public class MainBeer {

    public static void main(String[] args) throws BeerBarException {

        new VentanaBienvenida();
        /*new ControladorInicio().actualizarInformacion();
        Nota nota = new ControladorServidorDeMensajeria().crearNota("holaaa2", "Felipe", "Adri");
        new ControladorServidorDeMensajeria().escribirNota("holaaa", "Felipe", "Adri", null);
        System.out.println(ServidorDeMensajeria.darInstancia().mostrarNotasDe(GestorDeUsuarios.darInstancia().getUsuario("Felipe")).get(0).getTexto());

        //new ControladorServidorDeMensajeria().responderNota(nota, "nota de respuesta2", "Felipe", "Adri");*/
        /*ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(0);
        a.add(0);
        pollita(a);
        System.out.println(a.get(3));
        */

    }

    private static void pollita(ArrayList<Integer> a){
        a.add(3);

    }
}
