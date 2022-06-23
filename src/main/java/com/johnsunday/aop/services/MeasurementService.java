package com.johnsunday.aop.services;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
@Component
public class MeasurementService {

	public String getService() {
		// Simulamos que el método realiza tareas.
		System.out.println("**** THE METHOD IS PERFORMING TASKS ****");		
		try {
			// Dormimos el hilo 4 segundos, simulando tareas/procesos.
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Services Finished";
	}
}
