package com.lucas.gof.create.abstractFactory;

public class ShapeFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType){
		if(shapeType==null){
			return null;
		}
		if("circle".equalsIgnoreCase(shapeType)){
			return new Circle();
		}else if("square".equalsIgnoreCase(shapeType)){
			return new Square();
		}else if("rectangle".equalsIgnoreCase(shapeType)){
			return new Rectangle();
		}
		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}
}
