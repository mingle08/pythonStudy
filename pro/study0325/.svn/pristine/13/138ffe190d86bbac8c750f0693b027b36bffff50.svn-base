package com.imooc.leetCode.question001;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] number = {2,5,7,9};
		int[] result = twoSum(number, 9);
		System.out.println(result[0] + ", " + result[1]);

	}
	
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			int num2 = target - num1;
			if(map.containsKey(num2)) {
				result[0] = map.get(num2);
				result[1] = i;
				return result;
			}
			map.put(num1, i);
		}
		
		return result;
	}

}
