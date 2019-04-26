package com.lucas.gof.structure.bridge;

public class BridgePatternDemo {
	public static void main(String[] args) {
		Shape shape1=new Circle(new RedShape());
		Shape shape2=new Circle(new BlueShape());
		
		Shape shape3=new Square(new RedShape());
		Shape shape4=new Square(new BlueShape());
		
		shape1.draw();
		shape2.draw();
		shape3.draw();
		shape4.draw();
	}
}
