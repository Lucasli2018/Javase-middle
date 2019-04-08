package com.lucas.javase.jdbc.demo;

public class Person {
	int id;//不声明权限修饰符，默认为default权限,package内可以访问
	private String name;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
}
