package main;

import ejercicios.Ejercicio01;

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

		if(Ejercicio01.resolver(m3))
			System.out.println("Comprueba la regla");
		else
			System.out.println("No comprueba la regla");

	}

}
