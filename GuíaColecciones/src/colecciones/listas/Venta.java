package colecciones.listas;

import java.time.LocalDateTime;

public class Venta {
	private static int contadorVentas = 0;

	private int numeroVenta;
	private LocalDateTime fechaYHora;
	private String nombreCliente;
	private double monto;

	public Venta(LocalDateTime fechaYHora, String nombreCliente, double monto) {
		this.numeroVenta = ++contadorVentas;
		this.fechaYHora = fechaYHora;
		this.nombreCliente = nombreCliente;
		this.monto = monto;
	}

	public int getNumeroVenta() {
		return numeroVenta;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Venta [numeroVenta=" + numeroVenta + ", fechaYHora=" + fechaYHora + ", nombreCliente=" + nombreCliente
				+ ", monto=" + monto + "]";
	}

}
