package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*public class NotaTest {

    private Nota nota1;
    private Nota nota2;
    private Nota nota3;
    private Usuario felipe;
    private Usuario adri;
    private Fecha hoy;

    @Before
    public void setUp() throws Exception{
        felipe = new Usuario("Felipe", "123", false);
        adri = new Usuario("Adri", "456", false);
        hoy = new Fecha(6, 1, 2019);

        nota1 = new Nota("Hola", felipe, adri, hoy, null, null);
        nota2 = new Nota("ey", adri, felipe, hoy, nota1, null);
        nota3 = new Nota("Hola", felipe, adri, hoy, null, null);
    }

    @Test (expected = BeerBarException.class)
    public void testConstructorExcepcion() throws BeerBarException {
        Nota notaEx = new Nota("Prueba excepcion", felipe, null, hoy, null, null);
    }

    @Test
    public void testGetTexto(){
        assertEquals("Hola", nota1.getTexto());
    }

    @Test
    public void testGetRemitente(){
        assertEquals(felipe, nota1.getRemitente());
    }

    @Test
    public void testGetDestinatario(){
        assertEquals(adri, nota1.getDestinatario());
    }

    @Test
    public void testGetFecha(){
        assertEquals(hoy, nota1.getFecha());
    }

    @Test
    public void testGetMadre(){
        assertEquals(nota1, nota2.getMadre());
    }

    @Test
    public void testGetHija(){
        assertEquals(nota2, nota1.getHija());
    }

    @Test
    public void testEsLeida(){
        nota1.setLeida(true);
        assertTrue(nota1.esLeida());
    }

    @Test
    public void testEsLeidaFalse(){
        assertFalse(nota1.esLeida());
    }

    @Test
    public void testSetTexto(){
        nota1.setTexto("Texto nuevo");
        assertEquals("Texto nuevo", nota1.getTexto());
    }

    @Test
    public void testSetMadre(){
        nota1.setMadre(nota3);
        assertEquals(nota3, nota1.getMadre());
    }

    @Test
    public void testSetHija(){
        nota1.setHija(nota3);
        assertEquals(nota3, nota1.getHija());
    }

    @Test
    public void testSetLeida(){
        nota1.setLeida(true);
        assertTrue(nota1.esLeida());
    }

    @Test
    public void testEsRemitente(){
        assertTrue(nota1.esRemitente(felipe));
    }

    @Test
    public void testEsDestinatario(){
        assertTrue(nota1.esDestinatario(adri));
    }

    @Test
    public void testEstaEscritaEn(){
        assertTrue(nota1.estaEscritaEn(hoy));
    }

    @Test
    public void testEsHijaDe(){
        assertTrue(nota2.esHijaDe(nota1));
    }

    @Test
    public void testEsMadreDe(){
        assertTrue(nota1.esMadreDe(nota2));
    }

    @Test
    public void testEquals(){
        assertTrue(nota1.equals(nota3));
    }
}*/
