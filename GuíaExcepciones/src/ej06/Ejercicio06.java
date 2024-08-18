package ej06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio06 {
	/*
	 * Escribir un programa que lea un archivo de texto que contiene el nombre de un
	 * archivo a su vez. El programa debe intentar abrir y leer el archivo
	 * mencionado en el primer archivo, y lanzar una excepción si no se puede abrir
	 * el archivo mencionado. Cerrar el primer archivo luego de cerrar el segundo.
	 * Esto generará que utilices dos bloques try anidados.
	 */
	public static void abrirArchivoDeArchivo(String path) {
		Scanner sc = null;
		Scanner sc2 = null;

		try {
			File arch = new File(path);
			sc = new Scanner(arch);
			
			try {
				File arch2 = new File(sc.next());
				sc2 = new Scanner(arch2);
				
				while (sc2.hasNextLine()) {
                    System.out.println(sc2.nextLine());
                }
				
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				System.err.println("No se pudo abrir el segundo archivo.");
			} finally {
				if(sc2 != null)
					sc2.close();
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.err.println("No se pudo abrir el primer archivo.");
		} finally {
			if(sc != null)
				sc.close();
		}
	}

}
