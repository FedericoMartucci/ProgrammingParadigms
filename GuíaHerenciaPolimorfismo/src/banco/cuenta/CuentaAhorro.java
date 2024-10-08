package banco.cuenta;

import java.math.BigDecimal;

public class CuentaAhorro extends CuentaBancaria {
	private BigDecimal saldoReservado = BigDecimal.ZERO;

	public CuentaAhorro(String nombrePropietario, BigDecimal saldo) throws SaldoNegativoException {
		super(nombrePropietario, saldo);
	}

	public void reservar(BigDecimal monto) throws SaldoInsuficienteException, SaldoNegativoException {

		if (monto.compareTo(BigDecimal.ZERO) <= 0)
			throw new SaldoNegativoException("No se puede reservar un monto negativo o cero.");
		if (monto.compareTo(getSaldoActual()) > 0)
			throw new SaldoInsuficienteException("No tenes saldo suficiente para reservar esta cantidad.");

		retirar(monto);
		saldoReservado = saldoReservado.add(monto);
        registrarTransaccion(monto, "Saldo reservado", TipoTransaccion.DEBITO);
	}

	public void reintegrarSaldoReservado(BigDecimal monto) throws SaldoInsuficienteException, SaldoNegativoException {
		if (monto.compareTo(BigDecimal.ZERO) <= 0)
			throw new SaldoNegativoException("El monto de reintegración debe ser mayor que cero.");

		if (monto.compareTo(saldoReservado) > 0)
			throw new SaldoInsuficienteException("No podes reintegrar más de lo que tienes reservado.");

		saldoReservado = saldoReservado.subtract(monto);
		depositar(monto);
        registrarTransaccion(monto, "Reintegración de saldo reservado", TipoTransaccion.CREDITO);
	}

	public void reintegrarSaldoReservadoTotal() throws SaldoInsuficienteException, SaldoNegativoException {
		if (saldoReservado.compareTo(BigDecimal.ZERO) > 0) {
			reintegrarSaldoReservado(saldoReservado);
		} else {
			throw new SaldoInsuficienteException("No hay saldo reservado para reintegrar.");
		}
	}

	// Getter
	public BigDecimal getSaldoReservado() {
		return saldoReservado;
	}
}
