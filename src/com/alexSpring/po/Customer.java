package com.alexSpring.po;

import java.io.Serializable;

/**
 * Persistent Class -- Customer
 * 
 * @author liu.zehu
 *
 */
public class Customer implements Serializable {
	private Integer id; // Primary Key
	private String username;
	private String jobs;
	private String phone;

	public Customer() {
		super();
	}
	
	public Customer(String username, String jobs, String phone) {
		super();
		this.username = username;
		this.jobs = jobs;
		this.phone = phone;
	}

	public Customer(Integer id, String username, String jobs, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.jobs = jobs;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUername() {
		return username;
	}

	public void setUername(String username) {
		this.username = username;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", uername=" + username + ", jobs=" + jobs + ", phone=" + phone + "]";
	}
}
