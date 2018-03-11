package com.am.callcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal SpringBoot. Entrada al sistema para la ejecución de los
 * procesos necesarios. Para este proyecto, la ejecución de pruebas se realiza a
 * través del paquete test.java.com.am.callcenter
 * 
 * @author Luis Alberto López Lombana
 *
 */
@SpringBootApplication
public class CallcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallcenterApplication.class, args);
	}
}
