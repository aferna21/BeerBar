package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BeerBarTest {

    private BeerBar beerbar;

    @Before
    public void setUp() throws Exception{
        beerbar = new BeerBar();
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
