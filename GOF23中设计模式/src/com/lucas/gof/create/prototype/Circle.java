package com.lucas.gof.create.prototype;

import java.io.Serializable;

public class Circle extends Shape{
	private Circle circle;

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public void circle1(Circle circle) {
		this.circle = circle;
	}

	public Circle() {
		System.out.println("构造方法");
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw()  method.");
	}
}
