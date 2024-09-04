package main;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

import colecciones.colas.Ejercicio07;
import colecciones.colas.Ejercicio08;
import colecciones.colas.Tarea;
import colecciones.conjuntos.Ejercicio03;
import colecciones.conjuntos.Ejercicio04;
import colecciones.conjuntos.Libro;
import colecciones.listas.Ejercicio01;
import colecciones.listas.Ejercicio02;
import colecciones.listas.Paquete;
import colecciones.listas.Venta;
import colecciones.mapas.Ejercicio05;
import colecciones.mapas.Ejercicio06;
import colecciones.pilas.Ejercicio09;
import colecciones.pilas.Ejercicio10;

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

		System.out.println("------------");

		Ejercicio05 ej05 = new Ejercicio05();
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 1, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 1, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 2, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 2, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 1, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 1, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 3, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 3, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 12, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 11, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 11, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 11, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.of(2024, 11, 7, 15, 23), "Cliente A", 150.75));
		ej05.agregarVenta(new Venta(LocalDateTime.now(), "Cliente A", 150.75));

		ej05.mostrarVentas();
		System.out.println("------------");

		Ejercicio06 ej06 = new Ejercicio06();
		ej06.agregarNota("Federico Martucci", 10);
		ej06.agregarNota("Juan Bianchi", 5);
		ej06.agregarNota("Agustin Brocani", 5);
		ej06.agregarNota("Federico Martucci", 10);
		ej06.agregarNota("Federico Martucci", 4);
		ej06.agregarNota("Federico Martucci", 6);
		ej06.agregarNota("Agustin Brocani", 2);
		ej06.agregarNota("Agustin Brocani", 5);
		ej06.agregarNota("Federico Martucci", 8);
		ej06.agregarNota("Juan Bianchi", 3);
		ej06.agregarNota("Juan Bianchi", 10);
		ej06.agregarNota("Juan Bianchi", 9);
		ej06.agregarNota("Federico Martucci", 5);
		ej06.agregarNota("Juan Bianchi", 7);
		ej06.agregarNota("Federico Martucci", 8);
		ej06.agregarNota("Federico Martucci", 5);
		ej06.agregarNota("Javier Milei", 1);
		ej06.agregarNota("Federico Martucci", 5);
		ej06.agregarNota("Javier Milei", 3);
		ej06.agregarNota("Javier Milei", 10);
		ej06.agregarNota("Javier Milei", 7);
		ej06.agregarNota("Federico Martucci", 6);
		ej06.agregarNota("Javier Milei", 4);
		ej06.agregarNota("Federico Martucci", 10);
		ej06.agregarNota("Federico Martucci", 10);
		ej06.agregarNota("Javier Milei", 1);
		ej06.agregarNota("Federico Martucci", 3);

		ej06.mostrarNotas();
		System.out.println("------------");
		ej06.obtenerPromedioNotas();
		System.out.println("------------");
		ej06.obtenerPromedioNotas("Federico Martucci");

		System.out.println("------------");

		Ejercicio07 ej07 = new Ejercicio07();
		for (int i = 0; i < 10; i++)
			ej07.agregarTarea(new Tarea("tarea " + (i + 1), "descripcion " + (i + 1), i + 1));
		ej07.mostrarTareasRecibidas();

		System.out.println("------------");

		Ejercicio08 ej08 = new Ejercicio08();
		for (int i = 0; i < 10; i++)
			ej08.agregarTarea(new Tarea("tarea " + (i + 1), "descripcion " + (i + 1), i + 1));
		ej08.mostrarTareasRecibidas();
		System.out.println("------------");
		ej08.invertirTareas();
		ej08.mostrarTareasRecibidas();

		System.out.println("------------");

		String[] expresiones = { "((a + b) * (c - d))", // Válida
				"{[(2 * 3) + (4 / 2)] - 5}", // Válida
				"([1 + 2] * {3 + 4}) - ((5 - 6) / 7)", // Válida
				"x = (y + z) * (a / b) - [c + {d * e}]", // Válida
				"((a + b) * (c - d)", // Inválida (falta un paréntesis de cierre)
				"[(1 + 2) * {3 + 4}", // Inválida (falta una llave de cierre)
				"([1 + 2]) * (3 + 4))", // Inválida (paréntesis de cierre extra)
				"({[(a + b) * c] - d}", // Inválida (falta un paréntesis de cierre)
				"{[1 + 2] * (3 + 4)", // Inválida (falta una llave de cierre)
				"function() { return [1, 2, (3 + 4)]; }", // Válida
				"if (x > y) { z = x + [a - (b / c)] }", // Válida
				"{[(2 * (3 + 4))] - [5 / (6 + 7)]}", // Válida
				"", // Válida (vacía)
				"()", // Válida
				"{}", // Válida
				"[]" // Válida
		};
		Arrays.sort(expresiones);
		// Ejecutar pruebas
		for (String expresion : expresiones) {
			Ejercicio09 ej = new Ejercicio09(expresion);
			boolean esValida = ej.validarExpresion();
			System.out.println("Expresión: \"" + expresion + "\" -> " + (esValida ? "Válida" : "Inválida"));
		}

		System.out.println("------------");

		Ejercicio10 terminal = new Ejercicio10();

		// Ejemplo de uso
		terminal.introducirComando("Comando1");
		terminal.introducirComando("Comando2");
		terminal.introducirComando("Comando3");

		terminal.mostrarComandos();

		terminal.deshacerComando();
		terminal.mostrarComandos();

		terminal.deshacerComando();
		terminal.deshacerComando();
		terminal.deshacerComando(); // Intento de deshacer cuando la pila está vacía
	}

}
