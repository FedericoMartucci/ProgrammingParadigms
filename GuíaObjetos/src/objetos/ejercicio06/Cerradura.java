package objetos.ejercicio06;

public class Cerradura {
	private int clave;
	private int fallosRestantes;
	private boolean estaAbierta;
	private int aperturasExitosas;
	private int aperturasFallidas;

	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.clave = claveDeApertura;
		this.fallosRestantes = cantidadDeFallosConsecutivosQueLaBloquean;
		this.estaAbierta = false;
		this.aperturasExitosas = 0;
		this.aperturasFallidas = 0;
	}

//	public boolean abrir(int clave) {
//		if(this.estaAbierta || this.fallosRestantes == 0) {
//			return 
//		}
//		this.estaAbierta = clave == this.clave;
//		if(!this.estaAbierta) {
//			this.fallosRestantes -= 1;
//			this.aperturasFallidas += 1;
//		}
//		else
//			this.aperturasExitosas += 1;
//		
//		return this.estaAbierta;
//	}

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
//		return this.fallosRestantes == 0;
	}

	public int contarAperturasExitosas() {
		return this.aperturasExitosas;
	}

	public int contarAperturasFallidas() {
		return this.aperturasFallidas;
	}
}
