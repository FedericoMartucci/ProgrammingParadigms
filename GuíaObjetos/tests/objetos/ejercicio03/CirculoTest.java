package objetos.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CirculoTest {

	@Test
	public void creacionCirculoSinParametros() {
		Circulo c = new Circulo();

		assertNotNull(c);
		assertEquals(0, c.getRadio());
	}

	@Test
	public void creacionCirculo() {
		Circulo c = new Circulo(2);

		assertNotNull(c);
		assertEquals(2, c.getRadio());
	}

	@Test
	public void cambiarValorRadio() {
		Circulo c = new Circulo();

		c.setRadio(3);
		assertEquals(3, c.getRadio());
	}

	@Test
	public void cambiarValorDiametro() {
		Circulo c = new Circulo();
		
		c.setDiametro(4);

		assertEquals(2, c.getRadio());
	}

	@Test
	public void obtenerValorDiametro() {
		Circulo c = new Circulo(5);

		assertEquals(10, c.getDiametro());
	}

	@Test
	public void cambiarValorPerimetro() {
		Circulo c = new Circulo();
		
		c.setPerimetro(10);

		assertEquals(10/(2 * Math.PI), c.getRadio());
	}

	@Test
	public void obtenerValorPerimetro() {
		Circulo c = new Circulo(20);

		assertEquals(20 * 2 * Math.PI, c.getPerimetro());
	}

	@Test
	public void cambiarValorArea() {
		Circulo c = new Circulo();
		
		c.setArea(10);

		assertEquals(Math.sqrt(10 / Math.PI), c.getRadio());
	}

	@Test
	public void obtenerValorArea() {
		Circulo c = new Circulo(20);

		assertEquals(Math.PI * Math.pow(20, 2), c.getArea());
	}

}