package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ServidorDeMensajeriaTest {

    private ServidorDeMensajeria servidorDeMensajeria;

    @Before
    public void setUp() throws Exception{
        servidorDeMensajeria = new ServidorDeMensajeria();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
