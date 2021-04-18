package 数组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _349_两个数组的交集 {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 2, 1};
		int[] nums2 = new int[] {2, 2};
		int[] arr = intersection(nums1, nums2);
		
		for(int num : arr) {
			System.out.println(num);
		}		
	}
	
	// 结合有去重的功能
	public static int[] intersection(int[] nums1, int[] nums2) {
		
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		for(int num : nums1 ) {
			set1.add(num);
		}
		
		for (int num : nums2) {
            set2.add(num);
        }
		
		return getIntersection(set1, set2);
	}
	
	public static int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		if(set1.size() > set2.size()) {
			return getIntersection(set2, set1);
		}
		
		Set<Integer> set3 = new HashSet<>();
		for(int num : set1) {
			if(set2.contains(num)) {
				set3.add(num);
			}
		}
		
		int[] arr = new int[set3.size()];
		int index = 0;
		for(int num : set3) {
			arr[index++] = num;
		}
		
		return arr;
	}
}
