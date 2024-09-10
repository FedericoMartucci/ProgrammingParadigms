package ejercicio1;

public class Circulo implements Forma {
	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double getArea() {
		return Math.PI * radio * radio;
	}

}