package com.am.callcenter.model;

/**
 * Esta clase representa los atributos necesarios que compone una llamada.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class LLamada {

	private long duracion;
	private int numero;
	private int duracionMin;
	private int duracionMax;

	public LLamada(int numero) {
		this.numero = numero;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDuracionMin() {
		return duracionMin;
	}

	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	public int getDuracionMax() {
		return duracionMax;
	}

	public void setDuracionMax(int duracionMax) {
		this.duracionMax = duracionMax;
	}

}
