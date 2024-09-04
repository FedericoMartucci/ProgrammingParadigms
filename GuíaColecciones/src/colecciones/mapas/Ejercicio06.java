package colecciones.mapas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ejercicio06 {
	/*
	 * Un programa necesita llevar un registro de los estudiantes y sus respectivas
	 * notas en un curso. Escriba un programa que utilice un HashMap para almacenar
	 * el nombre del estudiante como clave y un arreglo de notas como valor. El
	 * programa debe permitir agregar nuevas notas y mostrar el promedio de notas de
	 * un estudiante específico.
	 * 
	 * Ahora diseñe una función que permita invertir el mapa: queremos el listado de
	 * estudiantes por promedio. Ante un mismo promedio, debe devolver todos los
	 * estudiantes que lo hayan obtenido.
	 */

	private HashMap<String, Double[]> notas;

	public Ejercicio06() {
		this.notas = new HashMap<String, Double[]>();
	}

	public void agregarNota(String nombreAlumno, double nota) {
		Double[] notasAlumno = notas.get(nombreAlumno);

		if (notasAlumno == null)
			notasAlumno = new Double[] { nota };
		else {
			notasAlumno = Arrays.copyOf(notasAlumno, notasAlumno.length + 1);
			notasAlumno[notasAlumno.length - 1] = nota;
		}
		notas.put(nombreAlumno, notasAlumno);
	}

	public void mostrarNotas() {
		Iterator<String> alumnos = notas.keySet().iterator();

		while (alumnos.hasNext()) {
			String alumno = alumnos.next();
			System.out.print(alumno + " - [ ");

			Double[] notasPorAlumno = notas.get(alumno);

			for (Double nota : notasPorAlumno)
				System.out.print(nota + " ");
			System.out.println("]");

		}
	}

	public void obtenerAlumnosPorPromedio() {
		HashSet<Double[]> setNotasPorAlumno = new HashSet<Double[]>(notas.values());
		Iterator<Double[]> promedios = setNotasPorAlumno.iterator();

		while (promedios.hasNext()) {
			Double[] notasPorAlumno = promedios.next();
			double total = 0;

			for (Double nota : notasPorAlumno)
				total += nota;
			total /= notasPorAlumno.length;
			
		}
	}

	public void obtenerPromedioNotas() {
		Iterator<String> alumnos = notas.keySet().iterator();

		while (alumnos.hasNext()) {
			String alumno = alumnos.next();
			System.out.print(alumno + " - ");

			Double[] notasPorAlumno = notas.get(alumno);
			double total = 0;

			for (Double nota : notasPorAlumno)
				total += nota;
			System.out.printf("%.2f\n", total / notasPorAlumno.length);

		}
	}

	public void obtenerPromedioNotas(String nombre) {
		if (notas.get(nombre) == null)
			System.out.println("El estudiante ingresado no existe");
		else {
			System.out.print(nombre + " - ");

			Double[] notasPorAlumno = notas.get(nombre);
			double total = 0;

			for (Double nota : notasPorAlumno)
				total += nota;
			System.out.printf("%.2f\n", total / notasPorAlumno.length);
		}
	}
}
