package com.johnsunday.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnsunday.aop.dao.DaoCustomer;
import com.johnsunday.aop.dao.DaoVipCustomer;

public class Principal {

	public static void main(String[] args) {
		// Leer la configuración de Spring.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// Obtener el bean del contenedor de Spring.
		DaoCustomer customer = context.getBean("daoCustomer",DaoCustomer.class);
		customer.findCustomer();
		System.out.println("Here would continue the implementation of the programme");
		// Cerrar el contexto
		context.close();
	}
}
