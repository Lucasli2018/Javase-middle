package com.lucas.gof.create.prototype;

import org.junit.Test;

public class PrototypePatternDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		//testDeepClone();
		testShadowClone();
	}
	
	public void test(){
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println(clonedShape);
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println(clonedShape2);
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println(clonedShape3);
		System.out.println("Shape : " + clonedShape3.getType());
	}

	public static void testShadowClone() {
		Circle shape = new Circle();
		shape.setType("shape");

		Circle circle1 = new Circle();
		circle1.setType("circle1");

		shape.setCircle(circle1);

		System.out.println(shape.getType() + ":" + System.identityHashCode(shape));
		System.out.println(shape.getCircle().getType() + ":" + System.identityHashCode(shape.getCircle()));

		// clone
		Circle shapeClone = (Circle) shape.clone();

		System.out.println(shapeClone.getType() + ":" + System.identityHashCode(shapeClone));
		System.out.println(shapeClone.getCircle().getType() + ":" + System.identityHashCode(shapeClone.getCircle()));

		// 浅克隆：修改引用类型数据，会对原始对象产生影响！
		shapeClone.getCircle().setType("circle2");
		System.out.println("修改后对象"+shapeClone.getCircle().getType()+":"+System.identityHashCode(shapeClone.getCircle()));
		System.out.println(
				"修改克隆对象后，原始对象---->" + shape.getCircle().getType() + ":" + System.identityHashCode(shape.getCircle()));
		System.out.println("===============================");
	}

	public static void testDeepClone() {
		Square shape = new Square();
		shape.setType("shape");

		Square circle1 = new Square();
		circle1.setType("Square1");

		shape.setSquare(circle1);

		System.out.println(shape.getType() + ":" + System.identityHashCode(shape));
		System.out.println(shape.getSquare().getType() + ":" + System.identityHashCode(shape.getSquare()));

		// clone
		Square shapeClone = (Square) shape.clone();

		System.out.println(shapeClone.getType() + ":" + System.identityHashCode(shapeClone));
		System.out.println(shapeClone.getSquare().getType() + ":" + System.identityHashCode(shapeClone.getSquare()));

		// 深克隆：修改引用类型数据，也不会对原始对象产生影响！
		shapeClone.getSquare().setType("Square2");
		System.out.println("修改后对象"+shapeClone.getSquare().getType()+":"+System.identityHashCode(shapeClone.getSquare()));
		System.out.println(
				"修改克隆对象后，原始对象---->" + shape.getSquare().getType() + ":" + System.identityHashCode(shape.getSquare()));
		
		System.out.println("===============================");
	}
}
