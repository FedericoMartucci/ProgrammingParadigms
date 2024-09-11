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
	    int [][]resultado = new int[m.length][m[0].length];
	    int adyacente = 1;
	    
		for(int i = 0; i < m.length; i ++)
			for(int j = 0; j < m[0].length; j ++) {
				resultado[i][j] = 0;
				int limiteInferior = i - adyacente < 0? 0 : i - adyacente;
				int limiteSuperior = i + adyacente > m.length - adyacente? m.length - 1 : (i + adyacente);
				for(int k = limiteInferior ; k <= limiteSuperior; k ++) {
					int limiteInf;
					int limiteSup;
					
					if(k == i) {
						limiteInf = j - adyacente < 0? 0 : j - adyacente;
						limiteSup = j + adyacente > m[0].length - 1? m[0].length - 1 : j + adyacente;
					} else
						limiteInf = limiteSup = j;

					for(int l = limiteInf ; l <= limiteSup; l ++)
						resultado[i][j] += m[k][l];
				}
			}
		return resultado;
	}
}
