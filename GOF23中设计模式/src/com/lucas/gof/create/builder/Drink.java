package com.lucas.gof.create.builder;

public abstract class Drink implements Item{

	@Override
	public Packing packing() {
		return new Bottle();
	}

}
