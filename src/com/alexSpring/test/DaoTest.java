package com.alexSpring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alexSpring.dao.CustomerDao;
import com.alexSpring.mapper.CustomerMapper;
import com.alexSpring.po.Customer;

/**
 * Class
 * @author liu.zehu
 *
 */
public class DaoTest {
	
	/**
	 * Traditional Dao Test
	 */
	@Test
	public void findCustomerByIdDaoTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		// CustomerDao customerDao = (CustomerDao) act.getBean("customerDao");
		// Another way to obtain customerDao. No need to cast.
		CustomerDao customerDao = act.getBean(CustomerDao.class);
		Customer c = customerDao.findCustomerById(1);
		System.out.println(c);
	}
	
	/**
	 * Mapper Interface Test
	 */
	@Test
	public void findCustomerByIdMapperInterfaceTest() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerMapper customerMapper = act.getBean(CustomerMapper.class);
		Customer c = customerMapper.findCustomerById(2);
		System.out.println(c);
	}
}
