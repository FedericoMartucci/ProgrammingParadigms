package colecciones.conjuntos;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
	private String titulo;
	private String autor;
	private int numeroEjemplar;
	private double precio;

	public Libro(String titulo, String autor, int numeroEjemplar, double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.numeroEjemplar = numeroEjemplar;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public double getNumeroEjemplar() {
		return numeroEjemplar;
	}

	public double getPrecio() {
		return precio;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setNumeroEjemplar(int numeroEjemplar) {
		this.numeroEjemplar = numeroEjemplar;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", numeroEjemplar=" + numeroEjemplar + ", precio="
				+ precio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Libro o) {
		return this.getTitulo().compareTo(o.getTitulo());
	}

}
