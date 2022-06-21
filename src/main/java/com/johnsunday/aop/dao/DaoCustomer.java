package com.johnsunday.aop.dao;

import org.springframework.stereotype.Component;

import com.johnsunday.aop.main.Customer;

@Component
public class DaoCustomer {

	public void insertCustomer(Customer customer,String customerType) {
		System.out.println("Operation OK. Normal Customer inserted Successfully\n");
	}
}
