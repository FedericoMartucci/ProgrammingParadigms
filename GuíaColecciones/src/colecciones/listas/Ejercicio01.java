package colecciones.listas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio01 {
	/*
	 * Una empresa de mensajería necesita llevar un registro de los paquetes que
	 * transporta. Cada paquete tiene un número de seguimiento, dirección de origen,
	 * dirección de destino y peso. Escriba un programa que permita:
	 * 
	 * Agregar un nuevo paquete al registro. Buscar un paquete por número de
	 * seguimiento. Mostrar la lista de paquetes que superan un peso determinado.
	 */

	private List<Paquete> paquetes;

	public Ejercicio01() {
		this.paquetes = new LinkedList<Paquete>();
	}

	public void agregarPaquete(Paquete nuevoPaquete) {
		this.paquetes.add(nuevoPaquete);
	}

	public Paquete buscarPaquete(int numeroSeguimiento) {
		for (Paquete paquete : this.paquetes) {
			if (paquete.getNumeroSeguimiento() == numeroSeguimiento)
				return paquete;
		}
		return null;
	}

	public void mostrarPaquetesPesoDeterminado(double peso) {
		Iterator<Paquete> paquetes = this.paquetes.iterator();

		while (paquetes.hasNext()) {
			Paquete paq = paquetes.next();
			if (paq.getPeso() > peso)
				System.out.println(paq);
		}

		// Con foreach:
// 		for(Paquete paquete : this.paquetes) {
//			if(paquete.getPeso() > peso)
//				System.out.println(paquete);
//		}
	}
}
