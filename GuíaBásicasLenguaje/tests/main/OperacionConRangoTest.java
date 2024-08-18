package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OperacionConRangoTest {
	@Nested
	class SumarRango {
		@Test
		@DisplayName("(0, 1) + (1, 8) es igual a (0, 8)")
		void testSumarDosRangosEnterosAbiertos() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(1, 8);

			r.sumar(r2);
			assertEquals("(0.0, 8.0)", r.sumar(r2).toString());
		}

		@Test
		@DisplayName("[0, 1) + (-2, 40] es igual a [0, 40]")
		void testSumarDosRangosEnterosSemiabiertos() {
			Rango r = Rango.cerradoAbierto(0, 1);
			Rango r2 = Rango.abiertoCerrado(-2, 40);

			assertEquals("[0.0, 40.0]", r.sumar(r2).toString());
		}

		@Test
		@DisplayName("[0, 1) + (0, 0) es igual a [0, 0)")
		void testSumarRangoNulo() {
			Rango r = Rango.cerradoAbierto(0, 1);
			Rango r2 = Rango.abierto(0, 0);

			assertEquals("[0.0, 0.0)", r.sumar(r2).toString());
		}

		@Test
		@DisplayName("(0, 0) + [0, 0] es igual a (0, 0]")
		void testSumarDosRangosIgualesDistintaApertura() {
			Rango r = Rango.abierto(0, 0);
			Rango r2 = Rango.cerrado(0, 0);

			assertEquals("(0.0, 0.0]", r.sumar(r2).toString());
		}
	}

	@Nested
	class DesplazarRango {
		@Test
		@DisplayName("Si desplazo 2 unidades (0, 1) me da (2, 3)")
		void testDesplazarDosUnidades() {
			Rango r = Rango.abierto(0, 1);

			assertEquals("(2.0, 3.0)", r.desplazar(2).toString());
		}

		@Test
		@DisplayName("Si desplazo 0 unidades (0, 1) me da (2, 3)")
		void testDesplazarCeroUnidades() {
			Rango r = Rango.abierto(0, 1);

			assertEquals("(0.0, 1.0)", r.desplazar(0).toString());
		}

		@Test
		@DisplayName("Si desplazo 2.8 unidades (0, 1) me da (2.8, 3.8)")
		void testDesplazarUnidadesDecimales() {
			Rango r = Rango.abierto(0, 1);

			assertEquals("(2.8, 3.8)", r.desplazar(2.8).toString());
		}
	}

	@Nested
	class CompararRango {
		@Test
		@DisplayName("[0, 0) es menor a (0, 0)")
		void testRangoNuloSemiAbiertoMenorRangoNuloAbierto() {
			Rango r = Rango.abiertoCerrado(0, 0);
			Rango r2 = Rango.abierto(0, 0);

			assertEquals(-1, r.compareTo(r2));
		}

		@Test
		@DisplayName("(0, 0) es igual a (0, 0)")
		void testRangosAbiertosIguales() {
			Rango r = Rango.abierto(0, 0);

			assertEquals(0, r.compareTo(r));
		}

		@Test
		@DisplayName("[0, 0] es igual a [0, 0]")
		void testRangosCerradosIguales() {
			Rango r = Rango.cerrado(0, 0);

			assertEquals(0, r.compareTo(r));
		}

		@Test
		@DisplayName("[0, 5] es mayor a (-2, 0)")
		void testRangosDistintos() {
			Rango r = Rango.cerrado(0, 5);
			Rango r2 = Rango.abierto(-2, 0);

			assertEquals(1, r.compareTo(r2));
		}

	}

	@Nested
	class InterseccionRango {
		@Test
		@DisplayName("(0, 2) tiene interseccion con (0, 2) siendo (0, 2)")
		void testRangoAbiertoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);

			assertEquals("(0.0, 2.0)", r.calcularInterseccion(r).toString());
		}

		@Test
		@DisplayName("(0, 2] tiene interseccion con (0, 2) siendo (0, 2)")
		void testRangoSemicerradoEnSiMismo() {
			Rango r = Rango.abierto(0, 2);
			Rango r2 = Rango.abiertoCerrado(0, 2);

			assertEquals("(0.0, 2.0)", r.calcularInterseccion(r2).toString());
		}

		@Test
		@DisplayName("(0, 1) tiene interseccion con (0.5, 2) siendo (0.5, 1)")
		void testRangoMenorAOtro() {
			Rango r = Rango.abierto(0.5, 2);
			Rango r2 = Rango.abierto(0, 1);

			assertEquals("(0.5, 1.0)", r.calcularInterseccion(r2).toString());
		}

		@Test
		@DisplayName("(0.5, 2) tiene interseccion con (0, 1) siendo (0.5, 1)")
		void testRangoMayorAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(0.5, 2);

			assertEquals("(0.5, 1.0)", r.calcularInterseccion(r2).toString());
		}

		@Test
		@DisplayName("(-5, -2) no tiene interseccion con (0, 1) devolviendo (0, 0)")
		void testRangoDistintoAOtro() {
			Rango r = Rango.abierto(0, 1);
			Rango r2 = Rango.abierto(-5, -2);

			assertEquals("(0.0, 0.0)", r.calcularInterseccion(r2).toString());
		}

		@Test
		@DisplayName("(-5, 0] no tiene interseccion con [0, 1) devolviendo (0, 0)")
		void testRangoInterseccionBordeDerecho() {
			Rango r = Rango.cerradoAbierto(0, 1);
			Rango r2 = Rango.abiertoCerrado(-5, 0);

			assertEquals("(0.0, 0.0)", r.calcularInterseccion(r2).toString());
		}

		@Test
		@DisplayName("[0, 1) no tiene interseccion con (-5, 0] devolviendo (0, 0)")
		void testRangoInterseccionBordeIzquierdo() {
			Rango r = Rango.abiertoCerrado(-5, 0);
			Rango r2 = Rango.cerradoAbierto(0, 1);

			assertEquals("(0.0, 0.0)", r.calcularInterseccion(r2).toString());
		}
	}
}
