package ejercicio2;

public class TankModeSiegeState implements TankState {

	@Override
	public void moverse() {
		System.out.println("El tanque no puede moverse en Modo Asedio.");
	}

	@Override
	public void atacar() {
		System.out.println("El tanque dispara con un cañón de largo alcance en Modo Asedio.");
	}

}
