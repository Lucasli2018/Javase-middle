package com.lucas.gof.structure.bridge;

public class Square extends Shape{

	public Square(DrawAPI drawAPI) {
		super(drawAPI);
		this.setType("Square");
	}

	@Override
	public void draw() {
		drawAPI.draw(this);
	}

}
