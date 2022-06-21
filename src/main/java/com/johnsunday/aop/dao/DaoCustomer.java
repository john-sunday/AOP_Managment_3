package com.johnsunday.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;

@Component
public class DaoCustomer {

	public void insertCustomer(Customer customer,String customerType) {
		System.out.println("Operation OK. Normal Customer inserted Successfully\n");
	}
	
	public List<Customer> findCustomer(){
		List<Customer> customers = new ArrayList<>();
		// Simulamos clientes devueltos.
		Customer c1 = new Customer("sandra","vip");
		Customer c2 = new Customer("maria","normal");
		Customer c3 = new Customer("susana","normal");
		Customer c4 = new Customer("alejandra","vip");
		Customer c5 = new Customer("rica","normal");
		Customer c6 = new Customer("petra","vip");
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		System.out.println("Execution finished/completed/terminated of findCustomer()");
		return customers;
	}
}
