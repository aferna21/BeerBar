package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TransaccionTest {

    private Transaccion transaccion;

    @Before
    public void setUp() throws Exception{
        transaccion = new Transaccion();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
