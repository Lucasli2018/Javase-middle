package com.lucas.gof.structure.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", "Male", "Single"));
		persons.add(new Person("John", "Male", "Married"));
		persons.add(new Person("Laura", "Female", "Married"));
		persons.add(new Person("Diana", "Female", "Single"));
		persons.add(new Person("Mike", "Male", "Single"));
		persons.add(new Person("Bobby", "Male", "Single"));
		
		//System.out.println(persons);

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		Criteria singleMale = new AndCriteria(single, male);
		Criteria singleFemale = new AndCriteria(single, female);
		Criteria singleOrFemale = new OrCriteria(single, female);

		System.out.println("Males:");
		System.out.println(male.meetCriteria(persons));

		System.out.println("\nFemale:");
		System.out.println(female.meetCriteria(persons));

		System.out.println("\nSingle:");
		System.out.println(single.meetCriteria(persons));

		System.out.println("\nSingle Males:");
		System.out.println(singleMale.meetCriteria(persons));
		
		System.out.println("\nSingle Females:");
		System.out.println(singleFemale.meetCriteria(persons));

	}
}
