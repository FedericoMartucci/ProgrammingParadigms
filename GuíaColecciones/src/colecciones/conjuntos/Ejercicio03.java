package colecciones.conjuntos;

import java.util.Arrays;
import java.util.TreeSet;

public class Ejercicio03 {
	/*
	 * Una aplicación necesita llevar un registro de las palabras únicas que
	 * aparecen en un texto. Diseñe un programa que reciba el texto y utilice un Set
	 * para almacenar las palabras únicas que aparecen en él. Devuelva el listado de
	 * palabras únicas.
	 */
	public String[] listadoPalabrasUnicasPorTexto(String texto) {
		return new TreeSet<String>(Arrays.asList(texto.split("\\W+"))).toArray(new String[0]);

		/*
		 * \\W+ es una expresión regular que divide el texto en palabras ignorando
		 * cualquier cosa que no sea una letra, número o guion bajo (es decir, divide
		 * por cualquier carácter no alfanumérico). Esto es útil para asegurarse de que
		 * obtienes palabras completas y no fragmentos innecesarios. Si solo deseas
		 * dividir por espacios en blanco, podrías usar split("\\s+").
		 */

//		Set<String> listadoPalabras = new HashSet<String>(Arrays.asList(texto.split("\\W+")));
//		String[] palabrasUnicas = listadoPalabras.toArray(new String[0]);
//		return palabrasUnicas;
	}
}
