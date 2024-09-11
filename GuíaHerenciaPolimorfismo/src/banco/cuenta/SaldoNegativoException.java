package banco.cuenta;

public class SaldoNegativoException extends Exception {
	private static final long serialVersionUID = -1137802916326254301L;

	public SaldoNegativoException(String message) {
		super(message);
	}
}