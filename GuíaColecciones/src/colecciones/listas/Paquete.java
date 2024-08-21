package colecciones.listas;

public class Paquete {
	private int numeroSeguimiento;
	private String direccionOrigen;
	private String direccionDestino;
	private double peso;

	public Paquete(int numeroSeguimiento, String direccionOrigen, String direccionDestino, double peso) {
		this.numeroSeguimiento = numeroSeguimiento;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}

	public int getNumeroSeguimiento() {
		return numeroSeguimiento;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setNumeroSeguimiento(int numeroSeguimiento) {
		this.numeroSeguimiento = numeroSeguimiento;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Paquete [numeroSeguimiento=" + numeroSeguimiento + ", direccionOrigen=" + direccionOrigen
				+ ", direccionDestino=" + direccionDestino + ", peso=" + peso + "]";
	}

}
