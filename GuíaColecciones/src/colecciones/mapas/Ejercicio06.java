package colecciones.mapas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		for (Map.Entry<String, Double[]> entry : notas.entrySet()) {
			String alumno = entry.getKey();
			Double[] notasPorAlumno = entry.getValue();
			StringBuilder sb = new StringBuilder(alumno + " - [ ");
			for (Double nota : notasPorAlumno) {
				sb.append(nota).append(" ");
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}

	public void obtenerPromedioNotas() {
		for (Map.Entry<String, Double[]> entry : notas.entrySet()) {
			String alumno = entry.getKey();
			double promedio = calcularPromedio(entry.getValue());
			System.out.printf("%s - %.2f%n", alumno, promedio);
		}
	}

	public void obtenerPromedioNotas(String nombre) {
		Double[] notasPorAlumno = notas.get(nombre);
		if (notasPorAlumno == null) {
			System.out.println("El estudiante ingresado no existe");
		} else {
			double promedio = calcularPromedio(notasPorAlumno);
			System.out.printf("%s - %.2f%n", nombre, promedio);
		}
	}

	public void obtenerAlumnosPorPromedio() {
		HashMap<Double, List<String>> promedioEstudiantes = new HashMap<>();

		for (Map.Entry<String, Double[]> entry : notas.entrySet()) {
			String alumno = entry.getKey();
			Double[] notasAlumno = entry.getValue();
			double promedio = calcularPromedio(notasAlumno);

			promedioEstudiantes.computeIfAbsent(promedio, k -> new ArrayList<>()).add(alumno);
		}

		promedioEstudiantes.entrySet().stream().sorted(Map.Entry.<Double, List<String>>comparingByKey())
				.forEach(entry -> {
					System.out.print("Promedio " + entry.getKey() + ": ");
					System.out.println(entry.getValue());
				});
	}

	private double calcularPromedio(Double[] notas) {
		double total = 0;
		for (Double nota : notas) {
			total += nota;
		}
		return total / notas.length;
	}

	public static void main(String[] args) {
		Ejercicio06 gestionNotas = new Ejercicio06();

		gestionNotas.agregarNota("Juan", 8.5);
		gestionNotas.agregarNota("Juan", 9.0);
		gestionNotas.agregarNota("Maria", 7.5);
		gestionNotas.agregarNota("Maria", 8.0);
		gestionNotas.agregarNota("Pedro", 9.0);
		gestionNotas.agregarNota("Pedro", 8.5);

		System.out.println("Notas:");
		gestionNotas.mostrarNotas();

		System.out.println("\nPromedios:");
		gestionNotas.obtenerPromedioNotas();

		System.out.println("\nPromedios por estudiante:");
		gestionNotas.obtenerPromedioNotas("Juan");

		System.out.println("\nAlumnos por promedio:");
		gestionNotas.obtenerAlumnosPorPromedio();
	}
}
