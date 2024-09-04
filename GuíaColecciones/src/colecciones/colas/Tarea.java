package colecciones.colas;

public class Tarea {
	private String nombre;
	private String descripcion;
	private int numero;

	public Tarea(String nombre, String descripcion, int numero) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numero = numero;
	}

	public Tarea() {
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + ", descripcion=" + descripcion + ", numero=" + numero + "]";
	}

}
