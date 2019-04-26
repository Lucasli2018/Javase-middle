package com.lucas.gof.create.builder;

public abstract class Burger implements Item{

	@Override
	public Packing packing() {
		return new Wrapper();
	}
	
}
