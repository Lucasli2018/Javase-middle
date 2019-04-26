package com.lucas.gof.structure.filter;

public class Person {
	private String name;
	private String sex;
	private String maritalStatus;
	public Person() {
	}
	public Person(String name, String sex, String maritalStatus) {
		super();
		this.name = name;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
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
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", maritalStatus=" + maritalStatus + "]";
	}
	
}
