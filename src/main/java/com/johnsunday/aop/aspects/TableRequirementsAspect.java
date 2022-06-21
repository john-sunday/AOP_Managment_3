package com.johnsunday.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class TableRequirementsAspect {

	//@Before("forCustomers()")
	@Before("com.johnsunday.aop.aspects.LoginAspect.forCustomers()")
	public void tableRequirements() {
		System.out.println("There are less than 3.000 records in DB. You can add the new customer.");
	}
}
