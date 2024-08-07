package main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public int[] leerArchivo() {
		Scanner scanner = null;
		int[] datos = null;
		
		try {
			File file = new File("src/main/" + this.nombre + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			int cant = scanner.nextInt();
			datos = new int[cant];
			
			for(int i = 0; i < cant; i++)
				datos[i] = scanner.nextInt();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(scanner != null)
				scanner.close();
		}
		return datos;
	}
	
	public void guardarArchivo(int[] datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
			file = new FileWriter(this.nombre + ".out");
			printerWriter = new PrintWriter(file);
			
			for(int i = 0; i < datos.length; i ++)
				printerWriter.println(datos[i]);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
