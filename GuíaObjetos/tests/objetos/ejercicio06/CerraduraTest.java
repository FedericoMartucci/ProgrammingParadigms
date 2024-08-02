package objetos.ejercicio06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CerraduraTest {
	int clave = 12345;
	int claveIncorrecta = 123456;
	int maxFallosConsecutivos = 3;

	@Test
	public void crearCerradura() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertNotNull(c);
		assertFalse(c.estaAbierta());
		assertFalse(c.fueBloqueada());
		assertEquals(0, c.contarAperturasFallidas());
		assertEquals(0, c.contarAperturasExitosas());
	}

	@Test
	public void verificarSiLaCerraduraEstaCerrada() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		c.cerrar();

		assertFalse(c.estaAbierta());
	}

	@Test
	public void verificarSiLaCerraduraEstaAbierta() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		c.abrir(clave);

		assertTrue(c.estaAbierta());
	}

	@Test
	public void verificarCantAperturasExitosas() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertEquals(0, c.contarAperturasExitosas());
		c.abrir(clave);
		assertEquals(1, c.contarAperturasExitosas());
	}

	@Test
	public void verificarCantAperturasFallidas() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertEquals(0, c.contarAperturasFallidas());
		c.abrir(claveIncorrecta);
		assertEquals(1, c.contarAperturasFallidas());
	}

	@Test
	public void verificarSiLaCerraduraSeBloquea() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertFalse(c.fueBloqueada());
		for (int i = 0; i <= maxFallosConsecutivos; i++)
			c.abrir(claveIncorrecta);
		// Si arrojara una excepcion deberia hacer un assert de la excepcion arrojada.
		assertTrue(c.fueBloqueada());
	}

	public void verificarQueNoSePuedaAbrirSiEstaAbierta() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertTrue(c.abrir(clave));
		assertFalse(c.abrir(clave));
	}

	public void verificarQueSePuedeAbrir() {
		Cerradura c = new Cerradura(clave, maxFallosConsecutivos);

		assertTrue(c.abrir(clave));
	}

}
