package ejercicios;

public class Ejercicio01 {
	/*
	 * Escribir un método en Java que permita comprobar si la diagonal principal de
	 * una matriz cuadrada de enteros tiene en cada posición un valor igual a la
	 * suma de todos los valores de las posiciones anteriores de dicha diagonal. Por
	 * ejemplo, la siguiente matriz comprueba la regla:
	 * 1 2 3
	 * 4 1 6
	 * 7 8 2
	 * Pero esta otra, no la comprueba:
	 * 1 2 3
	 * 4 2 6
	 * 7 8 2
	 */
	public static boolean resolver(int[][] m) {
		int numFilas = m.length;
	    int numColumnas = m[0].length;
	    int i;
	    int acum = m[0][0];
	    
		if(numFilas != numColumnas) {
			System.out.println("La matriz no es cuadrada.");
			return false;
		}
		
	    for(i = 1; i < numFilas; i++) {
	    	System.out.printf("%d - %d\n",acum, m[i][i]);
	    	if(m[i][i] != acum)
	    		return false;
	    	acum += m[i][i];
	    }
		
		return true;
	}
}
