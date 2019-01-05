package bbdd;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConectorTest {

    private Conector conector;

    @Before
    public void setUp() throws Exception{
        conector = new Conector();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
