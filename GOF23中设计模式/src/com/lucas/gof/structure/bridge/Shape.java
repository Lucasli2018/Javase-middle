package com.lucas.gof.structure.bridge;

public abstract class Shape {
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	protected DrawAPI drawAPI;
	public Shape(DrawAPI drawAPI) {
		this.drawAPI=drawAPI;
	}
	
	public abstract void draw();
}
