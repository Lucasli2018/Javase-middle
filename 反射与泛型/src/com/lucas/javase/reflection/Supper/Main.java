package com.lucas.javase.reflection.Supper;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Pair<Integer> p = new Pair<>(0, 0);
		set(p, 123, 456);
		System.out.println(p);
		Pair<Number> n = new Pair<>(1.2, 3.4);
		set(n, 99, 88);
		System.out.println(n);
		
		List<Number> list=new ArrayList<>();
		someMethod(list);
	}

	static void set(Pair<? super Integer> p, Integer first, Integer last) {
		p.setFirst(first);
		p.setLast(last);
		System.out.println(p.getFirst());
	}
	static void someMethod(List<? super Integer> list) {
	    list.add(123);
	    list.add(12);
	    //Integer n = list.get(0); // ERROR
	    Object n = list.get(0);
	    System.out.println(n);
	    System.out.println(list);
	}
}
