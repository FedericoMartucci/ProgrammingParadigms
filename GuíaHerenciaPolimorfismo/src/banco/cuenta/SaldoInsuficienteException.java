package banco.cuenta;

public class SaldoInsuficienteException extends RuntimeException {
	private static final long serialVersionUID = -7661270390654459299L;

	public SaldoInsuficienteException(String message) {
		super(message);
	}
}
