package com.johnsunday.aop.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@AfterReturning(pointcut="execution(* com.johnsunday.aop.dao.DaoCustomer.findCustomer(..))",returning="ctmsList")	
	public void taskAfterFindCustomers(List<Customer>ctmsList) {
		for(Customer c:ctmsList) {
			if(c.getType().equalsIgnoreCase("vip")) {
				processDataAfterReturning(ctmsList);
				System.out.println("There are VIP customer in the list -> " + c.getName());
			}				
		}
	}
	
	private void processDataAfterReturning(List<Customer> ctmsList) {
		for(Customer c:ctmsList) {
			String processedData = c.getName().toUpperCase();
			c.setName(processedData);
		}
	}
	
	@AfterThrowing(pointcut="execution(* com.johnsunday.aop.dao.DaoCustomer.findCustomer(..))",throwing="TheException")
	public void processingDataAfterExceptionFindCustomers(Throwable TheException) {
		System.out.println("Here the tasks would be automatically executed after the exception");
	}
	
	@After("execution(* com.johnsunday.aop.dao.DaoCustomer.findCustomer(..))")
	public void runningTasksWithWithoutException(JoinPoint joinPoint) {
		System.out.println("Running tasks always !!!");
	}
	
	// Método que se ejecuta antes y después(realizando tareas de
	// pre-procesado y post-procesado) del método getService() de la 
	// clase MeasurementService.
	@Around("execution(* com.johnsunday.aop.services.*.getService(..))")
	public Object runService(ProceedingJoinPoint point) throws Throwable {
		System.out.println("----- Tasks BEFORE calling -> pre-processing ------");
		long start = System.currentTimeMillis();
		Object result = point.proceed(); // 'point' apunta al método destino-->getService()
		System.out.println("----- Tasks AFTER calling -> post-processing ------");
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("Dutation method = " + duration/1000 + " seconds");
		return result;
	}

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
				System.out.println("Type customer: " + c.getType());
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
