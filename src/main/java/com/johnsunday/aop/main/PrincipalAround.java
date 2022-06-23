package com.johnsunday.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnsunday.aop.dao.DaoCustomer;
import com.johnsunday.aop.dao.DaoVipCustomer;
import com.johnsunday.aop.services.MeasurementService;

public class PrincipalAround {

	public static void main(String[] args) {
		// Leer la configuración de Spring.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MeasurementService service = context.getBean("measurementService",MeasurementService.class);
		System.out.println("Calling to getService() method...");
		System.out.println("Method Return-> " + service.getService());
		// Cerrar el contexto
		context.close();
	}
}
