package com.alexSpring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexSpring.mapper.CustomerMapper;
import com.alexSpring.po.Customer;
import com.alexSpring.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public void addCustomer(Customer customer) {
		this.customerMapper.addCustomer(customer);
		int i = 1/0;
	}

}
