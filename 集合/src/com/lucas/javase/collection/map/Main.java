package com.lucas.javase.collection.map;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("Ming", 12),new Person("Ming", 12), new Person("Hong", 15), new Person("Jun", 18));
		Map<String, Person> map = new HashMap<>();
		for (Person p : list) {
			map.put(p.getName(), p);
		}
		System.out.println(map.get("Jun"));
		System.out.println(map.get("Mark"));
		System.out.println(map.keySet().size());//自动去重
	}

}
