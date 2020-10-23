package com.alexSpring.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alexSpring.po.Customer;
import com.alexSpring.utils.MyBatisUtils;

/**
 * Beginner Program Test Class
 * 
 * @author liu.zehu
 *
 */
public class MyBatisTest {

	/**
	 * Find customers by name and jobs (composite search)
	 * 
	 */
	@Test
	public void findCustomerByNameAndJobsTest() {
		SqlSession session = MyBatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("Jack");
		customer.setJobs("worker");
		List<Customer> customers = session.selectList("com.alexSpring.mapper.CustomerMapper.findCustomerByNameAndJobs",
				customer);
		for (Customer c : customers) {
			System.out.println(c);
		}
		session.close();
	}
	
	/**
	 * Find customers by name or jobs (composite search)
	 * 
	 */
	@Test
	public void findCustomerByNameOrJobsTest() {
		SqlSession session = MyBatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("Jack");
		customer.setJobs("worker");
		List<Customer> customers = session.selectList("com.alexSpring.mapper.CustomerMapper.findCustomerByNameOrJobs",
				customer);
		for (Customer c : customers) {
			System.out.println(c);
		}
		session.close();
	}
	
	/**
	 * Update selected customer
	 * 
	 */
	@Test
	public void updateCustomerByIdTest() {
		SqlSession session = MyBatisUtils.getSession();
		Customer customer = new Customer();
		customer.setId(7);
		customer.setUsername("McNorden");
		customer.setJobs("programmer");
		customer.setPhone("12390274922");
		int num = session.update("com.alexSpring.mapper.CustomerMapper.updateCustomer", customer);
		if (num == 1) System.out.println("Successfully Updated 1 Customer!");
		else if (num == 0) System.out.println("Failed to Update...");
		session.commit();
		session.close();
	}
	
	/**
	 * Find customers by ids
	 * 
	 */
	@Test
	public void findCustomersByIdsTest() {
		SqlSession session = MyBatisUtils.getSession();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<Customer> customers = session.selectList("com.alexSpring.mapper.CustomerMapper.findCustomersByIds", list);
		for (Customer c : customers) {
			System.out.println(c);
		}
		session.close();
	}
	
	/**
	 * Find customers by name
	 * 
	 */
	@Test 
	public void findCustomersByNameTest() {
		SqlSession session = MyBatisUtils.getSession();
		Customer customer = new Customer();
		customer.setUsername("m");
		List<Customer> customers = session.selectList("com.alexSpring.mapper.CustomerMapper.findCustomerByName", customer);
		for (Customer c : customers) {
			System.out.println(c);
		}
		session.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//	}
}
