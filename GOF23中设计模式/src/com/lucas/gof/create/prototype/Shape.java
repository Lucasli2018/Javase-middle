package com.lucas.gof.create.prototype;

public abstract class Shape implements Cloneable {
	private String id;
	protected String type;
	public Shape() {
		type="Shape";
	}

	abstract void draw();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Object clone() {
		Object clone=null;
		try {
			clone= super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	@Override
	public String toString() {
		return "Shape [id=" + id + ", type=" + type + "]";
	}

}
