package com.lucas.gof.create.builder;

public class Pepsi extends Drink{

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 35.0f;
	}

}
