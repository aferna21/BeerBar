package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TransaccionTest {

    private Transaccion transaccion;

    @Before
    public void setUp() throws Exception{
        transaccion = new Transaccion(20, "", new Fecha().getFechaActual(), new Usuario("admin", "admin", true));
    }

    @Test
    public void testEsUsuario(){
        assertTrue(transaccion.esUsuario(new Usuario("admin", "admin", true)));
        assertFalse(transaccion.esUsuario(new Usuario("admin1", "admin", true)));
    }

    @Test
    public void testEsFecha() throws BeerBarException {
        assertTrue(transaccion.estaEscritaEn(new Fecha().getFechaActual()));
        assertFalse(transaccion.estaEscritaEn(new Fecha(1,1,2019)));
    }
}
