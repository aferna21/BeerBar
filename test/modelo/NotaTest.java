package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class NotaTest {

    private Nota nota1;
    private Usuario felipe;
    private Usuario adri;
    private Fecha hoy;

    @Before
    public void setUp() throws Exception{
        felipe = new Usuario("Felipe", "123", false);
        adri = new Usuario("Adri", "456", false);
        hoy = new Fecha(6, 1, 2019);

        nota1 = new Nota("Nota1", felipe, adri, hoy, null);
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
