package modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UsuarioTest {

    private Usuario usuarioNormal;
    private Usuario usuarioAdmin;

    @Before
    public void setUp() throws Exception{
        usuarioNormal = new Usuario("usuario", "pass", false);
        usuarioAdmin = new Usuario("admin", "pass", true);
    }

    @Test
    public void testGetNombre(){
        assertEquals("usuario", usuarioNormal.getNombre());
        assertNotEquals("usuaria", usuarioNormal.getNombre());
    }

    @Test
    public void testGetContrasena(){
        assertEquals("pass", usuarioNormal.getContrasena());
        assertNotEquals("passw", usuarioNormal.getContrasena());
    }

    @Test
    public void testEsAdmin(){
        assertTrue(usuarioAdmin.getEsAdmin());
        assertFalse(usuarioAdmin.getEsAdmin());
    }

    @Test
    public void testEscribirNotaA() throws BeerBarException {

        Fecha hoy = new Fecha().getFechaActual();
        Nota nota = new Nota("Hola", usuarioNormal, usuarioAdmin, hoy, null);

        assertEquals(0, usuarioAdmin.verNotasDe(usuarioNormal).size());
        ServidorDeMensajeria.darInstancia().anadirNota(nota);
        assertEquals("Hola", usuarioAdmin.verNotasDe(usuarioNormal).get(0).getTexto());

    }

}
