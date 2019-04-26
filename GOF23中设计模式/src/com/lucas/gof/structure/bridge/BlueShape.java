package com.lucas.gof.structure.bridge;

public class BlueShape implements DrawAPI {

	@Override
	public void draw(Shape shape) {
		System.out.println("Blue "+shape.getType());
	}
}
