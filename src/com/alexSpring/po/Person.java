package com.alexSpring.po;

public class Person {
	
	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private IdCard card;
	
	public Person() {}
	public Person(String name, Integer age, String sex, IdCard card) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.card = card;
	}
	public Person(Integer id, String name, Integer age, String sex, IdCard card) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.card = card;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public IdCard getIdCard() {
		return card;
	}
	public void setIdCard(IdCard card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", card=" + card + "]";
	}
	
	
}
