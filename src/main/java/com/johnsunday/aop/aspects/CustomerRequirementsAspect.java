package com.johnsunday.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CustomerRequirementsAspect {

	//@Before("forCustomers()")-> para usar forCustomers() desde aquí,
	// se pone la ruta completa al pointcut, además de cambiar modificador
	// de acceso a público.
	@Before("com.johnsunday.aop.aspects.LoginAspect.forCustomers()")
	public void customerRequirements() {
		System.out.println("The customer meets the requirements to be added in DB");
	}
}
