package com.krakedev.financiero.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestPruebaDepistarIA {
	
	@Test
	public void testDepositoValido() {
	    Banco banco = new Banco();
	    Cliente c = new Cliente("123", "Juan", "Perez");
	    Cuenta cuenta = banco.crearCuenta(c);

	    boolean resultado = banco.depositar(100, cuenta);

	    assertTrue(resultado);
	    assertEquals(100, cuenta.getSaldoActual());
	}
}
