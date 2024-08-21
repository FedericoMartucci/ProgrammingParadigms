package colecciones.mapas;

import java.time.Month;
import java.util.Iterator;
import java.util.TreeMap;

import colecciones.listas.Venta;

public class Ejercicio05 {
	/*
	 * Una empresa necesita llevar un registro de las ventas que ha realizado cada
	 * mes. Diseñe un programa que utilice un HashMap para almacenar el mes como
	 * clave y el monto de ventas como valor. El programa debe permitir agregar
	 * nuevas ventas y mostrar el monto de ventas de un mes específico.
	 */
	private TreeMap<Month, Integer> ventas;

	public Ejercicio05() {
		this.ventas = new TreeMap<Month, Integer>();
	}

	public void agregarVenta(Venta venta) {
		ventas.put(venta.getFechaYHora().getMonth(), ventas.getOrDefault(venta.getFechaYHora().getMonth(), 0) + 1);
	}

	public void mostrarVentas() {
		Iterator<Month> meses = ventas.keySet().iterator();

		while (meses.hasNext()) {
			Month mes = meses.next();
			System.out.println("Mes: " + mes + " Cant. Vendida: " + ventas.get(mes));
		}
	}

}
