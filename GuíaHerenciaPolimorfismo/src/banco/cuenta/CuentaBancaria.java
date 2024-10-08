package banco.cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
	private String nombrePropietario;
	private BigDecimal saldoActual;
	private List<Transaccion> transacciones;

	public CuentaBancaria(String nombrePropietario, BigDecimal saldo) throws SaldoNegativoException {
		if (saldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new SaldoNegativoException("No se puede crear una cuenta con saldo negativo.");
		}
		this.nombrePropietario = nombrePropietario;
		this.saldoActual = saldo;
		this.transacciones = new ArrayList<Transaccion>();
	}

	public BigDecimal retirar(BigDecimal monto) throws SaldoNegativoException, SaldoInsuficienteException {
		if (monto.compareTo(BigDecimal.ZERO) <= 0)
			throw new SaldoNegativoException("No se puede retirar un monto negativo o cero.");
		if (monto.compareTo(getSaldoActual()) > 0)
			throw new SaldoInsuficienteException("No tenes saldo suficiente para realizar esa operacion.");

		saldoActual = saldoActual.subtract(monto);
        registrarTransaccion(monto, "Retiro de efectivo", TipoTransaccion.DEBITO);
		return monto;
	}

	public void depositar(BigDecimal monto) throws SaldoNegativoException {
		if (monto.compareTo(BigDecimal.ZERO) < 0)
			throw new SaldoNegativoException("No se puede depositar saldo negativo.");
		saldoActual = saldoActual.add(monto);
		registrarTransaccion(monto, "Depósito de efectivo", TipoTransaccion.CREDITO);	}

	public void transferir(CuentaBancaria cuentaDestino, BigDecimal monto) throws SaldoNegativoException {
		retirar(monto);
		cuentaDestino.depositar(monto);
        registrarTransaccion(monto, "Transferencia a " + cuentaDestino.getNombrePropietario(), TipoTransaccion.DEBITO);
	}
	
	public void registrarTransaccion(BigDecimal monto, String motivo, TipoTransaccion tipo) {
        transacciones.add(new Transaccion(monto, motivo, tipo));
    }

	// Getters
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public BigDecimal getSaldoActual() {
		return saldoActual;
	}
}