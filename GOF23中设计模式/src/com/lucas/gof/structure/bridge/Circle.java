package com.lucas.gof.structure.bridge;

public class Circle extends Shape{

	public Circle(DrawAPI drawAPI) {
		super(drawAPI);
		this.setType("Circle");
	}

	@Override
	public void draw() {
		drawAPI.draw(this);
	}

}
