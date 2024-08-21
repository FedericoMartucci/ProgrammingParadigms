
package colecciones.listas;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio02 {
	/*
	 * Una tienda de ropa necesita llevar un registro de las ventas que realiza cada
	 * día. Cada venta tiene un número de venta, fecha, hora, nombre del cliente y
	 * monto de la venta. Escriba un programa que permita:
	 * 
	 * Agregar una nueva venta al registro. Buscar una venta por número de venta.
	 * Mostrar la lista de ventas realizadas en un día determinado.
	 */

	private List<Venta> ventas;

	public Ejercicio02() {
		this.ventas = new ArrayList<Venta>();
	}

	public void agregarVenta(Venta nuevaVenta) {
		this.ventas.add(nuevaVenta);
	}

	public Venta buscarVenta(int numeroVenta) {
		if (numeroVenta < this.ventas.size())
			return this.ventas.get(numeroVenta - 1);
		return null;
	}

	public void mostrarVentasPorDia(DayOfWeek dia) {
		for (int i = 0; i < this.ventas.size(); i++)
			if (this.ventas.get(i).getFechaYHora().getDayOfWeek() == dia)
				System.out.println(ventas.get(i));
	}
}
