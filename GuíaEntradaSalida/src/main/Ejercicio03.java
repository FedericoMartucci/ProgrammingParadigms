package main;

import ejercicio03.ArchivoLuchador;
import ejercicio03.Luchador;

public class Ejercicio03 {
	public static void resolver() {
		ArchivoLuchador arch = new ArchivoLuchador("sumo");

		arch.generarLote();
		Luchador[] luchadores = arch.leerArchivo();

		for (int i = 0; i < luchadores.length - 1; i++)
			for (int j = i + 1; j < luchadores.length; j++)
				if (luchadores[i].dominaContrincante(luchadores[j]))
					luchadores[i].setCantDominados(luchadores[i].getCantDominados() + 1);
				else if (luchadores[j].dominaContrincante(luchadores[i]))
					luchadores[j].setCantDominados(luchadores[j].getCantDominados() + 1);

		arch.guardarArchivo(luchadores);
	}
}
