package com.krakedev.financiero.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestPruebaRetirarIA {
	@Test
	public void testTransferenciaExitosa() {
		Banco banco = new Banco();

		Cliente c1 = new Cliente("111", "Juan", "Perez");
		Cliente c2 = new Cliente("222", "Ana", "Lopez");

		Cuenta origen = banco.crearCuenta(c1);
		Cuenta destino = banco.crearCuenta(c2);

		banco.depositar(100, origen);

		boolean resultado = banco.transferir(origen, destino, 50);

		assertTrue(resultado);
		assertEquals(50, origen.getSaldoActual());
		assertEquals(50, destino.getSaldoActual());
	}

	@Test
	public void testTransferenciaSinSaldo() {
		Banco banco = new Banco();

		Cliente c1 = new Cliente("111", "Juan", "Perez");
		Cliente c2 = new Cliente("222", "Ana", "Lopez");

		Cuenta origen = banco.crearCuenta(c1);
		Cuenta destino = banco.crearCuenta(c2);

		banco.depositar(30, origen);

		boolean resultado = banco.transferir(origen, destino, 50);

		assertFalse(resultado);
		assertEquals(30, origen.getSaldoActual()); // no cambia
		assertEquals(0, destino.getSaldoActual()); // no recibe nada
	}

	@Test
	public void testTransferenciaMontoInvalido() {
		Banco banco = new Banco();

		Cliente c1 = new Cliente("111", "Juan", "Perez");
		Cliente c2 = new Cliente("222", "Ana", "Lopez");

		Cuenta origen = banco.crearCuenta(c1);
		Cuenta destino = banco.crearCuenta(c2);

		banco.depositar(100, origen);

		boolean resultado = banco.transferir(origen, destino, 0);

		assertFalse(resultado);
		assertEquals(100, origen.getSaldoActual());
		assertEquals(0, destino.getSaldoActual());
	}
}
