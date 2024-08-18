package main;

/*
 * 



 * */

public final class Rango implements Comparable<Rango> {
//	10. Un rango es inmutable: no puede modificarse una vez creado. AGREGO FINAL
	private final double limiteInferior;
	private final double limiteSuperior;
	private final boolean abiertoIzquierda;
	private final boolean abiertoDerecha;

	private static double minLimInf;
	private static double maxLimSup;
	private static boolean minAbiertoIzq;
	private static boolean maxAbiertoDer;

//	1. Un rango deberá poder crearse en sus cuatro combinaciones posibles
//	3. Teniendo los métodos estáticos, será buena idea hacer el constructor privado, ya que
//	sólamente se accederá a él por los métodos estáticos.
	private Rango(double li, double ls, boolean izq, boolean der) {
		this.limiteInferior = li;
		this.limiteSuperior = ls;
		this.abiertoIzquierda = izq;
		this.abiertoDerecha = der;

		if (li < Rango.getMinLimInf()) {
			Rango.setMinLimInf(li);
			Rango.setMinAbiertoIzq(izq);
		} else if (li == Rango.getMinLimInf() && !izq)
			Rango.setMinAbiertoIzq(izq);

		if (ls > Rango.getMaxLimSup()) {
			Rango.setMaxLimSup(ls);
			Rango.setMaxAbiertoDer(der);
		} else if (ls == Rango.getMaxLimSup() && !der)
			Rango.setMaxAbiertoDer(der);
	}

//	2. Dado que tener un constructor tan complejo puede ser perjudicial, implementar cuatro métodos estáticos que permitan la creación de estas combinaciones.
	// [li, ls]
	public static Rango cerrado(double li, double ls) {
		return new Rango(li, ls, false, false);
	}

	// [li, ls)
	public static Rango cerradoAbierto(double li, double ls) {
		return new Rango(li, ls, false, true);
	}

	// (li, ls]
	public static Rango abiertoCerrado(double li, double ls) {
		return new Rango(li, ls, true, false);
	}

	// (li, ls)
	public static Rango abierto(double li, double ls) {
		return new Rango(li, ls, true, true);
	}

//	4. Se debe poder consultar si un número está dentro de un rango.
	public boolean contiene(double numero) {
		boolean dentroInicio = this.isAbiertoIzquierda() ? numero > this.getLimiteInferior()
				: numero >= this.getLimiteInferior();
		boolean dentroFin = this.isAbiertoDerecha() ? numero < this.getLimiteSuperior()
				: numero <= this.getLimiteSuperior();

		return dentroInicio && dentroFin;

//		if(!this.abiertoIzquierda)
//			if(numero < this.limiteInferior)
//				return false;
//		else
//			if(numero <= this.limiteInferior)
//				return false;
//		if(!this.abiertoDerecha)
//			if(numero > this.limiteSuperior)
//				return false;
//		else
//			if(numero >= this.limiteSuperior)
//				return false;
//		return true;
	}

//	5. Se debe poder consultar si un rango está dentro de un rango.
	public boolean contiene(Rango rango) {
		boolean dentroInicio = this.isAbiertoIzquierda()
				? (rango.isAbiertoIzquierda() ? rango.getLimiteInferior() >= this.getLimiteInferior()
						: rango.getLimiteInferior() > this.getLimiteInferior())
				: rango.getLimiteInferior() >= this.getLimiteInferior();
		boolean dentroFin = this.isAbiertoDerecha()
				? (rango.isAbiertoDerecha() ? rango.getLimiteSuperior() <= this.getLimiteSuperior()
						: rango.getLimiteSuperior() < this.getLimiteSuperior())
				: rango.getLimiteSuperior() <= this.getLimiteSuperior();

		return dentroInicio && dentroFin;
	}

//	6. Se debe poder consultar si hay intersección entre dos rangos.
	public boolean hayInterseccion(Rango rango) {
		if (this.getLimiteSuperior() <= rango.getLimiteInferior()
				|| rango.getLimiteSuperior() <= this.getLimiteInferior()) {
			return false;
		}

		// Considerar los límites abiertos/cerrados en la intersección
		boolean interseccionPorInicio = (this.abiertoDerecha && rango.getLimiteInferior() == this.getLimiteSuperior())
				|| (rango.abiertoDerecha && this.getLimiteInferior() == rango.getLimiteSuperior())
				|| (this.getLimiteInferior() < rango.getLimiteSuperior()
						&& this.getLimiteSuperior() > rango.getLimiteInferior());

		boolean interseccionPorFin = (this.abiertoIzquierda && rango.getLimiteSuperior() == this.getLimiteInferior())
				|| (rango.abiertoIzquierda && this.getLimiteSuperior() == rango.getLimiteInferior())
				|| (this.getLimiteSuperior() > rango.getLimiteInferior()
						&& this.getLimiteInferior() < rango.getLimiteSuperior());

		return interseccionPorInicio || interseccionPorFin;
	}

//	7. Se debe poder comparar por igualdad los rangos.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Rango rango = (Rango) obj;

