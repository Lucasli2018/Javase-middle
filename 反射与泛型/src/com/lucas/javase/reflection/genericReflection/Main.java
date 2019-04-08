package com.lucas.javase.reflection.genericReflection;


import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Class<String> clazz = String.class;
		String s1 = clazz.newInstance();
		System.out.println(s1);

		Constructor<String> cons = clazz.getConstructor(String.class);
		String s2 = cons.newInstance("Hello");
		System.out.println(s2);

		@SuppressWarnings("unchecked")
		Pair<String>[] ps = (Pair<String>[]) new Pair[2];//泛型数组需要强制转型
		ps[0] = new Pair<>("a", "b");
		ps[1] = new Pair<>("x", "y");
		System.out.println(Arrays.toString(ps));
	}

}
