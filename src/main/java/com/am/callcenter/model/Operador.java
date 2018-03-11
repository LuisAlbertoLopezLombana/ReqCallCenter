package com.am.callcenter.model;

import com.am.callcenter.service.impl.Dispatcher;

/**
 * Esta clase Operador representa un tipo de empleado.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class Operador extends Empleado {

	/**
	 * Parametros del constructor Operador
	 * 
	 * @param nombre Operador
	 * @param apellido Operador
	 * @param cargo Operador
	 * @param dispatcher Operador
	 */
	public Operador(String nombre, String apellido, String cargo, Dispatcher dispatcher) {
		super(nombre, apellido, cargo, dispatcher);
	}

}