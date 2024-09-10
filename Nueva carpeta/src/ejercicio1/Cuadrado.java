package ejercicio1;

public class Cuadrado implements Forma {
	private double lado;

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double getArea() {
		return lado * lado;
	}

}