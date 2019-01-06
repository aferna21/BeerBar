package bbdd;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConexionTest {

    private Conexion conexion;

    @Before
    public void setUp() throws Exception{
        conexion = new Conexion();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
