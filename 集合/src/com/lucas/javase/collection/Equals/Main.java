package com.lucas.javase.collection.Equals;


import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Ming", 12));
		
		list.add(new Person("Hong", 15));
		list.add(new Person("Jun", 18));
		list.add(new Person(null, 18));
		System.out.println(list);
		System.out.println(list.contains(new Person(null, 18)));
	}

}
