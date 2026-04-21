package com.krakedev.financiero.servicios;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;

public class Banco {
	
	private int ultimoCodigo = 1000;

	public Banco() {
		super();
	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	public Cuenta crearCuenta (Cliente cliente) {
		
		// 1. Convertir el código a String
	    String codigoStr = ultimoCodigo + "";

	    // 2. Incrementar el código
	    ultimoCodigo++;

	    // 3. Crear la cuenta
	    Cuenta cuenta = new Cuenta(codigoStr);

	    // 4. Asignar el cliente
	    cuenta.setPropietario(cliente);

	    // 5. Retornar la cuenta
	    return cuenta;
	}
	
	public boolean depositar (double monto, Cuenta cuenta) {
		if (monto > 0) {
			double nuevoSaldo = cuenta.getSaldoActual() + monto;
			cuenta.setSaldoActual(nuevoSaldo);
			return true;
		}else {
			return false;
		}
	}
}
