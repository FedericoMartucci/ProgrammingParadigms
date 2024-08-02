package objetos.ejercicio03;

public class Circulo {
	private double radio;
	
	public Circulo() {
		this.radio = 0;
	}
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public void setRadio(double nuevoRadio) {
		this.radio = nuevoRadio;
	}

	public double getDiametro() {
		return 2 * this.getRadio();
	}
	
	public void setDiametro(double nuevoDiametro) {
		this.radio = nuevoDiametro / 2;
	}
	
	public double getPerimetro() {
		return 2 * Math.PI * this.getRadio();
	}
	
	public void setPerimetro(double nuevoPerimetro) {
		this.radio = nuevoPerimetro / (2 * Math.PI);
	}

	public double getArea() {
		return Math.PI * Math.pow(this.getRadio(), 2);
	}
	
	public void setArea(double nuevaArea) {
		this.radio = Math.sqrt(nuevaArea / Math.PI);
	}

}
