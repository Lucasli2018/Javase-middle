package com.lucas.gof.create.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		MealBuilder mealBuilder=new MealBuilder();
		Meal meal1=mealBuilder.prepareVegMeal();
		System.out.println("Veg Meal");
		meal1.showItems();
		System.out.println("Total Cost: "+meal1.getCost());
		System.out.println("====================================");
		Meal meal2=mealBuilder.prepareNonVegMeal();
		System.out.println("\nNon-Veg Meal");
		meal2.showItems();
		System.out.println("Total Cost: "+meal2.getCost());
	}

}
