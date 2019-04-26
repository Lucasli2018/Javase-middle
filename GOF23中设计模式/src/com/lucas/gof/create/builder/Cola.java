package com.lucas.gof.create.builder;

public class Cola extends Drink{

	@Override
	public String name() {
		return "Cola";
	}

	@Override
	public float price() {
		return 30.0f;
	}

}
