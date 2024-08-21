package colecciones.conjuntos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio04 {
	/*
	 * Una tienda de libros necesita llevar un registro de los títulos únicos de los
	 * libros que tiene en stock. Diseñe un programa que utilice un Set para
	 * almacenar los libros sin ejemplares repetidos.
	 * 
	 * Tip: Para esto necesitará definir el criterio de igualdad correctamente.
	 * Defina los atributos en consecuencia.
	 */
	private Set<Libro> libros;

	public Ejercicio04() {
		this.libros = new TreeSet<Libro>();
	}

	public void agregarLibro(Libro libro) {
		libros.add(libro);
	}

	public void mostrarTitulos() {
		for (Libro libro : this.libros) {
			System.out.println(libro);
		}
	}
}
