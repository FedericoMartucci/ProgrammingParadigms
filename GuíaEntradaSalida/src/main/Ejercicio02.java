package main;

public class Ejercicio02 {
	private static final String nombreArchivo = "ej02";
	private static final int LIMITE_SUPERIOR = 20000;
	private static final int LIMITE_INFERIOR = 10000;
	private static final int MAYOR_NUMERO = 12001;
	private static final int MENOR_NUMERO = 0;

	public static void resolver() {
		Archivo arch = new Archivo(Ejercicio02.nombreArchivo);
		
		arch.generarArchivoEj02(Ejercicio02.generarLote());
		
		Resultado resu = arch.leerArchivoEj02();
		
		arch.guardarArchivoEj02(resu);
	}
	
	public static int[] generarLote() {
		int lote[] = new int[(int) (Math.random() * (Ejercicio02.LIMITE_SUPERIOR - Ejercicio02.LIMITE_INFERIOR) + Ejercicio02.LIMITE_INFERIOR)];
		
		for(int i = 0; i < lote.length; i++)
			lote[i] = (int) (Math.random() * (Ejercicio02.MAYOR_NUMERO - Ejercicio02.MENOR_NUMERO) + Ejercicio02.MENOR_NUMERO);
		
		return lote;
	}
}
