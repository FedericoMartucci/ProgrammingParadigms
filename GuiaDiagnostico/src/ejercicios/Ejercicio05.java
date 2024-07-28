package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio05 {
	/*
	 * Escribir un método en Java que de una matriz cuadrada dada de dimensión nxn,
	 * devuelva una matriz con 2n-1 filas, donde cada una tendrá los datos de una de
	 * las diagonales (de abajo a la izquierda hacia arriba a la derecha)
	 * Ejemplo: Para la matriz
	 * 1 2 3 4
	 * 5 6 7 8
	 * 9 10 11 12
	 * 13 14 15 16
	 * La salida debe ser
	 * 13
	 * 9 14
	 * 5 10 15
	 * 1 6 11 16
	 * 2 7 12
	 * 3 8
	 * 4
	 */
	
	//-------------- Mi solucion ---------------
//	public static int[][] resolver(int[][] m) {
//	    int resultado[][] = new int[2 * m.length - 1][m.length];
//	    
//		if(m.length != m[0].length) {
//			System.out.println("La matriz no es cuadrada.");
//			return null;
//		}
//		
//		for(int i = m.length - 1; i >= 0; i--)		
//			for(int j = 0; j < m.length - i ; j++)
//				resultado[m.length - i - 1][j] = m[i + j][j];
//
//		for(int i = 1; i < m.length; i ++)	
//			for(int j = 0; j < m.length - i ; j++)
//				resultado[m.length + i - 1][j] = m[j][i + j];
//		
//		
//		return resultado;
//	}
	
	//-------------- Solucion ChatGPT ---------------
    public static int[][] resolver(int[][] m) {
        if (m.length != m[0].length) {
            System.out.println("La matriz no es cuadrada.");
            return null;
        }

        List<List<Integer>> resultadoList = new ArrayList<>();
        
        for (int i = m.length - 1; i >= 0; i--) {
            List<Integer> diagonal = new ArrayList<>();
            for (int j = 0; j < m.length - i; j++) {
                diagonal.add(m[i + j][j]);
            }
            resultadoList.add(diagonal);
        }

        for (int i = 1; i < m.length; i++) {
            List<Integer> diagonal = new ArrayList<>();
            for (int j = 0; j < m.length - i; j++) {
                diagonal.add(m[j][i + j]);
            }
            resultadoList.add(diagonal);
        }

        // Convertir la lista de listas a un array bidimensional
        int[][] resultado = new int[resultadoList.size()][];
        for (int i = 0; i < resultadoList.size(); i++) {
            List<Integer> diagonal = resultadoList.get(i);
            resultado[i] = diagonal.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return resultado;
    }
}
