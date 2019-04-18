package com.lucas.hackerrank.challenges.sockMerchant;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class SolutionTest {

	/**
	 * 袜子商人
	 */
	@Test
	public void testSockMerchant() {
		assertEquals(1, Solution.sockMerchant(3, new int[]{1,2,2}));
		assertEquals(3, Solution.sockMerchant(8, new int[]{1,2,2,1,3,4,3,8}));
	}
	
	/**
	 * 爬山谷
	 */
	@Test
	public void testCountingValleys(){
		assertEquals(2,Solution.countingValleys(3, "DUUDDU"));
		assertEquals(1,Solution.countingValleys(8, "UDDDUDUU"));
		assertEquals(1,Solution.countingValleys(3, "D"));
	}
	
	/**
	 * 跳云
	 */
	@Test
	public void testJumpingOnClouds(){
		assertEquals(1,Solution.jumpingOnClouds(new int[]{0,0}));
		assertEquals(1,Solution.jumpingOnClouds(new int[]{0,1,0}));
		assertEquals(2,Solution.jumpingOnClouds(new int[]{0,0,0,1,0}));
	}
	
	/**
	 * 简单数组求和
	 */
	@Test 
	public void testSimpleArraySum(){
		assertEquals(6,Solution.simpleArraySum(new int[]{1,2,3}));
		assertEquals(20,Solution.simpleArraySum(new int[]{1,2,3,10,4}));
	}
	
	/**
	 * 比较数组
	 */
	@Test
	public void testcompareTriplets(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		List<Integer> a=new ArrayList<Integer>();
		a.add(100);
		a.add(230);
		a.add(33);
		List<Integer> b=new ArrayList<Integer>();
		b.add(2);
		b.add(60);
		b.add(60);
		assertEquals(list,Solution.compareTriplets(a, b));
	}
	
	/**
	 * 数组求和
	 */
	@Test
	public void testaVeryBigSum(){
		assertEquals(5000000015L,Solution.aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004 ,1000000005}));
		assertEquals(5000000025L,Solution.aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004 ,1000000015}));
	}
	
	@Test
	public void testdiagonalDifference(){
		int[] a=new int[]{1,2,3};
		int[] b=new int[]{4,5,6};
		int[] c=new int[]{9,8,9};
		int[][] arr=new int[][]{a,b,c};
		assertEquals(2,Solution.diagonalDifference(arr));
	}
	
	/**
	 * 统计比例
	 */
	@Test
	public void testplusMinus(){
		Solution.plusMinus(new int[]{-4, 3 ,-9, 0 ,4 ,1 });
		equals(true);
	}
	
	/**
	 * 爬楼梯
	 */
	@Test
	public void teststaircase(){
		Solution.staircase(6);
		equals(true);
	}
	
	@Test
	public void testminiMaxSum(){
		Solution.miniMaxSum(new int[]{1,2,3,4,5});
		Solution.miniMaxSum(new int[]{1,1,1,4,5,1});
		Solution.miniMaxSum(new int[]{256741038, 623958417,467905213 ,714532089, 938071625});
		equals(true);
	}
	
	@Test
	public void testScanner(){
		for(int i=0;i<1;i++){
            int a = 2;
            int b = 3;
            int n = 2;
            double tmp=a;
            for(int j=0;j<n;j++){
            	double t=b*Math.pow(2, j);
            	tmp+=t;
                System.out.printf("%.0f ",tmp);
                if(j==9){
                    System.out.print("\n");
                }
            }
        }
	}

}
