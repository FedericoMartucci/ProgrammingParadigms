package main;

public class Resultado {
	private int maximo;
	private int minimo;
	private int promedio;
	
	public Resultado(int maximo, int minimo, int promedio) {
		this.maximo = maximo;
		this.minimo = minimo;
		this.promedio = promedio;
	}
	
	public Resultado() {
		this.maximo = 0;
		this.minimo = 0;
		this.promedio = 0;
	}
	
	public int getMaximo() {
		return maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	public int getPromedio() {
		return promedio;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	
}
