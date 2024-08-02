package objetos.ejercicio06;

public class Cerradura {
	private int clave;
	private int fallosPosibles;
	private int fallosConsecutivos;
	private boolean estaBloqueada;
	private boolean estaAbierta;
	private int aperturasExitosas;
	private int aperturasFallidas;

	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.clave = claveDeApertura;
		this.fallosPosibles = cantidadDeFallosConsecutivosQueLaBloquean;
		this.fallosConsecutivos = 0;
		this.estaAbierta = false;
		this.aperturasExitosas = 0;
		this.aperturasFallidas = 0;
		this.estaBloqueada = false;
	}

	public boolean abrir(int clave) {
		if (this.estaBloqueada) {
			System.out.println("La cerradura esta bloqueada"); // Seria mejor una excepcion pero no se vio a esta
																// instancia.
			return false;
		}

		if (this.fallosConsecutivos == this.fallosPosibles) {
			System.out.println("La cerradura se ha bloqueado"); // Seria mejor una excepcion pero no se vio a esta
																// instancia.
			return false;
		}

		if (this.estaAbierta) {
			System.out.println("La cerradura ya estaba abierta"); // Seria mejor una excepcion pero no se vio a esta
																	// instancia.
			return false;
		}

		this.estaAbierta = clave == this.clave;

		if (!this.estaAbierta) {
			this.fallosConsecutivos++;
			this.aperturasFallidas++;
		} else {
			this.fallosConsecutivos = 0;
			this.aperturasExitosas += 1;
		}

		return this.estaAbierta;
	}

	public void cerrar() {
		this.estaAbierta = false;
	}

	public boolean estaAbierta() {
		return this.estaAbierta;
	}

	public boolean estaCerrada() {
		return !this.estaAbierta;
	}

	public boolean fueBloqueada() {
		return this.estaBloqueada;
	}

	public int contarAperturasExitosas() {
		return this.aperturasExitosas;
	}

	public int contarAperturasFallidas() {
		return this.aperturasFallidas;
	}
}
