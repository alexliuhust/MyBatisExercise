package com.alexSpring.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
//		customer.setUsername("Jack");
//		customer.setJobs("worker");
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
//		customer.setUsername("Jack");
//		customer.setJobs("worker");
		List<Customer> customers = session.selectList("com.alexSpring.mapper.CustomerMapper.findCustomerByNameOrJobs",
				customer);
		for (Customer c : customers) {
			System.out.println(c);
		}
		session.close();
	}

//	public static void main(String[] args) {
//	}
}
