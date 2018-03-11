package com.am.callcenter.model;

import com.am.callcenter.service.impl.Dispatcher;

/**
 * Esta clase Director representa un tipo de empleado.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class Director extends Empleado {

	/**
	 * Parametros del constructor Director
	 * 
	 * @param nombre Director
	 * @param apellido Director
	 * @param cargo Director
	 * @param dispatcher Director
	 */
	public Director(String nombre, String apellido, String cargo, Dispatcher dispatcher) {
		super(nombre, apellido, cargo, dispatcher);
	}

}
