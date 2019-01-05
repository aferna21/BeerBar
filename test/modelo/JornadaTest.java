package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JornadaTest {

    private Jornada jornada;

    @Before
    public void setUp() throws Exception{
        jornada = new Jornada();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
