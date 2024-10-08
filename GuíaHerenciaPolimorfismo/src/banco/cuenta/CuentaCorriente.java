package banco.cuenta;

import java.math.BigDecimal;

public class CuentaCorriente extends CuentaBancaria {
	private BigDecimal montoDescubierto;
	private BigDecimal deuda = BigDecimal.ZERO;

	public CuentaCorriente(String nombrePropietario, BigDecimal saldo, BigDecimal montoDescubierto)
			throws IllegalArgumentException, SaldoNegativoException {
		super(nombrePropietario, saldo);
		if (montoDescubierto.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("El monto de descubierto no puede ser negativo.");
		this.montoDescubierto = montoDescubierto;
	}

	@Override
	public BigDecimal retirar(BigDecimal monto) throws SaldoInsuficienteException, SaldoNegativoException {
		BigDecimal saldoDisponible = getSaldoActual().add(montoDescubierto);

		if (monto.compareTo(saldoDisponible) > 0)
			throw new SaldoInsuficienteException("El monto excede el saldo disponible más el descubierto.");
		if (monto.compareTo(getSaldoActual()) > 0) {
			deuda = monto.subtract(getSaldoActual());
			super.retirar(getSaldoActual());
		} else
			super.retirar(monto);

        registrarTransaccion(monto, "Retiro con descubierto", TipoTransaccion.DEBITO);
		return monto;
	}

	@Override
	public void depositar(BigDecimal monto) throws SaldoInsuficienteException, SaldoNegativoException {
		if (monto.compareTo(BigDecimal.ZERO) <= 0)
			throw new SaldoInsuficienteException("No se puede depositar un monto negativo o cero.");

		if (deuda.compareTo(BigDecimal.ZERO) > 0) {
			if (monto.compareTo(deuda) >= 0) {
				monto = monto.subtract(deuda);
				deuda = BigDecimal.ZERO;
			} else {
				deuda = deuda.subtract(monto);
				monto = BigDecimal.ZERO;
			}
		}
		if (monto.compareTo(BigDecimal.ZERO) > 0) {
			super.depositar(monto);
            registrarTransaccion(monto, "Depósito para cubrir deuda", TipoTransaccion.CREDITO);
		}
	}

	// Getters
	public BigDecimal getMontoDescubierto() {
		return montoDescubierto;
	}

	public BigDecimal getDeuda() {
		return deuda;
	}

}