package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

    private Usuario usuario;

    @Before
    public void setUp() throws Exception{
        usuario = new Usuario("", "", false);
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
