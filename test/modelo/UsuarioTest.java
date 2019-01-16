package modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        assertFalse(usuarioNormal.getEsAdmin());
    }

   /* @Test
    public void testEscribirNotaA() throws BeerBarException {

        Fecha hoy = new Fecha().getFechaActual();
        Usuario pedro = new Usuario("Pedro", "123", false);
        usuarioNormal.escribirNota(pedro, "Hola");
        assertEquals("Hola", pedro.verNotasRecibidas().get(0).getTexto());

    }


    @Test
    public void testVerNotasEnviadas() throws BeerBarException {
        Fecha f = new Fecha().getFechaActual();
        Nota nota1 = new Nota("Vamos a probar 1", usuarioAdmin, usuarioNormal, f, null, null);
        Nota nota2 = new Nota("Vamos a probar 2", usuarioAdmin, usuarioNormal, f, null, null);
        assertEquals(0, usuarioAdmin.verNotasEnviadas().size());
        usuarioAdmin.escribirNota(usuarioNormal, "hola");
        assertEquals(1, usuarioAdmin.verNotasEnviadas().size());
        ServidorDeMensajeria.darInstancia().anadirNota(nota1);
        ServidorDeMensajeria.darInstancia().anadirNota(nota2);
        assertEquals(3, usuarioAdmin.verNotasEnviadas().size());
        assertTrue(usuarioAdmin.verNotasEnviadas().get(1).getTexto().equals("Vamos a probar 1"));
    }


    @Test
    public void testVerNotasHacia() throws BeerBarException{
        Usuario a = new Usuario("Juan", "JuanMola123", false);
        usuarioNormal.escribirNota(a, "hola Mundo");
        Assert.assertEquals(1, usuarioNormal.verNotasHacia(a).size());
    }


    @Test
    public void testVerNotasDe() throws BeerBarException{
        usuarioNormal.escribirNota(usuarioAdmin, "hola Mundo");
        Assert.assertEquals(1, usuarioAdmin.verNotasDe(usuarioNormal).size());
    }


    @Test
    public void testVerNotasRecibidas()throws BeerBarException{
        Usuario usuario1 = new Usuario("Pedro", "abc", false);
        usuarioNormal.escribirNota(usuario1, "hola Mundo");
        usuarioNormal.escribirNota(usuario1, "hola A Secas");
        new Usuario("Adri", "admin", false).escribirNota(usuario1, "hola de Adri");
        Assert.assertEquals(3, usuario1.verNotasRecibidas().size());
    }*/

}
