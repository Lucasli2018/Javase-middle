package com.lucas.gof.create.abstractFactory;

public class Red implements Color{

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}

}
