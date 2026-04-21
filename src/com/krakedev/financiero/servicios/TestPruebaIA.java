package com.krakedev.financiero.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class TestPruebaIA {
	@Test
    public void testCrearCuentasConsecutivas() {

        Banco banco = new Banco();

        Cliente c1 = new Cliente("111", "Juan", "Perez");
        Cliente c2 = new Cliente("222", "Ana", "Lopez");
        Cliente c3 = new Cliente("333", "Luis", "Gomez");

        Cuenta cuenta1 = banco.crearCuenta(c1);
        Cuenta cuenta2 = banco.crearCuenta(c2);
        Cuenta cuenta3 = banco.crearCuenta(c3);

        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());
        assertEquals("1002", cuenta3.getId());
    }
}
