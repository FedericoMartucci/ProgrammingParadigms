package objetos.ejercicio05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TarjetaBajaTest {

	@Test
	public void crearTarjetaBaja() {
		TarjetaBaja t = new TarjetaBaja(100);
		
		assertNotNull(t);
		assertEquals(0, t.contarViajesEnColectivo());
		assertEquals(0, t.contarViajesEnSubte());
		assertEquals(100, t.obtenerSaldo());
	}

	@Test
	public void cargarSaldoATarjeta() {
		int saldoInicial = 100;
		int saldoACargar = 100;
		TarjetaBaja t = new TarjetaBaja(saldoInicial);
		
		assertNotNull(t);
		assertEquals(saldoInicial, t.obtenerSaldo());
		
		t.cargar(saldoACargar);
		assertEquals(saldoInicial + saldoACargar, t.obtenerSaldo());
	}
	
	@Test
	public void pagarViajeColectivoConTarjeta() {
		int saldoInicial = 100;
		TarjetaBaja t = new TarjetaBaja(saldoInicial);
		
		assertNotNull(t);
		assertEquals(saldoInicial, t.obtenerSaldo());
		
		t.pagarViajeEnColectivo();
		assertEquals(saldoInicial - 39.59, t.obtenerSaldo());
		assertEquals(1, t.contarViajesEnColectivo());
	}
	
	@Test
	public void pagarViajeSubteConTarjeta() {
		int saldoInicial = 100;
		TarjetaBaja t = new TarjetaBaja(saldoInicial);
		
		assertNotNull(t);
		assertEquals(saldoInicial, t.obtenerSaldo());
		
		t.pagarViajeEnSubte();
		assertEquals(saldoInicial - 34.50, t.obtenerSaldo());
		assertEquals(1, t.contarViajesEnSubte());
	}
	

	@Test
	public void pagarViajeSubteYColectivoConTarjeta() {
		float saldoActual = 100;

		TarjetaBaja t = new TarjetaBaja(saldoActual);
		
		assertNotNull(t);
		assertEquals(saldoActual, t.obtenerSaldo());
		
		t.pagarViajeEnSubte();
//		saldoActual -= 34.50; No lo hago asi porque falla en la precision
		assertEquals(saldoActual - 34.50, t.obtenerSaldo());
		assertEquals(1, t.contarViajesEnSubte());
		
		t.pagarViajeEnColectivo();
//		saldoActual -= 39.59; No lo hago asi porque falla en la precision
		assertEquals(saldoActual - 34.50 - 39.59, t.obtenerSaldo());
		assertEquals(1, t.contarViajesEnColectivo());
		
		assertEquals(2, t.contarViajes());
	}
	
}
