package objetos.ejercicio04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CuboTest {
	
	@Test
	public void creacionCubo() {
		Cubo c = new Cubo(2);

		assertNotNull(c);
		assertEquals(2, c.obtenerLado());
	}

	@Test
	public void cambiarValorLado() {
		Cubo c = new Cubo(1);

		assertEquals(1, c.obtenerLado());
		
		c.cambiarLado(3);
		assertEquals(3, c.obtenerLado());
	}

	@Test
	public void cambiarValorArea() {
		int valorArea = 250;
		Cubo c = new Cubo(2);
		
		c.cambiarAreaCara(valorArea);

		assertEquals(Math.sqrt(valorArea), c.obtenerLado());
	}

	@Test
	public void obtenerValorArea() {
		int lado = 3;
		Cubo c = new Cubo(lado);

		assertEquals(lado * lado, c.obtenerAreaCara());
	}

	@Test
	public void cambiarValorVolumen() {
		int valorVolumen = 250;
		Cubo c = new Cubo(2);
		
		c.cambiarVolumen(valorVolumen);

		assertEquals(Math.pow(valorVolumen, 1/3), c.obtenerLado());
	}

	@Test
	public void obtenerValorVolumen() {
		int lado = 3;
		Cubo c = new Cubo(lado);

		assertEquals(lado * lado * lado, c.obtenerVolumen());
	}

}