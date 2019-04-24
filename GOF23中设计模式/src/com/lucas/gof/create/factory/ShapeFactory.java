package com.lucas.gof.create.factory;

public class ShapeFactory {
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
}
