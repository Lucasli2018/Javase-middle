package com.lucas.gof.structure.bridge;

public class RedShape implements DrawAPI{

	@Override
	public void draw(Shape shape) {
		System.out.println("Red "+shape.getType());
	}

}
