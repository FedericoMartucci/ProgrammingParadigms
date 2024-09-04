package colecciones.pilas;

import java.util.Stack;

public class Ejercicio09 {
	/*
	 * Un programa necesita determinar si una expresión aritmética es válida. Diseñe
	 * un programa que utilice una pila para almacenar los paréntesis abiertos y
	 * cerrados en la expresión. El programa debe asegurarse de que los paréntesis
	 * estén correctamente balanceados.
	 */
	private String expresion;

	public Ejercicio09(String expresion) {
		this.expresion = expresion;
	}

	public boolean validarExpresion() {
		Stack<Character> simbolosParentizadores = new Stack<Character>();

		for (int i = 0; i < expresion.length(); i++) {
			char caracterLeido = expresion.charAt(i);
			if (esSimboloApertura(caracterLeido)) {
				simbolosParentizadores.push(caracterLeido);
			} else if (esSimboloCierre(caracterLeido)) {
				if (simbolosParentizadores.isEmpty())
					return false;
				if (!esSimboloComplemento(simbolosParentizadores.peek(), caracterLeido))
					return false;
				simbolosParentizadores.pop();
			}

		}

		return simbolosParentizadores.isEmpty();
	}

	private boolean esSimboloApertura(char simboloLeido) {
		return simboloLeido == '(' || simboloLeido == '[' || simboloLeido == '{';
	}

	private boolean esSimboloCierre(char simboloLeido) {
		return simboloLeido == ')' || simboloLeido == ']' || simboloLeido == '}';
	}

	private boolean esSimboloComplemento(char simboloActual, char simboloRecibido) {
		return simboloActual == '(' && simboloRecibido == ')' || simboloActual == '[' && simboloRecibido == ']'
				|| simboloActual == '{' && simboloRecibido == '}';
	}

}
