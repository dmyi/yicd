package com.cc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @date   2020年11月8日 下午7:52:29
 * @author cc
 *
 */
public class _169_多数元素 {
	
	private  Map<Integer, Integer> countNums(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		return map;
	}
	
	// 这段是抄官网的需要再练习理解一下
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = countNums(nums);
		
		Map.Entry<Integer, Integer> majorityEntry = null;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}
		
		return majorityEntry.getKey();
    }
}
