package com.am.callcenter.service.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.log4j.Logger;

import com.am.callcenter.model.Empleado;
import com.am.callcenter.model.LLamada;

/**
 * Esta clase Dispatcher ejecuta procesos multi tarea de acuerdo al número de
 * llamadas entrantes.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class Dispatcher {

	private static final Logger LOGGER = Logger.getLogger(Dispatcher.class);
	private BlockingQueue<Empleado> empleadosQueue;
	private BlockingQueue<LLamada> llamadasQueue;

	public Dispatcher() {
		empleadosQueue = new PriorityBlockingQueue<>();
		llamadasQueue = new LinkedBlockingQueue<>();
	}

	/**
	 * Método encargado de establecer un nuevo hilo de ejecución por cada llamada
	 * entrante pasando previamente los parametros a la clase DispatcherRunnable.
	 * 
	 * InterruptedException es lanzada en el bloque del método cuando un hilo se encuentra en un estado ocupado.
	 * 
	 * @param llamada Objeto tipo llamada
	 * 
	 */
	public void dispatchCall(LLamada llamada) {
		try {
			this.llamadasQueue.put(llamada);
		} catch (InterruptedException e) {
			LOGGER.error("Interrupción!", e);
			Thread.currentThread().interrupt();
		}
		Runnable atencionLlamada = new DispatcherRunnable(this, empleadosQueue, llamadasQueue);
		new Thread(atencionLlamada).start();
	}

	/**
	 * Método encargado de poblar la cola de empleados con el fin de determinar la
	 * disponibilidad.
	 * 
	 * @param empleado
	 *            Objeto del empledo a adicionar en la cola.
	 */
	public void adicionarEmpleado(Empleado empleado) {
		this.empleadosQueue.add(empleado);
	}

	public BlockingQueue<Empleado> getEmpleadosQueue() {
		return empleadosQueue;
	}

	/**
	 * Método generado para la asignacion de objeto tipo BlockingQueue
	 * 
	 * @param empleadosQueue Objeto perteneciente a la interface BlockingQueue
	 */
	public void setEmpleadosQueue(BlockingQueue<Empleado> empleadosQueue) {
		this.empleadosQueue = empleadosQueue;
	}

	public BlockingQueue<LLamada> getLlamadasQueue() {
		return llamadasQueue;
	}

	/**
	 * Método encargado de poblar la cola de llamadas con el fin de ser atendidas.
	 * 
	 * @param llamadasQueue Objeto perteneciente a la interface BlockingQueue
	 */
	public void setLlamadasQueue(BlockingQueue<LLamada> llamadasQueue) {
		this.llamadasQueue = llamadasQueue;
	}

}