		return this.getLimiteInferior() == rango.getLimiteInferior()
				&& this.getLimiteSuperior() == rango.getLimiteSuperior()
				&& this.isAbiertoDerecha() == rango.isAbiertoDerecha()
				&& this.isAbiertoIzquierda() == rango.isAbiertoIzquierda();
	}

//	8. Se debe poder ordenar rangos mediante su inicio. Si empatan, se resuelve el empate
//	por su fin. Si empatan, los rangos cerrados irán primero que los abiertos.
	@Override
	public int compareTo(Rango r) {
		int cmp = Double.compare(this.getLimiteInferior(), r.getLimiteInferior());

		if (cmp != 0)
			return cmp;

		cmp = Double.compare(this.getLimiteSuperior(), r.getLimiteSuperior());
		if (cmp != 0)
			return cmp;

		if (this.isAbiertoIzquierda() == r.isAbiertoIzquierda() && this.isAbiertoDerecha() == r.isAbiertoDerecha())
			return 0;

		if (this.isAbiertoIzquierda() != r.isAbiertoIzquierda())
			return this.isAbiertoIzquierda() ? 1 : -1;

		if (this.isAbiertoDerecha() != r.isAbiertoDerecha())
			return this.isAbiertoDerecha() ? 1 : -1;

		return 0;
	}

//  9. Se debe poder imprimir un rango en formato cadena de caracteres.
	@Override
	public String toString() {
		return (this.abiertoIzquierda ? "(" : "[") + this.limiteInferior + ", " + this.limiteSuperior
				+ (this.abiertoDerecha ? ")" : "]");
	}

//	11. Proporcionar un método estático que devuelva un rango que abarque a todos los otros
//	rangos.
	public static Rango rangoMasAbarcativo() {
		return new Rango(Rango.getMinLimInf(), Rango.getMaxLimSup(), Rango.isMinAbiertoIzq(), Rango.isMaxAbiertoDer());
	}

//    12. Se deben poder sumar rangos, utilizando el inicio del primero y el fin del segundo.
	public static Rango sumar(Rango r1, Rango r2) {
		return new Rango(r1.limiteInferior, r2.limiteSuperior, r1.abiertoIzquierda, r2.abiertoDerecha);
	}

	public Rango sumar(Rango rango) {
		return new Rango(this.limiteInferior, rango.limiteSuperior, this.abiertoIzquierda, rango.abiertoDerecha);
	}

//	13. Se debe poder calcular un rango intersección, que en caso de no existir tal intersección
//	retornará (0.0, 0.0)
	public Rango calcularInterseccion(Rango rango) {
		if (!this.hayInterseccion(rango)) {
			return new Rango(0, 0, true, true);
		}

		double nuevoLimiteInferior = Math.max(this.getLimiteInferior(), rango.getLimiteInferior());
		double nuevoLimiteSuperior = Math.min(this.getLimiteSuperior(), rango.getLimiteSuperior());

		boolean abiertoIzquierda;
		boolean abiertoDerecha;

		if (nuevoLimiteInferior != this.getLimiteInferior())
			abiertoIzquierda = rango.isAbiertoIzquierda();
		else if (nuevoLimiteInferior != this.getLimiteInferior())
			abiertoIzquierda = this.isAbiertoIzquierda();
		else
			abiertoIzquierda = rango.isAbiertoIzquierda() || this.isAbiertoIzquierda();

		if (nuevoLimiteSuperior != this.getLimiteSuperior())
			abiertoDerecha = rango.isAbiertoDerecha();
		else if (nuevoLimiteSuperior != this.getLimiteSuperior())
			abiertoDerecha = this.isAbiertoDerecha();
		else
			abiertoDerecha = rango.isAbiertoDerecha() || this.isAbiertoDerecha();

		return new Rango(nuevoLimiteInferior, nuevoLimiteSuperior, abiertoIzquierda, abiertoDerecha);
	}

//	14. Se debe poder desplazar un rango con un número escalar.
	public Rango desplazar(double escalar) {
		return new Rango(this.limiteInferior + escalar, this.limiteSuperior + escalar, this.abiertoIzquierda,
				this.abiertoDerecha);
	}

	public double getLimiteInferior() {
		return limiteInferior;
	}

	public double getLimiteSuperior() {
		return limiteSuperior;
	}

	public boolean isAbiertoIzquierda() {
		return abiertoIzquierda;
	}

	public boolean isAbiertoDerecha() {
		return abiertoDerecha;
	}

	private static double getMinLimInf() {
		return minLimInf;
	}

	private static double getMaxLimSup() {
		return maxLimSup;
	}

	private static boolean isMinAbiertoIzq() {
		return minAbiertoIzq;
	}

	private static boolean isMaxAbiertoDer() {
		return maxAbiertoDer;
	}

	private static void setMinLimInf(double minLimInf) {
		Rango.minLimInf = minLimInf;
	}

	private static void setMaxLimSup(double maxLimSup) {
		Rango.maxLimSup = maxLimSup;
	}

	private static void setMinAbiertoIzq(boolean minAbiertoIzq) {
		Rango.minAbiertoIzq = minAbiertoIzq;
	}

	private static void setMaxAbiertoDer(boolean maxAbiertoDer) {
		Rango.maxAbiertoDer = maxAbiertoDer;
	}
}
