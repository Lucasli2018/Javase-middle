package com.lucas.leecode.start;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class 求众数 {
	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int n=map.get(nums[i])+1;
                if(n>nums.length/2.0){
                    nums[0]=nums[i];
                }
                map.put(nums[i], n);
                continue;
            }
            map.put(nums[i], 1);
        }    
        System.out.println(nums[0]);
        return nums[0];
    }
	@Test
	public void test(){
		assertEquals(2,majorityElement(new int[]{2,2,1}));
		assertEquals(3,majorityElement(new int[]{3,2,3}));
		assertEquals(2,majorityElement(new int[]{2,2,1,1,1,2,2}));
	}
}
