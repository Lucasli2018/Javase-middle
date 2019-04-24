package com.lucas.gof.create.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		
		Shape shape1=shapeFactory.getShape("cirCle");
		shape1.draw();
		
		Shape shape2=shapeFactory.getShape("square");
		shape2.draw();
		
		Shape shape3=shapeFactory.getShape("RECTANGLE");
		shape3.draw();
	}

}
