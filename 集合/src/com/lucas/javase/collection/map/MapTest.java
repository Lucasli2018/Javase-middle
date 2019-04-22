package com.lucas.javase.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 3 };
		System.out.println(Arrays.toString(arr));
		/*
		 * Map<Integer,Integer> map=new HashMap<>(); for(int
		 * i=0;i<arr.length;i++){ if(map.containsKey(arr[i])){ int
		 * n=map.get(arr[i])+1; map.put(arr[i], n); continue; } map.put(arr[i],
		 * 1); } for (Entry<Integer, Integer> kv : map.entrySet()) {
		 * System.out.println("key-->"+kv.getKey()+" value-->"+kv.getValue()); }
		 * for (Integer v : map.values()) { double m=v;
		 * System.out.println(" value-->"+v); if(v>=arr.length/2.0){
		 * System.out.println("众数-->"+v); } }
		 */
		int[] nums=new int[]{8,8,7,7,7};
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
	       for (Entry<Integer, Integer> kv : map.entrySet()) {
			System.out.println(kv.getKey()+"-->"+kv.getValue());
		}
		System.out.println(nums[0]);
	}

}
