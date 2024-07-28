package ejercicios;

public class Ejercicio03 {
	/*
	 * Escribir un método en Java que de una matriz numérica dada, devuelva una
	 * matriz con la misma cantidad de elementos, pero donde cada valor es la suma
	 * de sus adyacentes originales (arriba, abajo, izquierda, y derecha; si
	 * existen)
	 * Ejemplo: Para la matriz
	 * 8 2 -3 4
	 * 5 -6 -6 20
	 * 21 1 -5 0
	 * La salida debe ser
	 * 15 1 -3 21
	 * 28 -4 0 18
	 * 27 11 -10 15
	 */
	public static int[][] resolver(int[][] m) {
		int numFilas = m.length;
	    int numColumnas = m[0].length;
	    int i;
	    int j;
	    int [][]resultado = new int[numFilas][numColumnas];
	    
	    
		for(i = 0; i < m.length; i++)
			for(j = 0; j < m[0].length; j++)
				;
		return resultado;
	}
}
