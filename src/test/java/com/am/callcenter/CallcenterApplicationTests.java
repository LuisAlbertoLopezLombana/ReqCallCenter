package com.am.callcenter;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.am.callcenter.model.Director;
import com.am.callcenter.model.LLamada;
import com.am.callcenter.model.Operador;
import com.am.callcenter.model.Supervisor;
import com.am.callcenter.service.impl.Dispatcher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Clase encargada de la ejecución de pruebas.
 * 
 * @author Luis Alberto López Lombana
 *
 */
public class CallcenterApplicationTests extends TestCase {
	private static final Logger LOGGER = Logger.getLogger(CallcenterApplicationTests.class);

	public static Test suite() {
		return new TestSuite(CallcenterApplicationTests.class);
	}

	/**
	 * Ejecución de test correspondiente a 10 llamadas concurrentes.
	 */
	public void testLlamadas() {

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.adicionarEmpleado(new Operador("Gabriel", "Sierra", "Operador", dispatcher));
		dispatcher.adicionarEmpleado(new Supervisor("Cristian", "López", "Supervisor", dispatcher));
		dispatcher.adicionarEmpleado(new Supervisor("Linda", "López", "Supervisor", dispatcher));
		dispatcher.adicionarEmpleado(new Director("Laura", "Bolivar", "Director", dispatcher));
		dispatcher.adicionarEmpleado(new Director("Luis", "López", "Director", dispatcher));

		int duracionMaxTotal = 0;

		for (int i = 1; i <= 10; i++) {
			LLamada llamada = new LLamada(i);
			llamada.setDuracionMin(5);
			llamada.setDuracionMax(10);
			duracionMaxTotal += llamada.getDuracionMax();
			LOGGER.info("Ingresando número de llamada " + llamada.getNumero());
			dispatcher.dispatchCall(llamada);

		}
		LOGGER.info("Duración máxima del total de llamadas " + duracionMaxTotal + " segundos");
		/*
		 * A partir de la sumatoria de la cantidad máxima de duración de todas las
		 * llamadas, se determina el tiempo de espera del hilo principal. Esto con el
		 * fin de permitir a las demás tareas culminar el proceso antes de que este
		 * (hilo principal) culmine.
		 */
		try {
			TimeUnit.SECONDS.sleep(duracionMaxTotal);
		} catch (InterruptedException e) {
			LOGGER.error("Interrupción!", e);
			Thread.currentThread().interrupt();
		}
		assertTrue(dispatcher.getLlamadasQueue().isEmpty());

	}

}
