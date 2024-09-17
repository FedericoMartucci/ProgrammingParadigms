package banco.cuenta;

import java.math.BigDecimal;

public class CuentaCorriente extends CuentaBancaria {
	private BigDecimal montoDescubierto;
	private BigDecimal deuda;

	public CuentaCorriente(String nombrePropietario, BigDecimal saldo, BigDecimal montoDescubierto) {
		super(nombrePropietario, saldo);
		this.montoDescubierto = montoDescubierto;
		this.setDeuda(BigDecimal.ZERO);
	}

	public BigDecimal retirar(BigDecimal monto) throws SaldoInsuficienteException {
		try {
			if (monto.compareTo(getSaldoActual().add(getMontoDescubierto())) < 0)
				throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");
			if (monto.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede retirar un saldo negativo");
			if (monto.compareTo(getSaldoActual()) <= 0)
				setSaldoActual(getSaldoActual().subtract(monto));
			else {
				setDeuda(monto.subtract(getSaldoActual()));
				setSaldoActual(BigDecimal.ZERO);
			}
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}
		return monto;
	}

	public BigDecimal getMontoDescubierto() {
		return montoDescubierto;
	}

	public BigDecimal getDeuda() {
		return deuda;
	}

	private void setDeuda(BigDecimal deuda) {
		this.deuda = deuda;
	}

}