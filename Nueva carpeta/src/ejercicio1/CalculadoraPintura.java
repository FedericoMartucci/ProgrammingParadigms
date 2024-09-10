package ejercicio1;

public class CalculadoraPintura {
	private static final double COBERTURA_TEMPERA = 100.0; // cm2 por pomo

	public static int calcularTubosDePintura(Forma grupoFormas) {
		return (int) Math.ceil(grupoFormas.getArea() / COBERTURA_TEMPERA);
	}
}
