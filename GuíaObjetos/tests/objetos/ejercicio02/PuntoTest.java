package objetos.ejercicio02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PuntoTest {

	@Test
	public void creacionPuntoSinParametros() {
		Punto p = new Punto();

		assertNotNull(p);
		assertEquals(0, p.obtenerX());
		assertEquals(0, p.obtenerY());
	}

	@Test
	public void creacionPunto() {
		Punto p = new Punto(2, 3);

		assertNotNull(p);
		assertEquals(2, p.obtenerX());
		assertEquals(3, p.obtenerY());
	}

	@Test
	public void cambiarValorX() {
		Punto p = new Punto();

		p.cambiarX(2);
		assertEquals(2, p.obtenerX());
	}

	@Test
	public void cambiarValorY() {
		Punto p = new Punto();

		p.cambiarY(2);
		assertEquals(2, p.obtenerY());
	}

	@Test
	public void puntoEstaSobreElEjeX() {
		Punto p = new Punto(0, 2);

		assertTrue(p.estaSobreEjeX());
	}

	@Test
	public void puntoEstaSobreElEjeY() {
		Punto p = new Punto(2, 0);

		assertTrue(p.estaSobreEjeY());
	}

	@Test
	public void puntoEstaEnElEjeOrigen() {
		Punto p = new Punto();

		assertTrue(p.estaSobreEjeX());
		assertTrue(p.estaSobreEjeY());
		assertTrue(p.esElOrigen());
	}

	@Test
	public void distanciaDelPuntoAlOrigen() {
		Punto p = new Punto(4, 3);

		assertEquals(5, p.distanciaAlOrigen());
	}

	@Test
	public void distanciaDelPuntoAOtroPunto() {
		Punto p1 = new Punto(10, 5);
		Punto p2 = new Punto(6, 2);
		
		assertEquals(5, p1.distanciaAotroPunto(p2));
	}

}
