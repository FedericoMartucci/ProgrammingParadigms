package ej01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ejercicio01Test {


	@Test
	@DisplayName("Divido por un mismo numero")
	void testDividirPorMismoNumero() {
		assertEquals(1, Ejercicio01.dividir(6, 6));
	}
	
	@Test
	@DisplayName("Divido 0 por un numero entre 1 y 10")
	void testDividirCeroPorEntero() {
		assertEquals(0, Ejercicio01.dividir(0, (int) Math.random() * (10 - 1) + 1));
	}
	
	@Test
	@DisplayName("Divido numero entero por 0")
	void testDividirEnteroPorCero() {
		assertThrows(ArithmeticException.class, () -> {
			Ejercicio01.dividir(5, 0);
	    });
	}
	
	@Test
	@DisplayName("Divido 0 por 0")
	void testDividirCeroPorCero() {
		assertThrows(ArithmeticException.class, () -> {
			Ejercicio01.dividir(0, 0);
	    });
	}
	
	
	@Test
	@DisplayName("Divido numero entero positivo por numero entero negativo")
	void testDividirPositivoPorNegativo() {
		assertEquals(-5, Ejercicio01.dividir(25, -5));
	}
	
	@Test
	@DisplayName("Divido numero entero negativo por numero entero negativo")
	void testDividirNegativoPorNegativo() {
		assertEquals(5, Ejercicio01.dividir(-25, -5));
	}

}
