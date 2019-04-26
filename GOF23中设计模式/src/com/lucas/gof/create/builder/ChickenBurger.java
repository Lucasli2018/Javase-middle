package com.lucas.gof.create.builder;

public class ChickenBurger extends Burger{

	@Override
	public String name() {
		return "ChickenBurger";
	}

	@Override
	public float price() {
		return 55.0f;
	}

}
