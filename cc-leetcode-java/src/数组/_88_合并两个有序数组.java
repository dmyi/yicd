package 数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @date   2021年2月15日 上午8:06:57
 * @author cc
 *
 */
public class _88_合并两个有序数组 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1;
		int i2;
		int cur;
		i1 = m - 1;
		i2 = n - 1;
		cur = nums1.length - 1;
		while(i2 >= 0) {
			if(i1 >= 0 && nums1[i1] > nums2[i2]) {
				nums1[cur--] = nums1[i1--];
			} else {
				nums1[cur--] = nums2[i2--];
			}
		}
    }
}
