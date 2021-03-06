package com.lucas.javase.collection.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Pear");
		list.add("Orange");
		list.add(1, "lucas");
		//1 foreach
		for (String s : list) {
			System.out.println(s);
		}
		//2 toString
		System.out.println(list);
		//3 Iterator
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String ss = iterator.next();
			System.out.println(ss);
		}
		
		//数组Array 和List 转换
		//List 转Array
		String[] arr=list.toArray(new String[list.size()]);
		System.out.println("List 转Array");
		System.out.println("数组0:"+arr[0]);
		
		//Array 转List
		List<String> arrayList=new ArrayList<>(Arrays.asList(arr));
		System.out.println("Array 转List");
		System.out.println(arrayList);
	}

}
