package com.am.callcenter.model;

import com.am.callcenter.service.impl.Dispatcher;

/**
 * Esta clase Supervisor representa un tipo de empleado.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class Supervisor extends Empleado {

	/**
	 * Parametros del constructor Supervisor
	 * 
	 * @param nombre Supervisor
	 * @param apellido Supervisor
	 * @param cargo Supervisor
	 * @param dispatcher Supervisor
	 */
	public Supervisor(String nombre, String apellido, String cargo, Dispatcher dispatcher) {
		super(nombre, apellido, cargo, dispatcher);
	}

}