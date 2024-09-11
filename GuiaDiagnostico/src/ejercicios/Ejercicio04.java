package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio04 {
	/*
	 * Escribir un método en Java que de una matriz numérica dada, devuelva un
	 * vector con n elementos, donde cada elemento es la moda de una fila. Si
	 * hubiese más de una moda, se deberá utilizar la de mayor valor
	 * Ejemplo: Para la matriz
	 * 1 2 3 4
	 * 5 -6 -6 20
	 * 1 1 10 10
	 * La salida debe ser
	 * 4 -6 10
	 */
	public static int[] resolver(int[][] m) {
		int resultado[] = new int[m.length];
		Map<Integer, Integer> ocurrencias = new HashMap<>();

		for(int i = 0; i < m.length; i++) {
			
			for(int j = 0; j < m[0].length; j++)
				ocurrencias.put(m[i][j], ocurrencias.getOrDefault(m[i][j],  0) + 1);

			resultado[i] = obtenerModa(ocurrencias);
			ocurrencias.clear();
		}
		return resultado;
	}
	
	private static int obtenerModa(Map<Integer, Integer> ocurrencias) {
		Integer moda = null;
		Integer maxOcurrencias = 0;

		for (Map.Entry<Integer, Integer> entry : ocurrencias.entrySet()) {
			if(maxOcurrencias <= entry.getValue() )
			{
				maxOcurrencias = entry.getValue();
				moda = entry.getKey();
			}
	    }
		
		return moda;
	}
}
