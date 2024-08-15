package ejercicio03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArchivoLuchador {
	private String nombre;
	private static final int L_MIN = 1;
	private static final int L_MAX = 100_000;
	private static final int PH_MIN = 0;
	private static final int PH_MAX = 1_000_000;

	public ArchivoLuchador(String nombre) {
		this.nombre = nombre;
	}

	public void generarLote() {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("src/main/" + this.nombre + ".in");
			printerWriter = new PrintWriter(file);
			int cantLuchadores = (int) (Math.random() * (ArchivoLuchador.L_MAX + ArchivoLuchador.L_MIN)
					- ArchivoLuchador.L_MIN);

			printerWriter.println(cantLuchadores);
			for (int i = 0; i < cantLuchadores; i++)
				printerWriter.println((int) (Math.random() * (ArchivoLuchador.PH_MAX + ArchivoLuchador.PH_MIN)
						- ArchivoLuchador.PH_MIN) + " "
						+ (int) (Math.random() * (ArchivoLuchador.PH_MAX + ArchivoLuchador.PH_MIN)
								- ArchivoLuchador.PH_MIN));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Luchador[] leerArchivo() {
		Scanner sc = null;
		Luchador[] luchadores = null;

		try {
			File arch = new File("src/main/" + this.nombre + ".in");
			sc = new Scanner(arch);

			luchadores = new Luchador[sc.nextInt()];
			for (int i = 0; i < luchadores.length; i++)
				luchadores[i] = new Luchador(sc.nextInt(), sc.nextInt());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return luchadores;
	}

	public void guardarArchivo(Luchador[] luchadorDominante) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter(this.nombre + ".out");
			printerWriter = new PrintWriter(file);

			for (int i = 0; i < luchadorDominante.length; i++)
				printerWriter.println(luchadorDominante[i].getCantDominados());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
