package com.am.callcenter.service.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

import com.am.callcenter.model.Empleado;
import com.am.callcenter.model.LLamada;

/**
 * La clase DispatcherRunnable implementa la interfaz Runnable para el llamado
 * del método de ejecución run. Es la clase encargada de atender las llamadas
 * una vez se inicie el hilo de ejecución.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class DispatcherRunnable implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(DispatcherRunnable.class);

	private BlockingQueue<LLamada> llamadasQueue;
	private Dispatcher dispatcher;
	private BlockingQueue<Empleado> empleadosQueue;

	/**
	 * Parametros del constructor DispatcherRunnable.
	 * 
	 * @param dispatcher Objeto perteneciente a la clase Dispatcher
	 * @param empleadosQueue Objeto perteneciente a la interface BlockingQueue
	 * @param llamadasQueue  Objeto perteneciente a la interface BlockingQueue
	 */
	public DispatcherRunnable(Dispatcher dispatcher, BlockingQueue<Empleado> empleadosQueue,
			BlockingQueue<LLamada> llamadasQueue) {
		this.dispatcher = dispatcher;
		this.empleadosQueue = empleadosQueue;
		this.llamadasQueue = llamadasQueue;
	}

	/**
	 * Sobreescritura del método run de la interfaz Runnable.
	 * 
	 * Dentro del bloque del método se ejecuta la atención de las llamadas. El
	 * proceso se mantendrá en ejecución mientras exista llamadas por atender, de lo
	 * contrario culminará su proceso por defecto.
	 * 
	 * De existir un error dentro del bloque del método run, lanzará la excepción
	 * InterruptedException.
	 * 
	 * Para las colas (Queue) el método take(), recupera y elimina el encabezado de
	 * esta cola, esperando si es necesario hasta que un elemento esté disponible.
	 * 
	 */
	@Override
	public void run() {
		LLamada llamada;
		Empleado empleado;

		try {
			while (!llamadasQueue.isEmpty()) {
				llamada = llamadasQueue.take();
				LOGGER.info("Llamada número " + llamada.getNumero() + " en espera");
				empleado = empleadosQueue.take();
				LOGGER.info("La llamada número " + llamada.getNumero() + " será atendida por el " + empleado.getCargo()
						+ " " + empleado.getNombre());
				int duracion = ThreadLocalRandom.current().nextInt(llamada.getDuracionMin(),
						llamada.getDuracionMax() + 1) * 1000;
				Thread.sleep(duracion);
				dispatcher.adicionarEmpleado(empleado);
				llamada.setDuracion(duracion);
				LOGGER.info("Finalización de llamada " + llamada.getNumero() + ". Tiempo de duracion: "
						+ llamada.getDuracion() / 1000 + " segundos");
			}
		} catch (InterruptedException e) {
			LOGGER.error("Interrupción!", e);
			Thread.currentThread().interrupt();
		}

	}

}
