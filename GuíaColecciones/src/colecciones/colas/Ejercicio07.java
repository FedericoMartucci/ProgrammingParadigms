package colecciones.colas;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Ejercicio07 {
	/*
	 * Una aplicación necesita procesar una lista de tareas en orden de llegada.
	 * Diseñe un programa que utilice una cola para almacenar las tareas a medida
	 * que se reciben. El programa debe procesar las tareas en el orden en que se
	 * recibieron.
	 */

	Queue<Tarea> colaTareas;

	public Ejercicio07() {
		this.colaTareas = new ArrayDeque<Tarea>();
	}

	public void agregarTarea(Tarea t) {
		colaTareas.add(t);
	}

	public void mostrarTareasRecibidas() {
		Iterator<Tarea> it = colaTareas.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
