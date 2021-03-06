package com.lucas.javase.collection.Stack.practise;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = 12500;
		// 打印Integer.toHexString()的结果:
		System.out.println(Integer.toHexString(n));
		// 比较转换结果是否与JDK的一致:
		System.out.println(toHex(n));
	}

	/**
	 * 请用Stack将整数转换为十六进制字符串表示，即：
		
		toHex(12500) => "30d4"
		
		进制转换算法：
		
		1. 不断对整数除以16，得到商和余数，余数压栈
		2. 用得到的商重复步骤1
		3. 当商为0时，计算结束。将栈中的数依次弹出并组成String
	 * @param n
	 * @return
	 */
	static String toHex(int n) {
		// TODO:数组转为16进制数
		Deque<Character> stack=new LinkedList<>();
		int y=0;//余数
		//不断对整数除以16，得到商和余数，余数压栈
		while(n>0){
			int s=n/16;
			y=n%16;
			stack.push(digitToChar(y));
			n=s;
		}
		//System.out.println(stack);
		Character[] arr=stack.toArray(new Character[stack.size()]);
		char[] ar=new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ar[i]=arr[i];
		}
		String ss=new String(ar);
		return ss;
	}

	static char digitToChar(int m) {
		return DIGITS.charAt(m);
	}

	static final String DIGITS = "0123456789abcdef";

}
