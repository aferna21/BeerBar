package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FechaTest {

    private Fecha fecha;

    @Before
    public void setUp() throws Exception {

        fecha = new Fecha(1, 1, 2019);
    }

    @Test
    public void testGetDia() {
        assertEquals(1, fecha.getDia());
        assertNotEquals(2, fecha.getDia());
    }

    @Test
    public void testGetMes() {
        assertEquals(1, fecha.getMes());
        assertNotEquals(2, fecha.getMes());
    }

    @Test
    public void testGetAno() {
        assertEquals(2019, fecha.getAno());
        assertNotEquals(2020, fecha.getAno());
    }

    @Test
    public void testSetDia() throws BeerBarException {
        assertEquals(1, fecha.getDia());
        fecha.setDia(10);
        assertEquals(10, fecha.getDia());
        assertNotEquals(1, fecha.getDia());
    }

    @Test
    public void testSetMes() throws BeerBarException {
        assertEquals(1, fecha.getMes());
        fecha.setMes(12);
        assertEquals(12, fecha.getMes());
        assertNotEquals(1, fecha.getMes());
    }

    @Test
    public void testSetAno() throws BeerBarException {
        assertEquals(2019, fecha.getAno());
        fecha.setAno(2020);
        assertEquals(2020, fecha.getAno());
        assertNotEquals(2019, fecha.getAno());
    }

    @Test
    public void testEquals() throws BeerBarException {
        assertTrue(fecha.equals(new Fecha(1, 1, 2019)));
        assertFalse(fecha.equals(new Fecha(2, 1, 2019)));
    }

    @Test
    public void testToString() {
        assertEquals("1 de enero del 2019", fecha.toString());
    }

    @Test
    public void testGetFechaActual() throws BeerBarException {
        Fecha f = new Fecha().getFechaActual();
        assertEquals(6, f.getDia());
        assertEquals(1, f.getMes());
        assertEquals(2019, f.getAno());
        assertEquals("6 de enero del 2019", f.toString());
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testGetNombreMesException() throws BeerBarException {

        fecha.setMes(13);
        String nombreMes = fecha.toString();
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetAno3000() throws BeerBarException {

        fecha.setAno(3000);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetMes0() throws BeerBarException {

        fecha.setMes(0);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetMes13() throws BeerBarException {

        fecha.setMes(13);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetDia0() throws BeerBarException {

        fecha.setDia(0);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetDia32enero() throws BeerBarException {

        fecha.setDia(32);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetDia31abril() throws BeerBarException {

        fecha.setMes(4);
        fecha.setDia(31);
    }

    @Test (expected = modelo.BeerBarException.class)
    public void testSetDia29febreroNoBisiesto() throws BeerBarException {

        fecha.setMes(2);
        fecha.setDia(29);
    }

    public void testSetDia29febreroSiBisiesto() throws BeerBarException {

        fecha.setAno(2020);
        fecha.setDia(29);
    }



}