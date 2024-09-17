package banco.cuenta;

import java.math.BigDecimal;

public class CuentaBancaria {
	private String nombrePropietario;
	private BigDecimal saldoActual;

	public CuentaBancaria(String nombrePropietario, BigDecimal saldo) {
		this.nombrePropietario = nombrePropietario;
		try {
			if (saldo.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede crear una cuenta con saldo negativo");
			this.saldoActual = saldo;
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
			this.saldoActual = BigDecimal.ZERO;
		}
	}

	public void transferir(CuentaBancaria c, BigDecimal monto) throws SaldoInsuficienteException {
		try {
			if (monto.compareTo(this.getSaldoActual()) < 0)
				throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");
			if (monto.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede retirar un saldo negativo");
			this.setSaldoActual(this.getSaldoActual().subtract(monto));
			c.setSaldoActual(c.getSaldoActual().add(monto));
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}
	}

	public BigDecimal retirar(BigDecimal monto) throws SaldoInsuficienteException {
		try {
			if (monto.compareTo(getSaldoActual()) < 0)
				throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");
			if (monto.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede retirar un saldo negativo");
			setSaldoActual(getSaldoActual().subtract(monto));
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}
		return monto;
	}

	public void depositar(BigDecimal monto) {
		try {
			if (monto.compareTo(BigDecimal.ZERO) < 0)
				throw new SaldoNegativoException("No se puede depositar saldo negativo.");
			this.setSaldoActual(monto.add(getSaldoActual()));
		} catch (SaldoNegativoException e) {
			System.err.println(e.getMessage());
		}

	}

	// Getters y Setters
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public BigDecimal getSaldoActual() {
		return saldoActual;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public void setSaldoActual(BigDecimal nuevoSaldo) {
		this.saldoActual = nuevoSaldo;
	}

	
}