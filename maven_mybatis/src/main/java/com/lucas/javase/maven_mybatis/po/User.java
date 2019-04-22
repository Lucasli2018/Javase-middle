package com.lucas.javase.maven_mybatis.po;

public class User {
	private int id;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.username = name;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + "]";
	}
	
}
