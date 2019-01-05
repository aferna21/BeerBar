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
    public void testSetDia() {

        assertEquals(1, fecha.getDia());
        fecha.setDia(10);
        assertEquals(10, fecha.getDia());
        assertNotEquals(1, fecha.getDia());
    }

    @Test
    public void testSetMes() {

        assertEquals(1, fecha.getMes());
        fecha.setMes(12);
        assertEquals(12, fecha.getMes());
        assertNotEquals(1, fecha.getMes());
    }

    @Test
    public void testSetAno() {

        assertEquals(2019, fecha.getAno());
        fecha.setAno(2020);
        assertEquals(2020, fecha.getAno());
        assertNotEquals(2019, fecha.getAno());
    }

    @Test
    public void testEquals() {

        assertTrue(fecha.equals(new Fecha(1, 1, 2019)));
        assertFalse(fecha.equals(new Fecha(2, 1, 2019)));
    }

    @Test
    public void testToString() {
        assertEquals("1 de enero del 2019", fecha.toString());
    }
}