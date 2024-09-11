package ejercicios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ejercicio01Test {

	@Test
    @DisplayName("Debería retornar true cuando se pasa una matriz nula")
	void resolverConMatrizNula() {
		int mat[][] = {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
		};
		
		assertTrue(Ejercicio01.resolver(mat));
	}
	
	@Test
    @DisplayName("Debería retornar false cuando se pasa una matriz identidad")
	void resolverConMatrizIdentidad() {
		int mat[][] = {
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1},
		};
		
		assertFalse(Ejercicio01.resolver(mat));
	}

}
