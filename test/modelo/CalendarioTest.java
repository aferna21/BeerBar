package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalendarioTest {

    private Calendario calendario;

    @Before
    public void setUp() throws Exception{
        calendario = new Calendario();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
