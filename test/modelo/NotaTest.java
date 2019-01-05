package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NotaTest {

    private Nota nota;

    @Before
    public void setUp() throws Exception{
        nota = new Nota();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
