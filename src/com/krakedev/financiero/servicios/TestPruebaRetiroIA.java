package com.krakedev.financiero.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestPruebaRetiroIA {
	  @Test
	    public void testRetiroValido() {
	        Banco banco = new Banco();
	        Cliente c = new Cliente("123", "Juan", "Perez");
	        Cuenta cuenta = banco.crearCuenta(c);

	        banco.depositar(100, cuenta);
	        boolean resultado = banco.retirar(50, cuenta);

	        assertTrue(resultado);
	        assertEquals(50, cuenta.getSaldoActual());
	    }

	    @Test
	    public void testRetiroExcedeSaldo() {
	        Banco banco = new Banco();
	        Cliente c = new Cliente("123", "Juan", "Perez");
	        Cuenta cuenta = banco.crearCuenta(c);

	        banco.depositar(100, cuenta);
	        boolean resultado = banco.retirar(150, cuenta);

	        assertFalse(resultado);
	        assertEquals(100, cuenta.getSaldoActual()); // no cambia
	    }

	    @Test
	    public void testRetiroCero() {
	        Banco banco = new Banco();
	        Cliente c = new Cliente("123", "Juan", "Perez");
	        Cuenta cuenta = banco.crearCuenta(c);

	        banco.depositar(100, cuenta);
	        boolean resultado = banco.retirar(0, cuenta);

	        assertFalse(resultado);
	        assertEquals(100, cuenta.getSaldoActual());
	    }

	    @Test
	    public void testRetiroNegativo() {
	        Banco banco = new Banco();
	        Cliente c = new Cliente("123", "Juan", "Perez");
	        Cuenta cuenta = banco.crearCuenta(c);

	        banco.depositar(100, cuenta);
	        boolean resultado = banco.retirar(-10, cuenta);

	        assertFalse(resultado);
	        assertEquals(100, cuenta.getSaldoActual());
	    }
}
