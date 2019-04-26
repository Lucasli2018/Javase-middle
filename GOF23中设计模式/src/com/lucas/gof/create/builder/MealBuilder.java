package com.lucas.gof.create.builder;

public class MealBuilder {
	public Meal prepareVegMeal(){
		Meal meal=new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Cola());
		return meal;
	}
	public Meal prepareNonVegMeal(){
		Meal meal=new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
