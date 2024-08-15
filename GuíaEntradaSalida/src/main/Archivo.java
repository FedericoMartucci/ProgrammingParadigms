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
	
	public int[] leerArchivoEj01() {
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
	
	public void guardarArchivoEj01(int[] datos) {
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
	public Resultado leerArchivoEj02() {
		Scanner scanner = null;
		Resultado resu = new Resultado();
		int suma;
		int dato;
		int contador = 1;
		
		try {
			File file = new File("src/main/" + this.nombre + ".in");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			
			suma = dato = scanner.nextInt();
			
			resu.setMaximo(dato);
			resu.setMinimo(dato);
			
			while(scanner.hasNextInt()) {
				dato = scanner.nextInt();
				
				if(dato > resu.getMaximo())
					resu.setMaximo(dato);
				
				if(dato < resu.getMinimo())
					resu.setMinimo(dato);

				suma += dato;
				contador ++;
			}
			
			resu.setPromedio(suma / contador);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(scanner != null)
				scanner.close();
		}
		return resu;
	}
	
	public void generarArchivoEj02(int[] datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
			file = new FileWriter("src/main/" + this.nombre + ".in");
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
	public void guardarArchivoEj02(Resultado resultado) {
		FileWriter file = null;
		PrintWriter printerWriter = null;
		
		try {
			file = new FileWriter(this.nombre + ".out");
			printerWriter = new PrintWriter(file);
			
			for(int i = 0; i < 8; i ++) {
				if(i % 2 == 0)
					printerWriter.println("+----------+-------+");
				else if(i == 1)
					printerWriter.printf("| %-8s | %5d |\n", "Máximo", resultado.getMaximo());
				else if(i == 3)
					printerWriter.printf("| %-8s | %5d |\n", "Mínimo", resultado.getMinimo());
				else if(i == 5)
					printerWriter.printf("| %-8s | %5d |\n", "Promedio", resultado.getPromedio());
					
			}
			
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
