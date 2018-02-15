package cn.freedom.algorithm.twosum;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/articles/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 利用哈希表将查找的时间复杂度降到O(1)
 */

public class TwoSum {
	
	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] nums = {-3, 4, 1, 6, 0, 9};
		int target = 9;
		int[] indexs = t.twoSum2(nums, target);
		System.out.println(indexs[0] + "  " + indexs[1]);
	}
	
	public int[] twoSum1(int nums[], int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int n = target - nums[i];
			if(map.containsKey(n) && map.get(n) != i) {
				return new int[] {i, map.get(n)};
			}
		}
		
		throw new IllegalArgumentException("没有可行的两个数的方案！");
	}
	
	public int[] twoSum2(int nums[], int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int n = target - nums[i];
			if(map.containsKey(n)) {
				return new int[] {i, map.get(n)};
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("没有可行的两个数的方案！");
	}

}
