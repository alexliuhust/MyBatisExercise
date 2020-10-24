package com.alexSpring.po;

public class IdCard {

	private Integer id;
	private String code;
	
	
	public IdCard() {
		super();
	}
	public IdCard(String code) {
		super();
		this.code = code;
	}
	public IdCard(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "IdCard [id=" + id + ", code=" + code + "]";
	}
	
	
}
