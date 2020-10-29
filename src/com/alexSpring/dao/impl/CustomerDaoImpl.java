package com.alexSpring.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.alexSpring.dao.CustomerDao;
import com.alexSpring.po.Customer;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {

	/**
	 * Find Customer By Id
	 */
	@Override
	public Customer findCustomerById(Integer id) {
		return this.getSqlSession().selectOne("com.alexSpring.po.CustomerMapper.findCustomerById", id);
	}

}
