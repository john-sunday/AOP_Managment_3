package com.johnsunday.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;


@Aspect
@Component
@Order(2)
public class LoginAspect {
	
	@Pointcut("execution(* com.johnsunday.aop.dao.*.*(..))")
	//private void forCustomers() {}
	// Hacemos público el nombre del pointcut 'forCustomers() para que las
	// clases que lo llaman lo pueden utilizar.
	public void forCustomers() {}
	
	@Before("forCustomers()")
									// Punto de observación/interjección
	public void beforeInsertingCustomer(JoinPoint myJoin) {
		// Vídeo 83 - Hay que acceder a los parámetros del método 
		// insertCustomer(Customer c,String type), 
		// para hacer comprobaciones
		System.out.println("The user is LOGGED IN");
		System.out.println("The profile to insert customers is CORRECT");
		// Capturamos los argumentos de método que se ejecuta a continuación.
		// (Customer c y String type)
		Object[]args = myJoin.getArgs();
		for(Object o:args) {
			if(o instanceof Customer) {
				Customer c = (Customer) o;
				System.out.println("Name customer: " + c.getName());
				System.out.println("Name customer: " + c.getType());
			}
		}
	}
	
	// Como la anotación para el orden de aspectos->@Order() sólo se puede
	// aplicar a clases, nos llevamos cada aspecto a una nueva clase.
	
	/*@Before("forCustomers()")
	public void customerRequirements() {
		System.out.println("The customer meets the requirements to be added in DB");
	}		
	@Before("forCustomers()")
	public void tableRequirements() {
		System.out.println("There are less than 3.000 records in DB. You can add the new customer.");
	}*/
}
