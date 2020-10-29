package com.alexSpring.dao;

import com.alexSpring.po.Customer;

public interface CustomerDao {
	public Customer findCustomerById(Integer id);
}
