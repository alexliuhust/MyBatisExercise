package com.alexSpring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alexSpring.po.Customer;
import com.alexSpring.service.CustomerService;

public class TransactionTest {

	@Test
	public void transactionTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = act.getBean(CustomerService.class);
		Customer customer = new Customer();
		customer.setUsername("Niubee");
		customer.setJobs("Killer");
		customer.setPhone("18203839271");
		customerService.addCustomer(customer);
	}
}
