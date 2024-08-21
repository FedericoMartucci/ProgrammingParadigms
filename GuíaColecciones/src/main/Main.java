package main;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import colecciones.conjuntos.Ejercicio03;
import colecciones.conjuntos.Ejercicio04;
import colecciones.conjuntos.Libro;
import colecciones.listas.Ejercicio01;
import colecciones.listas.Ejercicio02;
import colecciones.listas.Paquete;
import colecciones.listas.Venta;

public class Main {

	public static void main(String[] args) {
		Ejercicio01 ej1 = new Ejercicio01();
		Paquete p1 = new Paquete(101, "calle1", "calle2", 95.3);
		Paquete p2 = new Paquete(67, "calle1", "calle2", 5.3);
		Paquete p3 = new Paquete(23423, "calle1", "calle2", 45.3);
		Paquete p4 = new Paquete(234, "calle1", "calle2", 75.3);

		ej1.agregarPaquete(p1);
		ej1.agregarPaquete(p2);
		ej1.agregarPaquete(p3);
		ej1.agregarPaquete(p4);

		System.out.println(ej1.buscarPaquete(68));
		System.out.println("------------");
		ej1.mostrarPaquetesPesoDeterminado(45);

		System.out.println("------------");

		Ejercicio02 registro = new Ejercicio02();

		// Agregar ventas
		registro.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		registro.agregarVenta(new Venta(LocalDateTime.now(), "Cliente B", 200.50));

		// Buscar una venta
		Venta venta = registro.buscarVenta(1);
		if (venta != null) {
			System.out.println("Venta encontrada: " + venta);
		} else {
			System.out.println("Venta no encontrada");
		}

		// Mostrar ventas por día
		registro.mostrarVentasPorDia(DayOfWeek.TUESDAY);

		System.out.println("------------");
		Ejercicio03 ej03 = new Ejercicio03();

		String texto = "Hola, mundo! hola a todos. Este es un ejemplo: un ejemplo simple.";

		// Llamar al método y obtener el resultado
		String[] palabrasUnicas = ej03.listadoPalabrasUnicasPorTexto(texto);

		// Imprimir el resultado
		System.out.println("Palabras únicas en el texto:");
		for (String palabra : palabrasUnicas) {
			System.out.println(palabra);
		}
		System.out.println("------------");
		Ejercicio04 tiendaLibros = new Ejercicio04();

		// Agregar algunos libros
		tiendaLibros.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", 1, 12.99));
		tiendaLibros.agregarLibro(new Libro("Cien Años de Soledad", "Gabriel García Márquez", 1, 15.50));
		tiendaLibros.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", 2, 12.99));
		tiendaLibros.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", 3, 12.99));
		tiendaLibros.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", 4, 12.99));

		// Mostrar los títulos únicos
		tiendaLibros.mostrarTitulos();
	}

}
