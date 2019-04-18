package com.lucas.hackerrank.challenges.sockMerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	/**
	 * 约翰在一家服装店工作。他有一大堆袜子，他必须按颜色配对出售。给定一组表示每个袜子颜色的整数，确定有多少对具有匹配颜色的袜子。
	 * 
	 * @param n
	 *            袜子数
	 * @param ar
	 *            袜子数组
	 * @return 匹配袜子数
	 */
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		// TODO:
		int sum = 0;
		List<String> list = new ArrayList<>();
		List<String> socklist = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			Integer j = ar[i];
			String s = j.toString();
			list.add(s);
		}
		System.out.println("袜子：" + list);
		Map<String, Integer> map = new HashMap<>();
		for (String string : list) {
			if (!map.containsKey(string)) {
				map.put(string, 1);
			} else {
				socklist.add(string);
				map.remove(string);
				sum++;
			}
		}

		System.out.println("匹配数量：" + sum);
		String[] arrsock = new String[socklist.size()];
		for (int i = 0; i < socklist.size(); i++) {
			String string = socklist.get(i);
			arrsock[i] = string;
		}
		System.out.println("匹配到的袜子：" + Arrays.toString(arrsock));
		return sum;
	}

	static <T> String toString(List<T> list) {
		String s = "";
		for (T t : list) {
			s += t.toString();
		}
		return s;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.print("请输入袜子数量：");
		// int n = scanner.nextInt();
		int n = Integer.parseInt(scanner.nextLine().trim());
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] ar = new int[n];
		System.out.print("请输入袜子情况：");
		String s = scanner.nextLine();
		System.out.printf("袜子总数：%d,袜子情况：%s\n", n, s);

		String[] arItems = s.split(" ");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);
		System.out.println("匹配的袜子总数：" + result);
		scanner.close();
		/**
		 * If  is odd, print Weird
If  is even and in the inclusive range of  to , print Not Weird
If  is even and in the inclusive range of  to , print Weird
If  is even and greater than , print Not Weird
		 */
		int N=0;
		if(N%2==0&&(N>=2&&N<=5)){
			System.out.println("Not Weird");
		}

	}

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int level = 0;
		int valleys = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') {
				level++;
			} else if (s.charAt(i) == 'D') {
				if (level == 0) {
					valleys++;
				}
				level--;
			}
		}
		System.out.println("山谷数：" + valleys);
		return valleys;
	}

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int jump = 0;
		for (int i = 0; i < c.length - 1;) {
			int j = c[i];
			if (i + 2 > c.length - 1) {
				jump++;
				System.out.println("跳跃数：" + jump);
				return jump;
			} else if (c[i + 2] != 1) {
				jump++;
				i += 2;
			} else {
				jump++;
				i += 1;
			}

		}
		System.out.println("跳跃数：" + jump);
		return jump;
	}

	/*
	 * Complete the simpleArraySum function below.
	 */
	static int simpleArraySum(int[] ar) {
		int sum = 0;
		for (int i : ar) {
			sum += i;
		}
		System.out.println("总和：" + sum);
		return sum;
	}

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		int n = 3;
		int alice = 0;
		int bob = 0;
		for (int i = 0; i < n; i++) {
			if (a.get(i) > b.get(i)) {
				alice++;
			} else if (a.get(i) < b.get(i)) {
				bob++;
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(alice);
		list.add(bob);

		Integer[] arr = list.toArray(new Integer[list.size()]);
		System.out.println("得分情况：" + Arrays.toString(arr));
		return list;
	}

	// Complete the aVeryBigSum function below.
	static long aVeryBigSum(long[] ar) {
		long sum = 0L;
		for (long l : ar) {
			sum += l;
		}
		System.out.println("输出计算总和：" + sum);
		return sum;
	}

	// Complete the diagonalDifference function below.
	static int diagonalDifference(int[][] arr) {
		int n = arr.length;
		int a = 0;
		int b = 0;
		for (int i = 0; i < arr.length; i++) {
			int[] js = arr[i];
			a += js[i];
			b += js[n - i - 1];
		}

		System.out.println(a);
		System.out.println(b);
		int d = Math.abs(a - b);
		System.out.println("对角矩阵求和：" + d);
		return d;
	}

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		float positive = 0;
		float negative = 0;
		float zero = 0;
		int n = arr.length;
		for (int i : arr) {
			if (i > 0) {
				positive++;
			} else if (i < 0) {
				negative++;
			} else {
				zero++;
			}
		}
		System.out.printf("%.6f\n", positive / n);
		System.out.printf("%.6f\n", negative / n);
		System.out.printf("%.6f\n", zero / n);

	}

	// Complete the staircase function below.
	static void staircase(int n) {
		for (int i = 0; i < n; i++) {
			String sp="";
			String s="";
			for (int j = 0; j <n-i-1; j++) {
				sp+=" ";
			}
			for (int j = 0; j < i+1; j++) {
				s+="#";
			}
			System.out.println(sp+s);
		}
	}
	
	// Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	//排序
    	Arrays.sort(arr);
    	long min=(long)arr[0]+arr[1]+arr[2]+arr[3];
    	long max=(long)arr[4]+arr[1]+arr[2]+arr[3];
    	System.out.println(min+" "+max);
    	
    }

}
