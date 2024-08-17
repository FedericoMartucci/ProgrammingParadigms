package ej01;

public class Ejercicio01 {
	/*
	 * Escribir una función que calcule la división de dos números enteros, pero que
	 * lance una excepción del tipo ArithmeticException si el segundo número es
	 * cero.
	 */

	public static double dividir(int n1, int n2) {
		try {
			return n1 / n2;
		} catch (ArithmeticException e) {
			System.err.println("No se puede dividir por 0");
			throw e;
		}
//		assert n2 != 0 : "El divisor no puede ser 0";
//		return n1 / n2;
	}
}
