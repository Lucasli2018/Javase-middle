package com.lucas.javase.collection.Iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		ReadOnlyList<String> list = new ReadOnlyList<>("apple", "pear", "orange");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println();
		//Iterator
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String type = iterator.next();
			System.out.println(type);
		}
	}

}
