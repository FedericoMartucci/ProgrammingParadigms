package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ejercicio01 {
	private static final String nombreArchivo = "caso01";
	
	public static void resolver() {
		Archivo arch = new Archivo(Ejercicio01.nombreArchivo);
		int[] lote = {7, 1, 3, 2, 1, 3, 8, 2};
		Ejercicio01.crearLote(lote, Ejercicio01.nombreArchivo);
		
		int[] datos = arch.leerArchivoEj01();
		
		System.out.println("caso01.in:");
		Ejercicio01.imprimirArrayEnteros(datos);
		
		int[] datosProcesados = Ejercicio01.procesarDatos(datos);
		
		System.out.println("caso01.out:");
		Ejercicio01.imprimirArrayEnteros(datosProcesados);
		
		arch.guardarArchivoEj01(datosProcesados);
	}
	
	private static void crearLote(int[] lote, String nombreArch) {
		Archivo arch = new Archivo(nombreArch);
		arch.guardarArchivoEj01(lote);
	}
	
	private static int[] procesarDatos(int[] datos) {
		int contador = 0;
		int[] datosProcesados = null;
		Set<Integer> setEnteros = new HashSet<Integer>();
		

		for(int i = 0; i < datos.length; i ++) {
			setEnteros.add(datos[i]);
		}
		
		Iterator<Integer> it = setEnteros.iterator();
		datosProcesados = new int[setEnteros.size() + 1];

		datosProcesados[contador] = setEnteros.size();
		
		while(it.hasNext()) {
			contador ++;
			datosProcesados[contador] = it.next();
		};
		
		return datosProcesados;
	}
	
	private static void imprimirArrayEnteros(int datos[]) {
		for(int dato: datos)
			System.out.println(dato);
	}
}
