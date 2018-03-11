package com.am.callcenter.model;

import com.am.callcenter.service.impl.Dispatcher;

/**
 * Esta clase es la representación de un empleado a su nivel más genérico.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class Empleado implements Comparable<Empleado> {

	protected String nombre;
	protected String apellido;
	protected String cargo;
	private Dispatcher dispatcher;

	/**
	 * Parametros del constructor Empleado.
	 * 
	 * @param nombre Empleado
	 * @param apellido Empleado
	 * @param cargo Empleado
	 * @param dispatcher Empleado
	 */
	public Empleado(String nombre, String apellido, String cargo, Dispatcher dispatcher) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.dispatcher = dispatcher;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public int compareTo(Empleado o) {
		return 0;
	}

}
