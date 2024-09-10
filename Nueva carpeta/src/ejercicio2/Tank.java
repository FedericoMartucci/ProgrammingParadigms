package ejercicio2;

public class Tank {

	/*
	 * Considere que tiene una clase llamada "Tank" que representa a un tanque
	 * Terran en Starcraft 2. Implemente el patrón State para modelar los dos
	 * posibles estados del tanque: el estado "Modo Tanque" y el estado
	 * "Modo Asedio". A continuación, se proporcionan varios métodos que puede
	 * incluir en la implementación:
	 * 
	 * - Tank: la clase principal que representa un tanque Terran y contiene una
	 * referencia a un objeto de estado concreto.
	 * 
	 * - TankState: la interfaz que define los métodos comunes que deben implementar
	 * los estados concretos.
	 * 
	 * - TankModeTankState: una clase que implementa la interfaz TankState y
	 * representa el estado "Modo Tanque" del tanque. Debe proporcionar
	 * implementaciones para los métodos específicos de este estado, como moverse()
	 * y atacar().
	 * 
	 * - TankModeSiegeState: una clase que implementa la interfaz TankState y
	 * representa el estado "Modo Asedio" del tanque. Debe proporcionar
	 * implementaciones para los métodos específicos de este estado, como moverse()
	 * y atacar().
	 */

	private TankState estadoActual;

	public Tank() {
		this.estadoActual = new TankModeTankState();
	}

	public void setModeTank() {
		this.estadoActual = new TankModeTankState();
	}

	public void setModeSiege() {
		this.estadoActual = new TankModeSiegeState();
	}

	// Delegar las acciones al estado actual
	public void move() {
		estadoActual.moverse();
	}

	public void attack() {
		estadoActual.atacar();
	}
}
