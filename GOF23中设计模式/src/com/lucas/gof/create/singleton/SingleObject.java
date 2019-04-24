package com.lucas.gof.create.singleton;

public class SingleObject {
	private SingleObject(){}
	
	private static SingleObject instance=new SingleObject();
	
	public static SingleObject getInstance(){
		return instance;
	}
	public void showMessage(){
		System.out.println("Hello world!");
	}
}
