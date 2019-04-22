package com.lucas.leecode.start;

import static org.junit.Assert.*;

import org.junit.Test;

public class 只出现一次的数字 {

	/**
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
	 * @param args
	 */
	public static int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    nums[i]=nums[j]=0;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[0]=nums[i];
            }
        }
        System.out.println(nums[0]);
        return nums[0];
    }
	
	@Test
	public void test(){
		assertEquals(1,singleNumber(new int[]{2,2,1}));
		assertEquals(4,singleNumber(new int[]{4,1,2,1,2}));
		assertEquals(8,singleNumber(new int[]{5,6,7,8,4,3,3,4,7,6,5}));
	}
}
