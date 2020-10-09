package com.alexSpring.po;

/**
 * Persistent Class -- Customer
 * 
 * @author liu.zehu
 *
 */
public class Customer {
	private Integer id; // Primary Key
	private String uername;
	private String jobs;
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUername() {
		return uername;
	}

	public void setUername(String uername) {
		this.uername = uername;
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
		return "Customer [id=" + id + ", uername=" + uername + ", jobs=" + jobs + ", phone=" + phone + "]";
	}
}
