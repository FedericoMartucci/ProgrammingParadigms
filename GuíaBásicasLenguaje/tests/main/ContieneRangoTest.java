package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class ContieneRangoTest {
	@Nested
	class ContieneNumero {
		@Test
		@DisplayName("0 esta dentro de [0, 1)")
		void testCeroDentroDeRangoSemiabierto() {
			Rango r = Rango.cerradoAbierto(0, 1);

			assertTrue(r.contiene(0));
		}

		@Test
		@DisplayName("0 no esta dentro de (0, 1)")
		void testCeroDentroDeRangoAbierto() {
			Rango r = Rango.abierto(0, 1);

			assertFalse(r.contiene(0));
		}

		@Test
		@DisplayName("1 esta dentro de (0, 1]")
		void testUnoDentroDeRangoSemiabierto() {
			Rango r = Rango.abiertoCerrado(0, 1);

			assertTrue(r.contiene(1));
		}

		@Test
		@DisplayName("1 no esta dentro de (0, 1)")
		void testUnoDentroDeRangoAbierto() {
			Rango r = Rango.abierto(0, 1);

			assertFalse(r.contiene(1));
		}

		@Test
		@DisplayName("2 no esta dentro de (0, 1)")
		void testNumeroFueraDeRangoAbierto() {
			Rango r = Rango.abierto(0, 1);

			assertFalse(r.contiene(2));
		}

		@Test
		@DisplayName("0.5 esta dentro de (0, 1)")
		void testDecimalDentroDeRango() {
			Rango r = Rango.abierto(0, 1);

			assertTrue(r.contiene(0.5));
		}
	}

	@Nested
	class ContieneRango {
		@Test
		@DisplayName("(0, 2) esta dentro de (0, 2)")
		void testRangoAbiertoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);
			Rango r2 = Rango.abierto(0, 2);

			assertTrue(r.contiene(r2));
		}

		@Test
		@DisplayName("(0, 2] no esta dentro de (0, 2)")
		void testRangoSemicerradoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);
			Rango r2 = Rango.abiertoCerrado(0, 2);

			assertFalse(r.contiene(r2));
		}

		@Test
		@DisplayName("(0, 1) no esta dentro de (0.5, 2)")
		void testRangoMenorAOtro() {
			Rango r = Rango.abierto(0.5, 2);
			Rango r2 = Rango.abierto(0, 1);

			assertFalse(r.contiene(r2));
		}

		@Test
		@DisplayName("(0.5, 2) no esta dentro de (0, 1)")
		void testRangoMayorAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(0.5, 2);

			assertFalse(r.contiene(r2));
		}

		@Test
		@DisplayName("(-5, -2) no esta dentro de (0, 1)")
		void testRangoDistintoAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(-5, -2);

			assertFalse(r.contiene(r2));
		}
	}

	@Nested
	class InterseccionRango {
		@Test
		@DisplayName("(0, 2) tiene interseccion con (0, 2)")
		void testRangoAbiertoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);
			Rango r2 = Rango.abierto(0, 2);

			assertTrue(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("(0, 2] tiene interseccion con (0, 2)")
		void testRangoSemicerradoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);
			Rango r2 = Rango.abiertoCerrado(0, 2);

			assertTrue(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("(0, 1) tiene interseccion con (0.5, 2)")
		void testRangoMenorAOtro() {
			Rango r = Rango.abierto(0.5, 2);
			Rango r2 = Rango.abierto(0, 1);

			assertTrue(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("(0.5, 2) tiene interseccion con (0, 1)")
		void testRangoMayorAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(0.5, 2);

			assertTrue(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("(-5, -2) no tiene interseccion con (0, 1)")
		void testRangoDistintoAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(-5, -2);

			assertFalse(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("(-5, 0] no tiene interseccion con [0, 1)")
		void testRangoInterseccionBordeDerecho() {
			Rango r = Rango.cerradoAbierto(0, 1);
			Rango r2 = Rango.abiertoCerrado(-5, 0);

			assertFalse(r.hayInterseccion(r2));
		}

		@Test
		@DisplayName("[0, 1) no tiene interseccion con (-5, 0]")
		void testRangoInterseccionBordeIzquierdo() {
			Rango r = Rango.abiertoCerrado(-5, 0);
			Rango r2 = Rango.cerradoAbierto(0, 1);

			assertFalse(r.hayInterseccion(r2));
		}
	}

	@Nested
	class IgualRango {
		@Test
		@DisplayName("(0, 1) es igual a (0, 1)")
		void testRangosAbiertosIguales() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(0, 1);

			assertTrue(r.equals(r2));
		}

		@Test
		@DisplayName("(0, 1) no es igual a [0, 1)")
		void testRangosSemiAbiertosNoIguales() {
			Rango r = Rango.cerradoAbierto(0, 1);
			Rango r2 = Rango.abierto(0, 1);

			assertFalse(r.equals(r2));
		}

		@Test
		@DisplayName("(0, 1) no es igual a (0, 1]")
		void testRangosSemiCerradosNoIguales() {
			Rango r = Rango.abiertoCerrado(0, 1);
			Rango r2 = Rango.abierto(0, 1);

			assertFalse(r.equals(r2));
		}

		@Test
		@DisplayName("[0, 1] es igual a [0, 1]")
		void testRangosCerradosIguales() {
			Rango r = Rango.cerrado(0, 1);
			Rango r2 = Rango.cerrado(0, 1);

			assertTrue(r.equals(r2));
		}

		@Test
		@DisplayName("(-3, 1) no es igual a (0, 1)")
		void testRangosDistintos() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(-3, 1);

			assertFalse(r.equals(r2));
		}
	}

	/*
	 * By default, test classes and methods will be ordered using an algorithm that
	 * is deterministic but intentionally nonobvious. This ensures that subsequent
	 * runs of a test suite execute test classes and test methods in the same order,
	 * thereby allowing for repeatable builds.
	 */
	@Nested
	@TestMethodOrder(OrderAnnotation.class)
	class RangoAbarcativo {
		@Test
		@Order(1)
		@DisplayName("(-15, 7) abarca a (-15, 1), [2, 5), (3, 7)")
		void testAbarcarRangosAbiertos() {
			Rango r = Rango.abierto(-15, 1);
			Rango r2 = Rango.cerradoAbierto(2, 5);
			Rango r3 = Rango.abierto(3, 7);

			Rango resultado = Rango.rangoMasAbarcativo();

			assertEquals("(-15.0, 7.0)", resultado.toString());
		}

		@Test
		@Order(2)
		@DisplayName("(-10, 8) no abarca a [-10, 1), [2, 5), (3, 8]")
		void testAbarcarRangosAbiertosYCerrados() {
			Rango r = Rango.cerradoAbierto(-10, 1);
			Rango r2 = Rango.cerradoAbierto(2, 5);
			Rango r3 = Rango.abiertoCerrado(3, 8);

			Rango resultado = Rango.rangoMasAbarcativo();

			assertNotEquals("(-10.0, 8.0)", resultado.toString());
		}

		@Test
		@Order(3)
		@DisplayName("[-15, 89] abarca a [-15, 1), [2, 5), (3, 89]")
		void testAbarcarRangosCerrados() {
			Rango r = Rango.cerradoAbierto(-15, 1);
			Rango r2 = Rango.cerradoAbierto(2, 5);
			Rango r3 = Rango.abiertoCerrado(3, 89);

			Rango resultado = Rango.rangoMasAbarcativo();

			assertEquals("[-15.0, 89.0]", resultado.toString());
		}
	}
}
