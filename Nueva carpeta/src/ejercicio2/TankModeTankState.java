package ejercicio2;

public class TankModeTankState implements TankState {

	@Override
	public void moverse() {
		System.out.println("El tanque se mueve rápidamente en Modo Tanque.");
	}

	@Override
	public void atacar() {
		System.out.println("El tanque dispara con su cañón en Modo Tanque.");
	}
}
