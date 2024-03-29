package 数组;

import java.util.ArrayList;
// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
//350. 两个数组的交集 II
//给定两个数组，编写一个函数来计算它们的交集。
//
// 
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//示例 2:
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
// 
//
//说明：
//
//输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
//我们可以不考虑输出结果的顺序。
//进阶：
//
//如果给定的数组已经排好序呢？你将如何优化你的算法？
//如果 nums1 的大小比 nums2 小很多，哪种方法更优？
//如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//cc 20201102

public class _350_两个数组的交集2 {
	public int[] intersect(int[] nums1, int[] nums2) {
        return getIersect(nums1, nums2);
    }

    public int[] getIersect(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			getIersect(nums2, nums1);
		} 
		ArrayList<Integer> list = new ArrayList<>();
		for(int num : nums2) {
			list.add(num);
		}
		
		ArrayList<Integer> array = new ArrayList<>();
		for(int num : nums1) {
			if(list.contains(num)) {
				array.add(num);
				list.set(list.indexOf(num), null);
                // list.remove(list.indexOf(num));
			}
		}
		
		int[] arr = new int[array.size()];
		int index = 0;
		for(int num : array) {
			arr[index++] = num;
		}
		
		return arr;
    }
}
