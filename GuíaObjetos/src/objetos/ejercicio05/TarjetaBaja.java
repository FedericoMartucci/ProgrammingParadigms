package objetos.ejercicio05;

public class TarjetaBaja {
	private double saldo;
	private int viajesColetivo;
	private int viajesSubte;
	
		/**
		 * post: saldo de la Tarjeta en saldoInicial.
		 */
		public TarjetaBaja(double saldoInicial) {
			this.saldo = saldoInicial;
			this.viajesColetivo = 0;
			this.viajesSubte = 0;
		}

		/**
		 * post: devuelve el saldo actual de la Tarjeta
		 */
		public double obtenerSaldo() {
			return this.saldo;
		}

		/**
		 * post: agrega el monto al saldo de la Tarjeta.
		 */
		public void cargar(double monto) {
			this.saldo += monto;
		}

		/**
		 * pre : saldo suficiente. post: utiliza 39.59 del saldo para un viaje en
		 * colectivo.
		 */
		public void pagarViajeEnColectivo() {
			this.saldo -= 39.59;
			this.viajesColetivo += 1;
		}

		/**
		 * pre : saldo suficiente. post: utiliza 34.50 del saldo para un viaje en subte.
		 */
		public void pagarViajeEnSubte() {
			this.saldo -= 34.5;
			this.viajesSubte += 1;
		}

		/**
		 * post: devuelve la cantidad de viajes realizados.
		 */
		public int contarViajes() {
			return this.viajesColetivo + this.viajesSubte;
		}

		/**
		 * post: devuelve la cantidad de viajes en colectivo.
		 */
		public int contarViajesEnColectivo() {
			return this.viajesColetivo;
		}

		/**
		 * post: devuelve la cantidad de viajes en subte.
		 */
		public int contarViajesEnSubte() {
			return this.viajesSubte;
		}
}
