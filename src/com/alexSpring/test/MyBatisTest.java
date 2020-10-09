package com.alexSpring.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.alexSpring.po.Customer;

/**
 * Beginner Program Test Class
 * 
 * @author liu.zehu
 *
 */
public class MyBatisTest {

	/**
	 * Find Customer By Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCustomerByIdTest() throws Exception {
		// Read Config File
		String resource = "MyBatis-configure.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// Build SqlSessionFactory based on the config file
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// Build SqlSession from SqlSessionFactory
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession execute SQL defined in mapper
		Customer customer = sqlSession.selectOne("com.alexSpring.po.Customer.findCustomerById", 2);

		System.out.println(customer.toString());

		// Close SqlSession
		sqlSession.close();
	}

	/**
	 * Find Customer By user name
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCustomerByIdNameTest() throws Exception {
		// Read Config File
		String resource = "MyBatis-configure.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// Build SqlSessionFactory based on the config file
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// Build SqlSession from SqlSessionFactory
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession execute SQL defined in mapper
		List<Customer> customers = sqlSession.selectList("com.alexSpring.po.Customer.findCustomerByName", "o'");
		for (Customer c : customers)
			System.out.println(c.toString());

		// Close SqlSession
		sqlSession.close();
	}

//	public static void main(String[] args) {
//	}

}























