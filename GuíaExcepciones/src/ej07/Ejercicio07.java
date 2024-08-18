package ej07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio07 {
	/*
	 * Repetir el ejercicio anterior, pero utilizando bloques try with resources
	 * [https://www.baeldung.com/java-try-with-resources]. Comparar el código
	 * resultante.
	 */

	public static void abrirArchivoDeArchivo(String path) {
		try (Scanner sc = new Scanner(new File(path))) {
			try (Scanner sc2 = new Scanner(new File(sc.next()))) {
				while (sc2.hasNextLine()) {
					System.out.println(sc2.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
				System.err.println("No se pudo abrir el segundo archivo.");
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.err.println("No se pudo abrir el primer archivo.");
		}
	}
}
