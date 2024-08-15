package ejercicio03;

public class Luchador {
	private int peso;
	private int altura;
	private int cantDominados;
	
	public Luchador(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
		this.cantDominados = 0;
	}

	public Luchador() {
		this.peso = 0;
		this.altura = 0;
		this.cantDominados = 0;
	}

	public int getPeso() {
		return peso;
	}

	public int getAltura() {
		return altura;
	}

	public int getCantDominados() {
		return cantDominados;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public void setCantDominados(int cant) {
		this.cantDominados = cant;
	}
	
	public boolean dominaContrincante(Luchador contrincante) {
		return this.altura >= contrincante.getAltura() && this.peso >= contrincante.getPeso();
	}
	
}
