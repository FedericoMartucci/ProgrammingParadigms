package ejercicios;

public class Ejercicio02 {
	/*
	 * Escribir un método en Java que permita comprobar si la multiplicación de
	 * todos los valores de una matriz numérica, dará 0 o no.
	 */
	public static boolean resolver(int[][] m) {
		int i;
		int j;
		
		for(i = 0; i < m.length; i++)
			for(j = 0; j < m[0].length; j++)
				if(m[i][j] == 0)
					return true;

		return false;
	}
}
