package main;

import ejercicios.Ejercicio01;
import ejercicios.Ejercicio02;
import ejercicios.Ejercicio03;
import ejercicios.Ejercicio04;
import ejercicios.Ejercicio05;

public class Main {

	public static void main(String[] args) {
		int[][]m = {
				{6, 2, 3, 4, 5},
				{1, 6, 3, 4, 5},
				{1, 2, 12, 4, 5},
				{1, 2, 3, 24, 5},
				{1, 2, 3, 4, 48}
		};
		int[][]m2 = {
				{1, 2, 3},
				{4, 1, 6},
				{7, 8, 2},
		};
		int[][]m3 = {
				{1, 2, 3},
				{4, 2, 6},
				{7, 8, 2},
		};
		int[][]m4 = {
				{1, 2, 3, 4},
				{5, -6, -6, 20},
				{1, 1, 10, 10},
		};

		int[][]m5 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		if(Ejercicio01.resolver(m3))
			System.out.println("Comprueba la regla");
		else
			System.out.println("No comprueba la regla");
		
		if(Ejercicio02.resolver(m))
			System.out.println("Da 0");
		else
			System.out.println("No da 0");
		Ejercicio03.resolver(m);
		int resultado[] = Ejercicio04.resolver(m4);
		
		System.out.println("Matriz:");
		for(int i = 0; i < m4.length; i ++) {			
			for(int j = 0; j < m4[0].length; j ++)
				System.out.print(m4[i][j] + " ");
			System.out.println();
		}
		System.out.println("Vector resultado:");	
		for(int i = 0; i < resultado.length; i ++)
			System.out.print(resultado[i] + " ");
		
		System.out.println();
		System.out.println();
		int resultado05[][] = Ejercicio05.resolver(m5);
		for(int i = 0; i < resultado05.length; i ++) {
			for(int j = 0; j < resultado05[i].length; j ++)
				System.out.print(resultado05[i][j] + " ");
			System.out.println();
		}
	}

}
