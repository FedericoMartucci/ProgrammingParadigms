package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CaracteristicasRangoTest {
	@Nested
	class CrearRango {

		@Test
		@DisplayName("Crear rango abierto-abierto")
		void testCrearRangoAbiertoAbierto() {
			Rango r = Rango.abierto(1, 2);

			assertNotNull(r);
			assertEquals("(1.0, 2.0)", r.toString());
		}

		@Test
		@DisplayName("Crear rango abierto-cerrado")
		void testCrearRangoAbiertoCerrado() {
			Rango r = Rango.abiertoCerrado(1, 2);

			assertNotNull(r);
			assertEquals("(1.0, 2.0]", r.toString());
		}

		@Test
		@DisplayName("Crear rango cerrado-abierto")
		void testCrearRangoCerradoAbierto() {
			Rango r = Rango.cerradoAbierto(1, 2);

			assertNotNull(r);
			assertEquals("[1.0, 2.0)", r.toString());
		}

		@Test
		@DisplayName("Crear rango cerrado-cerrado")
		void testCrearRangoCerradoCerrado() {
			Rango r = Rango.cerrado(1, 2);

			assertNotNull(r);
			assertEquals("[1.0, 2.0]", r.toString());
		}
	}

	@Nested
	class ImprimirRango {
		@Test
		@DisplayName("Imprimir rango abierto-abierto")
		void testCrearRangoAbiertoAbierto() {
			Rango r = Rango.abierto(1, 2);

			assertEquals("(1.0, 2.0)", r.toString());
		}

		@Test
		@DisplayName("Imprimir rango abierto-cerrado")
		void testCrearRangoAbiertoCerrado() {
			Rango r = Rango.abiertoCerrado(1, 2);

			assertEquals("(1.0, 2.0]", r.toString());
		}

		@Test
		@DisplayName("Imprimir rango cerrado-abierto")
		void testCrearRangoCerradoAbierto() {
			Rango r = Rango.cerradoAbierto(1, 2);

			assertEquals("[1.0, 2.0)", r.toString());
		}

		@Test
		@DisplayName("Imprimir rango cerrado-cerrado")
		void testCrearRangoCerradoCerrado() {
			Rango r = Rango.cerrado(1, 2);

			assertEquals("[1.0, 2.0]", r.toString());
		}
	}

}
