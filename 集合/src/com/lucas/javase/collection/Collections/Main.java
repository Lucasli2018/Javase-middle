package com.lucas.javase.collection.Collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//List<String> list=new ArrayList<>(Arrays.asList("A", "B", "C"));
		List<String> readOnlyList = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("A", "B", "C")));
		
		System.out.println(readOnlyList);
		//list.add("D");//其实还是可以修改，所以创建readOnlyList以后需要丢弃list引用，防止修改
		System.out.println(readOnlyList);
		//readOnlyList.add("X");//java.lang.UnsupportedOperationException
		//readOnlyList.remove(0);//java.lang.UnsupportedOperationException
	}
}
