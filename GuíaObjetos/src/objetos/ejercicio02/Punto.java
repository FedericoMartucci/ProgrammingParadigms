package objetos.ejercicio02;

public class Punto {
	private double x;
	private double y;
	
	public double obtenerX() {
		return this.x;
	}
	
	public double obtenerY() {
		return this.y;
	}
	
	public void cambiarX(double nuevoX) {
		this.x = nuevoX;
	}
	
	public void cambiarY(double nuevoY) {
		this.y = nuevoY;
	}
	
	public boolean estaSobreEjeX() {
		return this.obtenerX() == 0;
	}

	public boolean estaSobreEjeY() {
		return this.obtenerY() == 0;
	}

	public boolean esElOrigen() {
		return this.estaSobreEjeX() && this.estaSobreEjeY();
	}

	public double distanciaAlOrigen() {
		return Math.sqrt(Math.pow(this.obtenerX(), 2) + Math.pow(this.obtenerY(), 2));
	}
	
	public double distanciaAotroPunto(Punto otro) {
		return Math.sqrt(Math.pow(this.obtenerX() - otro.obtenerX(), 2) + Math.pow(this.obtenerY() - otro.obtenerY(), 2));
	}
	
}
