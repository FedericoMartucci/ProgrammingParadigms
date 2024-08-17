package ej02;

public class Ejercicio02 {
	/*
	 * Definir su propia excepción y utilizarla en un programa que posea una función
	 * que lance dicha excepción si se intenta calcular la raiz cuadrada de un
	 * número negativo. Esta excepción deberá extender de Exception en forma
	 * directa.
	 */

	public static double calcularRaiz(double n) {
		try {
			if (n < 0) {
				throw new InvalidArgumentException("No es posible calcular la raíz cuadrada de un número negativo");
			}
			return Math.sqrt(n);
		} catch (InvalidArgumentException e) {
			System.err.println(e.getMessage());
			return Double.NaN;
		}
	}
}
