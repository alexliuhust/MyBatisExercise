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
	 * primary cache test 
	 * cache in SqlSession and open by default
	 * 
	 * @throws Exception
	 */
	@Test
	public void cacheOneTest() throws Exception {
		SqlSession sqlSession = MyBatisUtils.getSession();

		// The first-time search
		Customer customer = sqlSession.selectOne("com.alexSpring.po.Customer.findCustomerById", 2);
		System.out.println(customer.toString());

		// Commit the primary cache
		// sqlSession.commit();

		// If without commit, the second-time search will access the primary cache,
		// e.i. there are two results but from one-time query
		customer = sqlSession.selectOne("com.alexSpring.po.Customer.findCustomerById", 2);
		System.out.println(customer.toString());

		sqlSession.close();
	}

	/**
	 * secondary cache test 
	 * cache in SqlSessionFactory and need to open manually
	 * The query object of the secondary cache needs to implement the serialization interface.
	 * @throws Exception
	 */
	@Test
	public void cacheTwoTest() throws Exception {
		// The first-time search
		SqlSession sqlSession = MyBatisUtils.getSession();
		Customer customer = sqlSession.selectOne("com.alexSpring.po.Customer.findCustomerById", 2);
		System.out.println(customer.toString());
		sqlSession.close();
		
		// The second-time search
		// Since the secondary cache has opened, this sqlSession is a new session
		sqlSession = MyBatisUtils.getSession();
		customer = sqlSession.selectOne("com.alexSpring.po.Customer.findCustomerById", 2);
		System.out.println(customer.toString());
		sqlSession.close();
				
	}

	/**
	 * Find Customer By Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void findCustomerByIdTest() throws Exception {
		// Build SqlSession from MyBatisUtils
		SqlSession sqlSession = MyBatisUtils.getSession();
		
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

	/**
	 * Add Customer
	 * 
	 * @throws Exception
	 */
	@Test
	public void addCustomerTest() throws Exception {
		// Read Config File
		String resource = "MyBatis-configure.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// Build SqlSessionFactory based on the config file
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// Build SqlSession from SqlSessionFactory
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession execute SQL defined in mapper
		Customer customer = new Customer("Mary", "lawyer", "16829462718");
		Customer customer1 = new Customer("1", "1", "1");
		int num = sqlSession.insert("com.alexSpring.po.Customer.addCustomer", customer1);

		if (num > 0) {
			System.out.println("Successfully inserted " + num + "row(s)!");
		} else {
			System.out.println("Failed to insert...");
		}

		// insert, delete and update process all need sqlSession.commit()
		sqlSession.commit();

		// Close SqlSession
		sqlSession.close();
	}

	/**
	 * Update Customer By Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateCustomerByIdTest() throws Exception {
		// Read Config File
		String resource = "MyBatis-configure.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// Build SqlSessionFactory based on the config file
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// Build SqlSession from SqlSessionFactory
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession execute SQL defined in mapper
		Customer customer = new Customer(2, "Thomas", "teacher", "15300002729");
		int num = sqlSession.update("com.alexSpring.po.Customer.updateCustomerById", customer);
		if (num > 0) {
			System.out.println("Successfully updated " + num + "row(s)!");
		} else {
			System.out.println("Failed to update...");
		}

		// insert, delete and update process all need sqlSession.commit()
		sqlSession.commit();

		// Close SqlSession
		sqlSession.close();
	}

	/**
	 * Delete Customer By Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteCustomerByIdTest() throws Exception {
		// Read Config File
		String resource = "MyBatis-configure.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// Build SqlSessionFactory based on the config file
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// Build SqlSession from SqlSessionFactory
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// SqlSession execute SQL defined in mapper
		int num = sqlSession.update("com.alexSpring.po.Customer.deleteCustomerById", 6);
		if (num > 0) {
			System.out.println("Successfully deleted " + num + "row(s)!");
		} else {
			System.out.println("Failed to delete...");
		}
		// insert, delete and update process all need sqlSession.commit()
		sqlSession.commit();

		// Close SqlSession
		sqlSession.close();

	}

//	public static void main(String[] args) {
//	}
}
