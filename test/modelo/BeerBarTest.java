package modelo;

import static org.junit.Assert.*;

import controlador.BeerBar;
import org.junit.Before;
import org.junit.Test;

public class BeerBarTest {

    private BeerBar beerbar;

    @Before
    public void setUp() throws Exception{
        beerbar = new BeerBar(Jornada.darInstancia());
    }

    @Test
    public void test(){
        assertEquals(1, 1);
    }
}
