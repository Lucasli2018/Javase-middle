package com.lucas.gof.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Square extends Shape implements Serializable{
	private Square square; 
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw()  method.");
	}

	@Override
	protected Object clone() {
		Object clone = null;
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream(baos);
	        oos.writeObject(this);
	        
	        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clone=ois.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		return clone;
	}
	

}
