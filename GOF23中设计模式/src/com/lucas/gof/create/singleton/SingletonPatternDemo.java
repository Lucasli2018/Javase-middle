package com.lucas.gof.create.singleton;

public class SingletonPatternDemo {

	//java设计模式学习地址
	//https://www.yiibai.com/design_pattern/singleton_pattern.html
	
	public static void main(String[] args) {
		SingleObject obj=SingleObject.getInstance();
		obj.showMessage();
	}

}
