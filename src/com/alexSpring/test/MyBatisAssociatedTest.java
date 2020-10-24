package com.alexSpring.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alexSpring.po.Person;
import com.alexSpring.utils.MyBatisUtils;

/**
 * Beginner Program Test Class
 * 
 * @author liu.zehu
 *
 */
public class MyBatisAssociatedTest {
	
	/**
	 * Nested Query
	 */
	@Test
	public void findPersonByIdTest() {
		SqlSession session = MyBatisUtils.getSession();
		Person person = session.selectOne("com.alexSpring.mapper.PersonMapper.findPersonById", 1);
		// System.out.println(person);
		// Lazy Loading Test
		System.out.println(person.getName());
		session.close();
	}
	
	/**
	 * Nested Result
	 */
	@Test
	public void findPersonById_2Test() {
		SqlSession session = MyBatisUtils.getSession();
		Person person = session.selectOne("com.alexSpring.mapper.PersonMapper.findPersonById_2", 2);
		System.out.println(person);
		session.close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) {
//	}
}
