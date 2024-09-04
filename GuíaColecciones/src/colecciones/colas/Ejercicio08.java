package colecciones.colas;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Ejercicio08 {
	/*
	 * Diseñe una función que permita invertir los elementos de una cola sin
	 * utilizar ninguna estructura auxiliar para ello. Es decir, luego de la
	 * ejecución de esta función, una cola con los elementos {1, 2, 3} deberá tener
	 * los elementos {3, 2, 1}.
	 */

	Queue<Tarea> colaTareas;

	public Ejercicio08() {
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

	public void invertirTareas() {
		if (colaTareas.isEmpty())
			return;

		Tarea t = colaTareas.poll();
		invertirTareas();
		colaTareas.add(t);

	}
}
