package colecciones.pilas;

import java.util.Stack;

public class Ejercicio10 {
	/*
	 * Un programa necesita procesar una serie de comandos de usuario que se reciben
	 * en una terminal. Escriba un programa que utilice una pila para almacenar los
	 * comandos a medida que se reciben. El programa debe permitir deshacer la
	 * última operación realizada por el usuario desapilando el último comando
	 * almacenado.
	 * 
	 * Tip: Los comandos serán simulados, no deben ejecutarse realmente. Conviene
	 * modelar la clase Terminal con sus métodos para introducir comandos y
	 * deshacerlos.
	 */

	private Stack<String> comandos;

	public Ejercicio10() {
		comandos = new Stack<String>();
	}

	public void introducirComando(String comando) {
		comandos.push(comando);
	}

	public void deshacerComando() {
		if (comandos.isEmpty())
			throw new RuntimeException("La pila esta vacia");
		comandos.pop();
	}

	public void mostrarComandos() {
		System.out.println("Comandos actuales en la pila: " + comandos);
	}

}
