package ej03;

public class Ejercicio03 {
	/*
	 * Escribir un programa que calcule el cociente de dos números enteros, pero que
	 * lance una excepción propia de tiempo de ejecución si el segundo número es
	 * cero. Tip: Deberá extender de RuntimeException. ¿Necesita ser anunciada?
	 * (throws)
	 */

	public static double dividir(int n1, int n2) throws DivisionPorCeroException {
		if (n2 == 0)
			throw new DivisionPorCeroException("No se puede dividir por 0");
		return n1 / n2;
	}
}
