package banco.cuenta;

import java.math.BigDecimal;

public class CuentaAhorro extends CuentaBancaria {
	private BigDecimal saldoReservado;

	public CuentaAhorro(String nombrePropietario, BigDecimal saldo) {
		super(nombrePropietario, saldo);
		// TODO Auto-generated constructor stub
	}

	public void reservar(BigDecimal cantidad) {
		try {
			if (cantidad.compareTo(getSaldoActual()) < 0)
				throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");
			if (cantidad.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede reservar un monto negativo");
			setSaldoActual(getSaldoActual().subtract(cantidad));
			setSaldoReservado(saldoReservado.add(cantidad));
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}
	}

	public void reintegrarSaldoReservado(BigDecimal cantidad) {
		try {
			if (cantidad.compareTo(this.getSaldoReservado()) < 0)
				throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");
			if (cantidad.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede reintegrar un monto negativo");
			setSaldoReservado(saldoReservado.subtract(cantidad));
			setSaldoActual(getSaldoActual().add(cantidad));
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}
	}

	public void reintegrarSaldoReservadoTotal() {
		reintegrarSaldoReservado(saldoReservado);
	}

	public BigDecimal getSaldoReservado() {
		return saldoReservado;
	}

	public void setSaldoReservado(BigDecimal nuevoSaldo) {
		saldoReservado = nuevoSaldo;
	}
}
