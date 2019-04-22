package com.lucas.leecode.start;

import static org.junit.Assert.assertEquals;

import java.awt.event.FocusEvent;

import org.junit.Test;

public class 搜索二维矩阵 {
	/**
	 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
	 * 
	 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int[] is : matrix) {
			for (int i : is) {
				if(target==i){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean searchMatrix2(int[][] matrix, int target) {
		int m=matrix.length;
		if(m==0)
			return false;
		int n=matrix[0].length;
		if(n==0)
			return false;
		int i=m-1;
		int j=0;
		while(i>=0&&j<n){
			if(matrix[i][j]==target)
				return true;
			else if(matrix[i][j]>target)
				i--;
			else
				j++;
		}
		return false;
	}
	
	@Test
	public void test(){
		int[][] matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		assertEquals(true,searchMatrix2(matrix,3));
		assertEquals(true,searchMatrix2(matrix,2));
	}
}
